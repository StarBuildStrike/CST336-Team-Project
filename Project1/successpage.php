<?php
session_start(); 
?>


<!DOCTYPE html>
<html>
    <head>
        <title> Success Page </title>
    </head>
    <body>
        
        <h1><center>Thank You. Your order has been processed</center></h1>
        
        <h3> Your order Number is: <?php echo mt_rand(1000000,9999999); ?></h3>
        
        <p>You'll recieve an email confirmation shortly to <?php echo  " "; echo $_SESSION["email"]; ?> 
        
        <h5>Please direct any questions you have to our Customer Service Department at: pharma@email.com. You can also contact us
            by calling 1(800)234-5678. 
        </h5>
        
        </p>
        
        

    </body>
</html>