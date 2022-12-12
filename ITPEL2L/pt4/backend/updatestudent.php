<?php
    require_once('connect.php');

    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $message = array();

    $name = $data['name'];
    $genre = $data['genre'];
    $f_main = $data['f_main'];
    $m_main = $data['m_main'];
    $epi = $data['epi'];
    $length = $data['length'];
    $rate = $data['rate'];
    $id = $_GET['id'];

    $query = mysqli_query($con, "update show_tbl set name = '$name', genre = '$genre', f_main = '$f_main', m_main = '$m_main', epi = '$epi', length = '$length', rate = '$rate' where id = '$id' LIMIT 1");

    if($query){
        http_response_code(201);
        $message['status'] = "Success";

    }else{
        http_response_code(422);
        $message['status'] = "Error";
    }
    echo json_encode($message);
    echo mysqli_error($con);
?>