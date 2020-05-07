package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerRobotTest {

  @Test
  void should_store_package_when_provide_package_given_locker_is_not_full() {
    // given:
    Locker locker = new Locker(0);
    Package pack = new Package();

    // when:
    Ticket ticket = locker.store(pack);

    // then:
    assertNotNull(ticket);
    assertEquals(1, locker.getUsed());
  }
}
