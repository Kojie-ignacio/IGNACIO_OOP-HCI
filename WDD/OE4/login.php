<?php 
    session_start();

    require_once('connect.php');
    
    $username = $_POST['email'];
    $password = $_POST['pass'];

    $sql = "select * from users_tbl where email ='".$username."' and password = '".$password."'";
    $run = mysqli_query($con,$sql);
    $row = mysqli_fetch_array($run);


    if(mysqli_num_rows($run) == 1){
        $_SESSION['logged_in'] = true;
        $_SESSION['firstname'] = $row['firstname'];
        $_SESSION['lastname'] = $row['lastname'];


        header("Location: index.php");
    }else{
        header("Location: login.html");
    }


?>