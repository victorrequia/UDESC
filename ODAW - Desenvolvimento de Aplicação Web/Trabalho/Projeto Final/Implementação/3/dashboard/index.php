<?php session_start() ?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>

<body>

    <?php
    if (isset($_POST['acao'])) {
        $login = 'root';
        $senha = 'root';

        $loginForm = $_POST['login'];
        $senhaForm = $_POST['senha'];

        if ($login == $loginForm && $senha == $senhaForm) {
            //Logado com sucesso
            header('Location: home.php');
        } else {
            //Ocorreu um erro na autenticação
            echo 'Dados inválidos';
        }
    }
    include('login.php');
    ?>

</body>

</html>