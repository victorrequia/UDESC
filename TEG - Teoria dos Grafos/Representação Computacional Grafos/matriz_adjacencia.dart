//aluno: Victor Eduardo Requia  27/05/2021;
void main() {
  var grafo = new Map();

  //Adicionando os vértices ao grafo
  for (int i = 0; i < 22; i++) {
    novoNo(grafo);
  }

  //Ligando arestas ao vértices
  novaConexao(grafo, 0, 1, 136);
  novaConexao(grafo, 1, 2, 75);
  novaConexao(grafo, 2, 3, 135);
  novaConexao(grafo, 3, 4, 76);
  novaConexao(grafo, 4, 5, 77);
  novaConexao(grafo, 5, 6, 159);
  novaConexao(grafo, 6, 7, 154);
  novaConexao(grafo, 7, 8, 313);
  novaConexao(grafo, 8, 9, 148);
  novaConexao(grafo, 9, 10, 154);
  novaConexao(grafo, 10, 11, 148);
  novaConexao(grafo, 11, 12, 146);
  novaConexao(grafo, 12, 13, 159);
  novaConexao(grafo, 13, 14, 162);
  novaConexao(grafo, 14, 15, 203);
  novaConexao(grafo, 15, 16, 155);
  novaConexao(grafo, 16, 17, 123);
  novaConexao(grafo, 17, 18, 116);
  novaConexao(grafo, 18, 19, 150);
  novaConexao(grafo, 19, 20, 150);
  novaConexao(grafo, 20, 21, 160);
  novaConexao(grafo, 21, 6, 153);
  novaConexao(grafo, 11, 21, 157);
  novaConexao(grafo, 14, 18, 161);

  mostraMatrizAdjacente(grafo);
  print('\n');
  print('=' * 10 + 'Distância' + '=' * 10);
  verificarAdjacencia(grafo, 2, 1);
  verificarAdjacencia(grafo, 1, 2);
  verificarAdjacencia(grafo, 11, 21);
  verificarAdjacencia(grafo, 5, 7);
  print('=' * 29);
  print('\n');
  contaGrau(grafo);
  print('\n');
  verificarSubgrafo(grafo, [
    1,
    2,
    3,
  ], [
    [3, 2],
    [5, 3]
  ]);
  print('\n');
  contaArestas(grafo);
  print('\n');
  grafoCompleto(grafo);
}

verificarSubgrafo(Map grafo, List<int> vertices, List<List<int>> arestas) {
  print('=' * 10 + 'Verificar se é um subgrafo' + '=' * 10);

  print('Os vértices ${vertices.join(" ")}');
  print('Com as arestas ');
  for (var aresta in arestas) {
    print('${aresta[0]} -> ${aresta[1]}');
  }

  for (int i = 0; i < vertices.length; i++) {
    if (!(grafo.containsKey(vertices[i]))) {
      print('Não foram um subgrafo');
    }
  }

  for (List<int> aresta in arestas) {
    if (distanciaVertices(grafo, aresta[0], aresta[1]) == null) {
      print("Não formam um subgrafo");
      print('=' * 46);
      return;
    }
  }
  print('Formam um subgrafo');

  print('=' * 46);
}

void verificarAdjacencia(Map grafo, int a, int b) {
  List<List<int>> linha_grafo = grafo[a];
  if (linha_grafo[b][0] == 1) {
    print(
        'O vertice $a e $b são adjacentes e a distância é ${linha_grafo[b][1]} m');
  } else {
    print('O vertice $a e $b não são adjacentes');
  }
}

distanciaVertices(Map grafo, int a, int b) {
  List<List<int>> linha_grafo = grafo[a];
  if (linha_grafo[b][0] == 1) {
    return linha_grafo[b][1];
  } else {
    return null;
  }
}

contaArestas(Map grafo) {
  print('=' * 10 + 'Arestas' + '=' * 10);
  int total_linhas = grafo.length;
  int arestas = 0;
  if (total_linhas != 0) {
    for (int i = 0; i < total_linhas; i++) {
      List<List<int>> linha_grafo = grafo[i];
      for (int j = 0; j < linha_grafo.length; j++) {
        if (linha_grafo[j][0] == 1) {
          arestas += 1;
        }
      }
    }
    arestas = (arestas / 2).floor();
    print('O grafo possui $arestas arestas');
  } else {
    print('Não existe grafo');
  }
  print('=' * 27);
}

contaGrau(Map grafo) {
  print('=' * 10 + 'Grau dos vértices' + '=' * 10);
  for (int i = 0; i < grafo.length; i++) {
    List<List<int>> linha_grafo = grafo[i];
    int soma = 0;
    for (int l = 0; l < linha_grafo.length; l++) {
      soma += linha_grafo[l][0];
    }
    print("O grau do vértice $i é $soma");
  }
  print('=' * 37);
}

grafoCompleto(Map grafo) {
  print('=' * 10 + "Grafo Completo" + "=" * 10);
  int soma = 0;
  int numVertices = grafo.length - 1;

  for (int i = 0; i < numVertices; i++) {
    soma = 0;
    List<List<int>> linha_grafo = grafo[i];
    for (int l = 0; l < linha_grafo.length; l++) {
      soma += linha_grafo[l][0];
    }
    if (soma != numVertices - 1) {
      print('O grafo não é completo');
      print('=' * 34);
      return;
    }
  }
  print('O grafo é completo');
  print('=' * 34);
}

novaConexao(Map grafo, int no1, int no2, int distancia) {
  int linha_grafo = no1;
  int coluna_grafo = no2;

  List<List<int>> linha_aux = grafo[linha_grafo];
  List<List<int>> linha_aux2 = grafo[coluna_grafo];

  if ((no1 == no2) &&
      (linha_aux[coluna_grafo] != 0) &&
      (linha_aux2[linha_grafo] != 0)) {
    linha_aux[coluna_grafo] += [1, 0];
  } else {
    linha_aux[coluna_grafo] = [1, distancia];
    linha_aux2[linha_grafo] = [1, distancia];
  }
}

novoNo(Map grafo) {
  if (grafo.isEmpty) {
    List<List<int>> linha0 = [];
    linha0.add([0, 0]);
    grafo[0] = linha0;
  } else {
    int total_linhas = grafo.length;
    List<List<int>> nova_linha = [];
    for (int i = 0; i < total_linhas; i++) {
      nova_linha.add([0, 0]);
    }
    grafo[total_linhas] = nova_linha;
    completaColunas(grafo, total_linhas);
  }
}

completaColunas(Map grafo, int linhas) {
  for (int k = 0; k < grafo.length; k++) {
    List<List<int>> linha = grafo[k];
    for (int i = 0; i < grafo.length - linha.length; i++) {
      linha.add([0, 0]);
    }
  }
}

mostraMatrizAdjacenteComDistancia(Map grafo) {
  for (int i = 0; i < grafo.length; i++) {
    print("${grafo[i].join(" ")}  -> $i");
  }
}

mostraMatrizAdjacente(Map grafo) {
  print('=' * 15 + "Matriz Adjacente" + '=' * 15);
  int tamanho_grafo = grafo.length;
  List<int> coluna_grafo = [];
  if (tamanho_grafo >= 10) {
    for (int i = 0; i < 10; i++) {
      coluna_grafo.add(i);
    }
    print("${coluna_grafo.join(" ")}");
    print("_ " * coluna_grafo.length);
  } else {
    for (int i = 0; i < tamanho_grafo; i++) {
      coluna_grafo.add(i);
    }
    print("${coluna_grafo.join(" ")}");
    print("_ " * coluna_grafo.length);
  }

  for (int i = 0; i < grafo.length; i++) {
    List<List<int>> linha = grafo[i];
    List<int> adjacencia = [];
    for (int j = 0; j < linha.length; j++) {
      adjacencia.add(linha[j][0]);
    }
    print('${adjacencia.join(" ")} |$i');
  }
  print('=' * 46);
}
