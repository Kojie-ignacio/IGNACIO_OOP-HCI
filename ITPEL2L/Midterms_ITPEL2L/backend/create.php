<?php
    require_once('connect.php');
    session_start();

    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $message = array();

    
    $name = $data ['student_name'];
    $email = $data ['email'];
    $contact = $data ['contact_number'];
    $address = $data ['address'];
    $gender = $data ['gender'];

    //create the sql query
    $query = mysqli_query($con, "insert into students_tbl( name, email, contact, address, gender, reg_date) values('$name', '$email', '$contact', '$home', $gender, NOW())");
    if($query){
        http_response_code(201);
        $message['status'] = "Success....";
    }else{
        http_response_code(422);
        $message['status'] = 'Error....';
    }

    echo json_encode($message);
    echo mysqli_error($con);
?>