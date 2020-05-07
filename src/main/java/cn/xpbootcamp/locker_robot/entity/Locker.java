package cn.xpbootcamp.locker_robot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Locker {

  public static final int CAPACTITY = 5;

  private int used;
}
