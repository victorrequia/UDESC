import '../vertice.dart';

class Pilha {
  List<Vertice> lista = [];

  bool isEmpty(Pilha pilha) {
    return pilha.lista.isEmpty;
  }

  bool push(Pilha pilha, Vertice vertice) {
    try {
      pilha.lista.add(vertice);
      return true;
    } catch (e) {
      return false;
    }
  }

  pop(Pilha pilha) {
    try {
      int tamanho_pilha = pilha.lista.length;
      Vertice elemento = pilha.lista[tamanho_pilha - 1];
      pilha.lista.removeAt(tamanho_pilha - 1);
      return elemento;
    } catch (e) {
      return null;
    }
  }

  void limpar(Pilha pilha) {
    pilha.lista.clear();
  }

  Vertice elemento(Pilha pilha) {
    return pilha.lista.elementAt(pilha.lista.length - 1);
  }
}
