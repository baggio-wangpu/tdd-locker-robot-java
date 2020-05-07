package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.LockFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LockerRobotTest {

  @Test
  void should_store_package_successfully_when_provide_package_given_locker_is_not_full() {
    // given:
    Locker locker = new Locker(0);
    Package pack = new Package();

    // when:
    Ticket ticket = locker.store(pack);

    // then:
    assertNotNull(ticket);
    assertEquals(1, locker.getUsed());
  }

  @Test
  void should_store_package_failed_when_provide_package_given_locker_is_full() {
    // given:
    Locker locker = new Locker(5);
    Package pack = new Package();

    // when:
    LockFullException lockFullException = assertThrows(LockFullException.class, () -> locker.store(pack));

    // then:
    assertEquals("Lock is full...", lockFullException.getMessage());
    assertEquals(5, locker.getUsed());
  }
}
