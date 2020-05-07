package cn.xpbootcamp.locker_robot.exception;

public class LockFullException extends RuntimeException {
  public LockFullException(String message) {
    super(message);
  }
}
