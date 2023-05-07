//Victor Eduardo Requia
//TEG 2021/1

//                   Metodos do grafo
//imprimirListaAdjacencia -> irá imprimir a lista de adjacência do grafo
//novoVertice -> irá adicionar um novo vértice ao grafo
//novaConexao -> irá fazer uma conexão entre dois vértices
//BFS -> irá fazer uma Busca em largura no grafo

import 'dart:io';
import 'grafo.dart';
import 'vertice.dart';

Grafo grafo = new Grafo();
//Variavel para fazer o grafo usando MENU (true) ou hardcode (false)
bool exibirMenu = false;

void main() {
  if (exibirMenu == true) {
    menu();
  } else {
    novoVertice('0');
    novoVertice('1');
    novoVertice('2');
    novoVertice('3');
    novoVertice('4');
    novoVertice('5');
    novoVertice('6');

    //Grafos da lista grafo_bfs.txt
    //Grafo1
    novaConexao('1', '5');
    novaConexao('1', '2');
    novaConexao('2', '5');
    novaConexao('2', '3');
    novaConexao('3', '4');
    novaConexao('4', '5');
    novaConexao('4', '6');

    //Grafo2
    /*
    novaConexao('0', '1');
    novaConexao('0', '2');
    novaConexao('1', '2');
    novaConexao('2', '3');
    */

    imprimirListaAdjacencia();

    //A função recebe o indíce da posição inicial
    bfs(grafo.vertices[3]);
  }
}

List<Vertice> visitados = [];
List<Vertice> fila = [];
bfs(Vertice vertice_inicial) {
  print('=' * 13 + 'BFS' + '=' * 13);
  vertice_inicial.visitado = true;

  fila.add(vertice_inicial);
  visitados.add(vertice_inicial);

  while (fila.isNotEmpty) {
    Vertice visitando = fila[0];
    visitando.adjacentes.forEach((element) {
      if (!element.visitado) {
        element.visitado = true;
        fila.add(element);
        visitados.add(element);
        print('Visitando o vertice: $element');
      }
    });
    fila.removeAt(0);
  }
  print('Sequência: ' + visitados.join('->'));
  print('=' * 29);

  for (int i = 0; i < visitados.length; i++) {
    grafo.vertices[i].visitado = false;
  }
  visitados.clear();
}

novoVertice(String nome) {
  grafo.vertices.add(Vertice(nome));
  if (exibirMenu) {
    print('Vertice $nome adicionado com sucesso');
  }
}

novaConexao(String vertice1, String vertice2) {
  int vertice1_index =
      grafo.vertices.indexWhere((element) => element.nome == vertice1);
  int vertice2_index =
      grafo.vertices.indexWhere((element) => element.nome == vertice2);

  if (vertice1_index == -1 || vertice2_index == -1) {
    print(
        'Não foi possivel conectar os vértices pois o(s) nomes não estão corretos');
    return;
  } else {
    grafo.vertices[vertice1_index].adjacentes
        .add(grafo.vertices[vertice2_index]);
    grafo.vertices[vertice2_index].adjacentes
        .add(grafo.vertices[vertice1_index]);

    if (exibirMenu == true) {
      print('Conexao realizada com sucesso');
    }
  }
}

imprimirListaAdjacencia() {
  if (grafo.vertices.isEmpty) {
    print('O grafo não possui vértices');
    return;
  }

  grafo.vertices.forEach((element) {
    print('${element.nome} ${element.adjacentes}');
  });
}

menu() {
  var escolha;

  while (escolha != 0) {
    print('O que você deseja?\n');
    print(
        '0 - Sair\n1 - Novo vértice\n2 - Nova conexão\n3 - Imprimir lista de adjacencia\n4 - Realizar uma busca em profundidade');
    escolha = stdin.readLineSync();
    escolha = int.parse(escolha);

    switch (escolha) {
      case 1:
        print('Nome do novo vértice: ');
        try {
          String nome = stdin.readLineSync().toString();
          novoVertice(nome);
        } catch (e) {
          print('Erro ao adicionar vértice');
          return;
        }
        break;
      case 2:
        if (grafo.vertices.length < 2) {
          print('O grafo não possui 2 ou mais vértices para fazer a conexão');
          return;
        }

        print('Escolha 2 vertices para fazer a conexao');
        List<String> nomes = [];
        grafo.vertices.forEach((element) {
          nomes.add(element.nome);
        });
        print(nomes);

        print('Primeiro vertice: ');
        String vertice1 = stdin.readLineSync().toString();
        print('Segundo vertice: ');
        String vertice2 = stdin.readLineSync().toString();

        novaConexao(vertice1, vertice2);
        break;
      case 3:
        imprimirListaAdjacencia();
        break;
      case 4:
        print('Qual o vertice incicial ?');
        String vertice1 = stdin.readLineSync().toString();
        int indice =
            grafo.vertices.indexWhere((element) => element.nome == vertice1);
        bfs(grafo.vertices[indice]);
    }
  }
}
