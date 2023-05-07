class Vertice {
  String nome;
  List<Vertice> adjacentes = [];
  bool visitado = false;

  Vertice(this.nome);

  String toString() {
    return '$nome';
  }
}
