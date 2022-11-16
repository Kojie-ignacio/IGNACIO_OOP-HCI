<?php 
require_once('connect.php');


if($con){


    $output_dir = "upload/";/* Path for file upload */
    $RandomNum    = time();
    $ImageName    = str_replace(' ', '- ', strtolower($_FILES['image']['name'][0]));
    $ImageType    = $_FILES['image']['type'][0];

    $ImageExt = substr($ImageName, strrpos($ImageName, '.'));
    $ImageExt    = str_replace('.', '', $ImageExt);
    $ImageName    = preg_replace("/\.[^.\s]{3,4}$/", "", $ImageName);


    $NewImageName = $ImageName . '-' . $RandomNum . '.' . $ImageExt;
    $ret[$NewImageName] = $output_dir . $NewImageName;

            
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

            if (!file_exists($output_dir)) {
                @mkdir($output_dir, 0777);
            }
            move_uploaded_file($_FILES["image"]["tmp_name"][0],$output_dir."/".$NewImageName );

     $query = "insert into users_tbl(firstname, lastname, contact, gender, email, tnumber, password, c_password, address, username,image, reg_date) values
     ('$fname','$lname','$contact','$gender','$email','$tno','$pass','$cpass','$add','$user','$NewImageName',NOW())";

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