package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.exception.LockFullException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Locker {

  public static final int CAPACTITY = 5;

  private int used;

  public Ticket store(Package pack) {
    if (!isFull()) {
      used ++;
      return new Ticket(pack);
    }
    throw new LockFullException("Lock is full...");
  }

  private boolean isFull() {
    return used == CAPACTITY;
  }
}
