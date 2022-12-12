<?php 
    require_once('connect.php');
    session_start();

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

    $query = mysqli_query($con, "insert into show_tbl(name, genre, f_main, m_main, epi, length, rate) values('$name', '$genre', '$f_main', '$m_main', '$epi', '$length', '$rate')");

    if($query){
        http_response_code(201);
        $message['status'] = 'Success';
    }else{
        http_response_code(422);
        $message['status'] = 'Error';
    }

    echo json_encode($message);
    echo mysqli_error($con);
?>