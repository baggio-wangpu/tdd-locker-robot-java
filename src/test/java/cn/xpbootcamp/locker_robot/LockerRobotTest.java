package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Locker;
import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.LockFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
