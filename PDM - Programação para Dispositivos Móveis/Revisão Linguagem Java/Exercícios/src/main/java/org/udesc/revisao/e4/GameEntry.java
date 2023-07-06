package org.udesc.revisao.e4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameEntry implements Comparable<GameEntry>{
  private String name;
  private int score;

  @Override
  public int compareTo(GameEntry o) {
    return o.getScore() - getScore();
  }
}
