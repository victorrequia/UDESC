<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="images/sweet.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="estilo/stylesheet.css" media="screen" />
    <title>Romeu Julieta - Confeitaria</title>
</head>

<body>

<?php

include("menu.html");

$link = mysqli_connect("localhost", "root", "", "ex09");
	
$query = "SELECT * FROM usuario ORDER BY usuario";
$result = mysqli_query($link, $query);

echo "SELECT: $query<br>";
echo "<table border=\"1\">";
echo "<tr><td><b>Código</b></td>";
echo "<td><b>Nome</b></td>";
echo "<td><b>senha</b></td>";
echo "<td><b>E-mail</b></td>";
echo "<td><b>Telefone</b></td>";

echo "<td><b>&nbsp;</b></td>";
echo "<td><b>&nbsp;</b></td></tr>";
while ($row = mysqli_fetch_row($result)) {
	echo "<tr><td>".$row[0]."</td>";
	echo "<td>".$row[1]."</td>";
	echo "<td>".$row[2]."</td>";
	echo "<td>".$row[3]."</td>";
    echo "<td>".$row[4]."</td>";
	echo "<td><a href=\"sql/deletar.php?codigo=".$row[0]."\">deletar</a>";
	echo "<td><a href=\"sql/form_alterar.php?codigo=".$row[0]."\">alterar</a></tr>";
}
echo "</table><hr>";

mysqli_close($link);

?>



</body>

</html>