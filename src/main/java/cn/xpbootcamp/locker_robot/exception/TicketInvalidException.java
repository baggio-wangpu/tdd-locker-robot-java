package cn.xpbootcamp.locker_robot.exception;

public class TicketInvalidException extends RuntimeException {
  public TicketInvalidException(String message) {
    super(message);
  }
}
