//Victor Eduardo Requia
//TEG 2021/1

//                   Metodos do grafo
//imprimirListaAdjacencia -> irá imprimir a lista de adjacência do grafo
//novoVertice -> irá adicionar um novo vértice ao grafo
//novaConexao -> irá fazer uma conexão entre dois vértices
//BFS -> irá fazer uma Busca em largura no grafo
import 'auxiliares/pilha.dart';
import 'grafo.dart';
import 'vertice.dart';

Grafo grafo = new Grafo();
List<Vertice> visitados = [];
Pilha pilha = Pilha(); //Para dfs

void main() {
  //Ancestrais
  novoVertice('Marie'); //0
  novoVertice('Juca'); //1
  novoVertice('Caju'); //2
  novoVertice('Alice'); //3
  novoVertice('Bob'); //4
  novoVertice('Perf'); //5

  //Filhos e netos dos ancestrais
  novoVertice('Olivier'); //6
  novoVertice('Gin'); //7
  novoVertice('Gina'); //8
  novoVertice('Bonnie'); //9
  novoVertice('Zec'); //10
  novoVertice('Pedro'); //11
  novoVertice('Elis'); //12

  //Grafo Fazenda
  novaConexao('Marie', 'Zec');
  novaConexao('Juca', 'Olivier');
  novaConexao('Juca', 'Gin');
  novaConexao('Caju', 'Olivier');
  novaConexao('Caju', 'Gin');
  novaConexao('Alice', 'Gina');
  novaConexao('Alice', 'Bonnie');
  novaConexao('Bob', 'Gina');
  novaConexao('Bob', 'Bonnie');
  novaConexao('Perf', 'Elis');
  novaConexao('Olivier', 'Zec');
  novaConexao('Gin', 'Pedro');
  novaConexao('Gina', 'Pedro');
  novaConexao('Bonnie', 'Elis');

  dfsFazenda(grafo.vertices[3], grafo.vertices[9]);
}

dfsFazenda(Vertice A, Vertice B) {
  for (int i = 0; i < 6; i++) {
    //Inicio DFS
    pilha.push(pilha, grafo.vertices[i]);
    while (!pilha.isEmpty(pilha)) {
      Vertice v = pilha.pop(pilha);
      if (!v.visitado) {
        v.visitado = true;
        print('Vertice visitado: ${v.nome}');
        visitados.add(v);
        for (int i = 0; i < v.adjacentes.length; i++) {
          if (v.adjacentes[i].visitado == false) {
            pilha.push(pilha, v.adjacentes[i]);
          }
        }
      }
    }
    //Fim DFS
    print("Visitados -> $visitados");
    int contadorParentesco = 0;
    for (int j = 0; j < visitados.length; j++) {
      if (visitados[j].nome == A.nome || visitados[j].nome == B.nome) {
        contadorParentesco++;
      }
    }
    if (contadorParentesco == 2) {
      print("${A.nome} e ${B.nome} possuem grau de parentesco");
      return true;
    }

    contadorParentesco = 0;
    resetarVisitados();
    print("\n");
  }
  print('${A.nome} e ${B.nome} não tem relação de parentesco');
  return false;
}

void resetarVisitados() {
  for (int i = 0; i < visitados.length; i++) {
    visitados[i].visitado = false;
  }
  visitados.clear();
}

void novoVertice(String nome) {
  grafo.vertices.add(Vertice(nome));
}

void novaConexao(String vertice1, String vertice2) {
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
  }
}
