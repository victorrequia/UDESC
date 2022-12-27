<?php

include("menu.html");

$nome = $_POST['nome'];
$senha = $_POST['senha'];
$email = $_POST['email'];
$telefone = $_POST['telefone'];

$link = mysqli_connect("localhost", "root", "", "ex09");

$query = "INSERT INTO usuario VALUES (default, '$nome', '$senha', '$email', '$telefone')";
echo "INSERT: $query<br><hr>";
mysqli_query($link, $query);
mysqli_close($link);
			
?>
