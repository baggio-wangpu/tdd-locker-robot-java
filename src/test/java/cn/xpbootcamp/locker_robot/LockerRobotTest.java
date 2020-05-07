package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Locker;
import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.LockFullException;
import cn.xpbootcamp.locker_robot.exception.TicketInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LockerRobotTest {

  @Test
  void should_store_package_successfully_when_provide_package_given_locker_is_not_full() {
    // given:
    Locker locker = new Locker(0);
    Package pack = new Package();
    LockerRobot lockerRobot = new LockerRobot(locker);

    // when:
    Ticket ticket = lockerRobot.store(pack);

    // then:
    assertNotNull(ticket);
    assertEquals(1, locker.getUsed());
  }

  @Test
  void should_store_package_failed_when_provide_package_given_locker_is_full() {
    // given:
    Locker locker = new Locker(5);
    Package pack = new Package();
    LockerRobot lockerRobot = new LockerRobot(locker);

    // when:
    LockFullException lockFullException = assertThrows(LockFullException.class, () -> lockerRobot.store(pack));

    // then:
    assertEquals("Lock is full...", lockFullException.getMessage());
    assertEquals(5, locker.getUsed());
  }

  @Test
  void should_get_package_successfully_when_provide_ticket_given_ticket_is_valid() {
    // given:
    Locker locker = new Locker(4);
    Package storedPack = new Package();
    LockerRobot lockerRobot = new LockerRobot(locker);
    Ticket ticket = lockerRobot.store(storedPack);

    // when:
    Package pack = lockerRobot.get(ticket);
    // then:
    assertEquals(storedPack, pack);
  }

  @Test
  void should_get_package_failed_when_provide_ticket_given_ticket_is_invalid() {
    // given:
    Locker locker = new Locker(4);
    LockerRobot lockerRobot = new LockerRobot(locker);

    // when:
    Ticket invalidTicket = new Ticket();
    TicketInvalidException ticketInvalidException = assertThrows(TicketInvalidException.class,
        () -> lockerRobot.get(invalidTicket));
    // then:
    assertEquals("Ticket is invalid...", ticketInvalidException.getMessage());
  }
}
