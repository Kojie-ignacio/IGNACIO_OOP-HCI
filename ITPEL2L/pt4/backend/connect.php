<?php 
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: POST, GET, DELETE, PUT, PATCH, OPTIONS');
    header('Access-Control-Allow-Headers: token, Content-Type');
    header('Content-Type: text/plain');
    header('Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-Type, Access-Control-Allow-Methods, Authorization, X-Requested-With');

    define('DB_HOST', 'localhost:3307');
    define('DB_USER', 'root');
    define('DB_PASSWORD', '');
    define('DB_NAME', 'itpel2_database');

    $con = mysqlI_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME ) or die('Cannot connect to the database');
    
?>