<?php
    require_once('connect.php');\


    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $message = array();

    $name = $data['data'];
    $email = $data['email'];
    $contact = $data['contact'];
    $address = $data['address'];
    $gender = $data['gender'];
    $id = $_GET['id'];

    $query = mysqli_query($con, "update students_tbl set name = '$name', email='$email', contact='$contact', address='$address', gender='$gender' where id = '$id' LIMIT 1")
    
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