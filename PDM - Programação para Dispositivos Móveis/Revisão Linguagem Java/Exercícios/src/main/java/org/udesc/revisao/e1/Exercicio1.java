package org.udesc.revisao.e1;

import java.util.Scanner;

public class Exercicio1 {
  private GameEntry ranking[];
  private static final int RANKING_SIZE = 10;

  public Exercicio1() {
    ranking = new GameEntry[RANKING_SIZE];
  }

  public void populateRanking() {
    Scanner scanner = new Scanner(System.in);

    try {
      for (int i = 0; i < ranking.length; i++) {
        System.out.println("Informe o nome do jogador " + (i + 1) + ": ");
        String name = scanner.next();

        System.out.println("Informe a pontuação jogador " + (i + 1) + ": ");
        int score = scanner.nextInt();

        ranking[i] = new GameEntry(name, score);
      }
    } catch (Exception e) {
      System.err.println("Ocorreu um erro ao capturar dados da entrada padrão: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }

  public void showRanking() {
    int count = 0;

    System.out.println("Posição\tJogador\tPontuação");

    for (GameEntry entry: ranking) {
      if (entry != null) {
        System.out.println(++count + "\t" + entry.getName() + "\t" + entry.getScore());
      }
    }
  }

  public static void main(String[] args) {
    Exercicio1 e1 = new Exercicio1();

    e1.populateRanking();
    e1.showRanking();
  }
}
