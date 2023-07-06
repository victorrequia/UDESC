package org.udesc.revisao.e4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercicio4 {
  private ArrayList<GameEntry> ranking;

  public Exercicio4() {
    ranking = new ArrayList<>();
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

    for (GameEntry entry: ranking) {
      System.out.println(++count + "\t" + entry.getName() + "\t" + entry.getScore());
    }
  }

  public static void main(String[] args) {
    Exercicio4 e4 = new Exercicio4();

    e4.populateRanking();
    e4.showRanking();
  }
}
