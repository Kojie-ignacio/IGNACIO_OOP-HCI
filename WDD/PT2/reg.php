<?php 
require_once('connect.php');


if($con){
            
            $fname = $_POST['firstname'];
            $lname = $_POST['lastname'];
            $contact = $_POST['Contactno'];
            $gender = $_POST['gender'];
            $email = $_POST['emailAddress'];
            $tno = $_POST['phoneNumber'];
            $pass= $_POST['pass'];
            $cpass = $_POST['rpass'];
            $add = $_POST['Address'];
            $user = $_POST['Username']; 

         

     $query = "insert into users_tbl(firstname, lastname, contact, gender, email, tnumber, password, c_password, address, username, reg_date) values
     ('$fname','$lname','$contact','$gender','$email','$tno','$pass','$cpass','$add','$user',NOW())";

     $result = mysqli_query($con, $query);
        if($result){
        echo 'Registration successfully...';
        }
        else{
            $err[] = 'Registration failed...'.mysqli_error($con);
        }
    mysqli_close($con);
}
        else{
            exit('Could not connect to db.'.mysqli_connect_error());
}

?>