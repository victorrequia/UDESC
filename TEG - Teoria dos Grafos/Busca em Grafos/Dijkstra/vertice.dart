class Vertice {
  String nome;
  Map<Vertice,double> adjacentes = {};
  bool visitado = false;

  Vertice(this.nome);

  String toString() {
    return '$nome';
  }
}
