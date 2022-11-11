<?php


//define named constants
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASSWORD', '');
define('DB_NAME', 'wdd_database');

//connection
$con = mysqli_connect(DB_HOST,DB_USER,DB_PASSWORD,DB_NAME) OR exit('could not connect to db...'.mysqli_connect_error());

//if($con){
   // echo'you are connected to the database...',
//}else{
   // echo'you are not connected to the database...',
//}
?>