# Resumo
Trabalho final da disciplina de POO (Programação orientada a objetos) da Udesc/CCT, desenvolvido pelo aluno Victor Eduardo Requia com o auxilio do monitor da disciplina Vinicius Takeo
e o professor Fabiano Baldo

O trabalho consiste em implementar um sistema hospitalar capaz de cadastrar, remover, atualizar e buscar (CRUD) médicos, paciente e consultas por meio do banco de dados PostgreSQL.

# Passos para execução
* PostgresSQL intalado e configurado com a senha de acesso sendo "Udesc" e a porta 5432 (Caso queira mudar a senha ou porta, leia as observações logo abaixo)
* Restaurar o banco de dados do projeto através do pageAdmin do postrgres, é impotante colocar o nome da database como consultorio 
(Caso queira mudar o nome da database, leia as observações logo abaixo)
* O login padrão do sistema é "Udesc" ou "Root" e a senha "123" (Caso queira mudar a senha ou usuario, leia as observações logo abaixo)

# Observações
* Caso deseje mudar a senha padrão tanto do acesso ao banco como de acesso ao sistema em si e o nome da database, você terá que baixar a src do projeto e compilar manualmente.
* Para mudar a senha de acesso ao banco de dados, vá até a classe Sistema.java e no contrutor basta mudar a linha onde aparece Conexao.setSenha("Udesc") para Conexao.setSenha("Sua senha");
* Para mudar o login e senha de acesso ao sistema, vá até a classe Sistema e na função isValidAutentication, dentro do if faça suas configurações, caso queira mudar a senha modifique 
senha.equals("123") para (senha.equals("Sua senha") e para mudar o usuario altere user.equals("Root") para user.equals("Seu Login")
* Para mudar o nome da database e porta, vá até a classe Conexao.java e na função getConexao modifique String url = "jdbc:postgresql://localhost:5432/consultorio"
para String url = "jdbc:postgresql://localhost:Sua porta de acesso ao banco/Seu nome de databse"

