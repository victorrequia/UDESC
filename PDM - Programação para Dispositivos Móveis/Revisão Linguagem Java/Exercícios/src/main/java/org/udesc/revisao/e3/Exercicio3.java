package org.udesc.revisao.e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio3 {
  private ArrayList ranking;

  public Exercicio3() {
    ranking = new ArrayList();
  }

  public void populateRanking() {
    ranking.clear();

    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println("Informe a quantidade de jogadores: ");
      int size = scanner.nextInt();

      for (int i = 0; i < size; i++) {
        System.out.println("Informe o nome do jogador " + (i + 1) + ": ");
        String name = scanner.next();

        System.out.println("Informe a pontuação jogador " + (i + 1) + ": ");
        int score = scanner.nextInt();

        ranking.add(new GameEntry(name, score));
      }
    } catch (Exception e) {
      System.err.println("Ocorreu um erro ao capturar dados da entrada padrão: " + e.getMessage());
    } finally {
      scanner.close();
    }

    Collections.sort(ranking);
  }

  public void showRanking() {
    int count = 0;

    System.out.println("Posição\tJogador\tPontuação");

    for (Object object: ranking) {
      GameEntry entry = (GameEntry) object;
      if (entry != null) {
        System.out.println(++count + "\t" + entry.getName() + "\t" + entry.getScore());
      }
    }
  }

  public static void main(String[] args) {
    Exercicio3 e3 = new Exercicio3();

    e3.populateRanking();
    e3.showRanking();
  }
}
