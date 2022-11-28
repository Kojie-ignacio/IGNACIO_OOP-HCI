<?php
    require_once('connect.php');
    session_start();

    $data = array();

    $query = "select * from students_tbl";//sql query to retrive records
    $result = mysqli_query($con, $query);

    while($row = mysqli_fetch_object($result)){
        $data[] = $row;
    }

    echo json_encode($data);
    echi mysqli_error($con);

?>