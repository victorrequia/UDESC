<?php
    include("menu.html");

    $codigo = $_GET['codigo'];

    $link = mysqli_connect("localhost", "root", "", "ex09");

    $query = "DELETE FROM usuario WHERE id_usuario='$codigo'";
    echo "DELETAR: $query<br><hr>";
    mysqli_query($link, $query);
    mysqli_close($link);
?>
