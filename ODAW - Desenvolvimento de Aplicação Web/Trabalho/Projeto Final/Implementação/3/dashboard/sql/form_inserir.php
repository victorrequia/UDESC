<!DOCTYPE html>
<html lang="pt-br">

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
	?>

	<form action="inserir.php" method="post">
		<b>Inserir novo elemento:<b><br><br>
				Nome: <input class="input-campo" type="text" name="nome" required><br>
				Senha: <input type="password" name="senha" required><br>
				Email: <input type="text" name="email" required><br>
				Telefone: <input class="input-campo" type="text" name="telefone" required><br>
				<input type="submit" name="adicionar" value="adicionar" required>
	</form>
	<hr>

</body>

</html>