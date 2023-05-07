//Victor Eduardo Requia
//TEG 2021/1

//                   Metodos do grafo
//imprimirListaAdjacencia -> irá imprimir a lista de adjacência do grafo
//novoVertice -> irá adicionar um novo vértice ao grafo
//novaConexao -> irá fazer uma conexão entre dois vértices
//BFS -> irá fazer uma Busca em largura no grafo

import 'grafo.dart';
import 'vertice.dart';

Grafo grafo = new Grafo();
//Variavel para fazer o grafo usando MENU (true) ou hardcode (false)
bool exibirMenu = false;
List<Vertice> visitados = [];
void main() {
  //Grafo2 (exemplo em sala) ponderado e direcionado
  novoVertice('S'); //0
  novoVertice('V'); //1
  novoVertice('W'); //2
  novoVertice('T'); //3

  novaConexao('S', 'V', 1);
  novaConexao('S', 'W', 4);
  novaConexao('V', 'T', 6);
  novaConexao('V', 'W', 2);
  novaConexao('W', 'T', 3);

  dijkstra(grafo.vertices[0], grafo.vertices[3]);
}

dijkstra(Vertice origem, Vertice destino) {
  List<Vertice> explorados = [];
  Map<Vertice, double> d = {};
  Map<Vertice, Vertice> p = {};
  for (Vertice vertice in grafo.vertices) {
    d[vertice] = 999;
    p[vertice] = origem;
  }
  d[origem] = 0;
  while (explorados.length != grafo.vertices.length) {
    Vertice u = menor(d, origem);
    explorados.add(u);
    u.visitado = true;
    for (Vertice vertice in u.adjacentes.keys) {
      if (vertice.visitado == false) {
        if (d[u]! + custo(u, vertice) < double.parse(d[vertice].toString())) {
          d[vertice] = double.parse(d[u].toString()) + custo(u, vertice);
          p[vertice] = u;
        }
      }
    }
  }
  print('O melhor caminho é:');
  print(origem.nome);
  caminho(p, destino);
}

caminho(Map<Vertice, Vertice> p, Vertice destino) {
  if (destino != p.keys.first) {
    caminho(p, p[destino]!);
    print(destino.nome);
  }
  return;
}

menor(Map<Vertice, double> d, origem) {
  List<Vertice> inexplroados = [];
  for (Vertice vertice in d.keys) {
    if (vertice.visitado == false) {
      inexplroados.add(vertice);
    }
  }

  Vertice menor = inexplroados[0];
  for (Vertice vertice in inexplroados) {
    if (d[vertice]! < d[menor]!) {
      menor = vertice;
    }
  }

  return menor;
}

custo(Vertice u, Vertice v) {
  double distancia = double.parse(u.adjacentes[v].toString());
  return distancia;
}

menorInexplorado(List<Map<Vertice, double>> adjacentes) {
  double menor = 0;
  Vertice menor_vertice = adjacentes[0].keys.first;
  for (Map<Vertice, double> adjacente in adjacentes) {
    double aux = adjacente.values.first;
    if (aux < menor) {
      menor = aux;
      menor_vertice = adjacente.keys.first;
    }
  }
  return menor_vertice;
}

void novoVertice(String nome) {
  grafo.vertices.add(Vertice(nome));
}

void novaConexao(String vertice1, String vertice2, double peso) {
  int vertice1_index =
      grafo.vertices.indexWhere((element) => element.nome == vertice1);
  int vertice2_index =
      grafo.vertices.indexWhere((element) => element.nome == vertice2);

  if (vertice1_index == -1 || vertice2_index == -1) {
    print(
        'Não foi possivel conectar os vértices pois o(s) nomes não estão corretos');
    return;
  } else {
    grafo.vertices[vertice1_index].adjacentes[grafo.vertices[vertice2_index]] =
        peso;
  }
}

void imprimirListaAdjacencia() {
  if (grafo.vertices.isEmpty) {
    print('O grafo não possui vértices');
    return;
  }

  grafo.vertices.forEach((element) {
    print('${element.nome} ${element.adjacentes}');
  });
}
