<?php

include("menu.html");

$codigo = $_POST['codigo'];
$nome = $_POST['nome'];
$senha = $_POST['senha'];
$telefone = $_POST['telefone'];
$email = $_POST['email'];

$link = mysqli_connect("localhost", "root", "", "ex09");

$query = "UPDATE usuario SET usuario='$nome', senha='$senha', email='$email', telefone=$telefone WHERE id_usuario=$codigo";
echo "UPDATE: $query<br><hr>";
mysqli_query($link, $query);
mysqli_close($link);
			
?>
