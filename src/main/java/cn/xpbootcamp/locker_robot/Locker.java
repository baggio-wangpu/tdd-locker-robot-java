package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.LockFullException;
import cn.xpbootcamp.locker_robot.exception.TicketInvalidException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Locker {

  private int capacity;
  private Map<UUID, Package> storedPacks = new HashMap<>();

  public Locker(int capacity) {
    this.capacity = capacity;
  }

  public Ticket store(Package pack) {
    if (!isFull()) {
      Ticket ticket = new Ticket();
      storedPacks.put(ticket.getPackageId(), pack);
      return ticket;
    }
    throw new LockFullException("Lock is full...");
  }


  public Package get(Ticket ticket) {
    if (storedPacks.containsKey(ticket.getPackageId())) {
      return storedPacks.get(ticket.getPackageId());
    }
    throw new TicketInvalidException("Ticket is invalid...");
  }

  private boolean isFull() {
    return storedPacks.size() >= capacity;
  }
}
