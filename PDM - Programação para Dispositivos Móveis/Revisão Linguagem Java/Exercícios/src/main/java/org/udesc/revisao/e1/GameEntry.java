package org.udesc.revisao.e1;

public class GameEntry {
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
}
