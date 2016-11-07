<?php

session_start(); 

include "../includes/projectConn.php";
    
$dbConn = getDatabaseConnection('medical');


function getPatientInfo($patient_id){
    global $dbConn;
        $sql = "SELECT DISTINCT firstname, lastname, city  
                FROM patients WHERE patient_id = $patient_id
                ORDER BY lastname ASC";
                
        $statement = $dbConn->prepare($sql);
        $statement->execute();
        $records = $statement->fetchAll(PDO::FETCH_ASSOC);
        
        //print_r($records);
        
        return $records;
    
     //This function will get all of the patient records and this function will collabarate 
    //with selected statement (creating in progress) to auto-fill the forms once the login process is successfully initialized 
}

if (isset($_GET['patient_id'])) {
        $user = getUserInfo($_GET['patient_id']);
        //print_r($user);
    }

function getDoctors(){
    
    global$dbConn;
    
    $sql = "SELECT DISTINCT firstname, lastname, specialty FROM doctors ORDER BY lastname ASC";
    
     $statement= $dbConn->prepare($sql); 
      $statement->execute();
      $records = $statement->fetchALL(PDO::FETCH_ASSOC);  
      
      //print_r($records);
      
      foreach($records as $record) {
          echo "<option value='". "'>"  . $record['firstname'] . " " . $record['lastname']. " > " . " ". $record['specialty']. "</option>";
      }
}


?>

<!DOCTYPE html>
<html>
    <head>
        <title> Payment Process Page </title>
    </head>
    <body>
    <form method = "POST">
        
        First Name: <input type = "text" name = "fname" value = "<?$user['firstname']?>" />
        </br>
        </br>
        
        Last Name: <input type = "text" name = "lname" value = "<?$user['lastname']?>" />
        </br>
        </br>
        
        Address: <input type = "text" name = "address">
        </br>
        </br>
        
        City: <input type = "text" name = "city"value = "<?$user['city']?>" />
        </br>
        </br>
        
        State: <input type = "text" name = "state">
        </br>
        </br>
        
        Zip: <input type = "text" name = "zip">
        </br>
        </br>
        
        <input type = "checkbox" name = "ship" value = "ship address"> Use the above address information as my Shipping Address
        </br>
        </br>
        Phone Number: <input type = "text" name = "phone">
        </br>
        </br>
        
        Email: <input type = "email" name = "mail">
        
        <h4>If on hospital, state which floor and room number</h4>
        Floor: <select name = "floor">
            <option value = "">Choose One</option>
            <option value = "first">First</option>
            <option value = "second">Second</option>
            <option value = "third">Third</option>
            <option value = "fourth">Fourth</option>
            <option value = "fifth">Fifth</option>
            <option value = "sixth">Sixth</option>
        </select>
        </br>
        
        Room Number: <input type = "text" name = "room">
        </br>
        </br>
        
        
        Who is your Primary Doctor: <select name = "doctor">
        <option value = ""> Select One</option>
        <?=getDoctors()?>
        </select>
        <h4>Payment Method</h4>
        Insurance Name: <input type = "text" name = "insurance">
        </br>
        </br>
        Insurance Number: <input type = "text" name = "number">
        </br>
        </br>
        <input type = "submit" value = "Place Order" name = "order">
        
    </form>
    </body>
</html>