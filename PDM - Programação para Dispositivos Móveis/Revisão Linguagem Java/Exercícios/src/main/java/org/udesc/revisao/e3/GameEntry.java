package org.udesc.revisao.e3;

public class GameEntry implements Comparable<GameEntry>{
  private String name;
  private int score;

  public GameEntry(final String name, final int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public int compareTo(GameEntry o) {
    return o.getScore() - getScore();
  }
}
