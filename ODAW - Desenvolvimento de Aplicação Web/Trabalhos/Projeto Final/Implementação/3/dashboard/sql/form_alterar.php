<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="../estilo/stylesheet.css">
</head>

<body>
	<?php

	include("menu.html");

	$codigo = $_GET['codigo'];
	$nome = "";
	$senha = "";
	$telefone = "";
	$email = "";

	$link = mysqli_connect("localhost", "root", "", "ex09");

	$query = "SELECT * FROM usuario WHERE id_usuario='$codigo'";
	$result = mysqli_query($link, $query);
	if ($row = mysqli_fetch_row($result)) {
		$nome = $row[1];
		$senha = $row[2];
		$email = $row[3];
		$telefone = $row[4];
	}

	mysqli_close($link);

	echo "
	<form action='alterar.php' method='post'>
	<b>Alterar elemento codigo $codigo:<b><br><br>
	Codigo: <input type='number' name='codigo' value='$codigo' required><br>
	Nome: <input type='text' name='nome' value='$nome' required><br>
	Senha: <input type='password' name='senha' value='$senha' required><br>
	Telefone: <input type='text' name='telefone' value='$telefone' required><br>
	Email: <input type='text' name='email' value='$email' required><br>
	<input type='submit' name='adicionar' value='adicionar'>
	</form><hr>";
	?>

</body>

</html>