package cn.xpbootcamp.locker_robot;

import cn.xpbootcamp.locker_robot.entity.Package;
import cn.xpbootcamp.locker_robot.entity.Ticket;
import cn.xpbootcamp.locker_robot.exception.AllLockersFullException;
import cn.xpbootcamp.locker_robot.exception.TicketInvalidException;

import java.util.List;
import java.util.Optional;

public class LockerRobot {

  private List<Locker> lockerList;

  public LockerRobot(List<Locker> lockerList) {
    this.lockerList = lockerList;
  }

  public Ticket store(Package pack) {
    Ticket ticket = null;
    for(Locker locker : lockerList) {
      if (!locker.isFull()) {
        ticket = locker.store(pack);
        break;
      }
    }
    if (ticket == null) {
      throw new AllLockersFullException();
    }
    return ticket;
  }

  public Package get(Ticket ticket) {
    Optional<Locker> storedLocker = lockerList.stream()
        .filter(locker -> locker.getStoredPacks().containsKey(ticket.getPackageId()))
        .findFirst();
    if (storedLocker.isPresent()) {
      return storedLocker.get().get(ticket);
    } else {
      throw new TicketInvalidException();
    }
  }
}
