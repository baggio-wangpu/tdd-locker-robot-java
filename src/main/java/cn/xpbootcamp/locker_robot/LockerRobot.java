package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Locker;
import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.LockFullException;
import cn.xpbootcamp.locker_robot.exception.TicketInvalidException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static cn.xpbootcamp.locker_robot.entity.Locker.CAPACTITY;

@Getter
public class LockerRobot {

  private Locker locker;
  private Map<Ticket, Package> storedPacks = new HashMap<>();

  public LockerRobot(Locker locker) {
    this.locker = locker;
  }

  public Ticket store(Package pack) {
    if (!isFull()) {
      locker.setUsed(locker.getUsed() + 1);
      Ticket ticket = new Ticket();
      storedPacks.put(ticket, pack);
      return ticket;
    }
    throw new LockFullException("Lock is full...");
  }


  public Package get(Ticket ticket) {
    if (storedPacks.containsKey(ticket)) {
      locker.setUsed(locker.getUsed() - 1);
      return storedPacks.get(ticket);
    }
    throw new TicketInvalidException("Ticket is invalid...");
  }

  private boolean isFull() {
    return locker.getUsed() == CAPACTITY;
  }
}
