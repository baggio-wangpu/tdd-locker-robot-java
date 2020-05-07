package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Locker;
import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.LockFullException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static cn.xpbootcamp.locker_robot.entity.Locker.CAPACTITY;

@Getter
@AllArgsConstructor
public class LockerRobot {

  private Locker locker;

  public Ticket store(Package pack) {
    if (!isFull()) {
      locker.setUsed(locker.getUsed() + 1);
      return new Ticket(pack);
    }
    throw new LockFullException("Lock is full...");
  }

  private boolean isFull() {
    return locker.getUsed() == CAPACTITY;
  }
}
