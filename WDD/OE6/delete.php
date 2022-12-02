<?php 
    include_once('connect.php');
    if(isset($_GET['id'])){
        $id = $_GET['id'];

        $query = mysqli_query($con,"delete from users_tbl where id ='$id' ");

        if($query){
           
           // exit();
            header('location:index.php');
        }
    }
?>