 ---- Instru��es para cria��o e utiliza��o de RMI em Java a partir da vers�o 9 ----

1o.) Criar interface derivada de Remote
2o.) Compilar esta interface (javac <arquivo interface>)
3o.) Criar uma classe que implemente essa interface. Essa ser� a classe do objeto remoto.
4o.) Compilar esta classe (javac <arquivo contendo a classe>)
6o.) Criar classes para a aplica��o servidora
7o.) Compilar classe servidora (javac <arquivo classe.java>)
8o.) Criar classe para a aplica��o cliente
9o.) Compilar classe cliente (javac <arquivo classe.java>)


 ----- Utiliza��o das aplica��es cliente e servidora ----

1o.) Execute o servi�o de nomes do RMI Java (rmiregistry)
2o.) Execute a aplica��o servidora (java <nome da classe servidora>)
3o.) Execute a aplica��o cliente (java <nome da classe cliente>)
