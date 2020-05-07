package cn.xpbootcamp.locker_robot;

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
      return new Ticket();
    }
    return null;
  }

  private boolean isFull() {
    return used == CAPACTITY;
  }
}
