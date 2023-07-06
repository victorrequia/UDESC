 ---- Instruções para criação e utilização de RMI em Java a partir da versão 9 ----

1o.) Criar interface derivada de Remote
2o.) Compilar esta interface (javac <arquivo interface>)
3o.) Criar uma classe que implemente essa interface. Essa será a classe do objeto remoto.
4o.) Compilar esta classe (javac <arquivo contendo a classe>)
6o.) Criar classes para a aplicação servidora
7o.) Compilar classe servidora (javac <arquivo classe.java>)
8o.) Criar classe para a aplicação cliente
9o.) Compilar classe cliente (javac <arquivo classe.java>)


 ----- Utilização das aplicações cliente e servidora ----

1o.) Execute o serviço de nomes do RMI Java (rmiregistry)
2o.) Execute a aplicação servidora (java <nome da classe servidora>)
3o.) Execute a aplicação cliente (java <nome da classe cliente>)
