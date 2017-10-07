<?php
$servername = "1.db.cse.iitb.ac.in";
$username = "cs699user";
$password = "cs699user@123";
$dbname = "cs699db";

function validate_date($name,$str){
	$fields=explode("-", $str);
	if(count($fields)!=3){
		return $name." : Incorrect date format <br>";
	}else{
		if(checkdate($fields[1], $fields[2], $fields[0])){
			return "";
		}else{
			return $name." : Incorrect date format <br>";
		}
	}

}
function validate_time($name,$str){
	if(preg_match("#^([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$#", $str)){
		return "";
	}else{
		return $name." : Incorrect time format <br>";
	}
}
function validate_order($st,$end){
	$f1=explode(":", $st);
	$f2=explode(":", $end);
	$correct=TRUE;
	if(intval($f1[0])==intval($f2[0])){
		if(intval($f1[1])==intval($f2[1])){
			if(intval($f1[2])>=intval($f2[2])){
				$correct=FALSE;
			}
		}else{
			if(intval($f1[1])>intval($f2[1])){
				$correct=FALSE;
			}
		}
	}else{
		if(intval($f1[0])>intval($f2[0])){
			$correct=FALSE;
		}
	}
	if($correct===TRUE){
		return "";
	}
	if($correct===FALSE){
		return "<i>END_TIME</i> should be after <i>START_TIME</i> <br>";
	}
}

if($_POST["choice"]){
	switch ($_POST["choice"]) {

		// HANDLING INSERTION OF EVENTS
		case 'add':
		$date=$_POST["date"];
		$st_time=$_POST["st_time"];
		$end_time=$_POST["end_time"];
		
		$error_msg="";
		$error_msg.=validate_date("Date",$_POST["date"]);
		$t1=validate_time("Starting time",$_POST["st_time"]);
		$t2=validate_time("Ending time",$_POST["end_time"]);
		if($t1=="" && $t2==""){
			$error_msg.=validate_order($st_time,$end_time);
		}else{
			$error_msg.=$t1.$t2;
		}

		if($error_msg==""){
			// connect to database
			$connection=mysqli_connect($servername,$username,$password,$dbname) or die("<h1>Errors found</h1>"."Unable to connect.");
			$desc=mysqli_real_escape_string($connection, $_POST["desc"]);
			// add row to database
			$query="INSERT INTO event (event_date,start_time,end_time,description) VALUES ('$date','$st_time','$end_time','$desc')";
			if(mysqli_query($connection, $query)){
				echo "Data successfully inserted.<br>"."EVENT ID : ".mysqli_insert_id($connection);
				mysqli_close($connection);
			}else{
				echo $query."<br>";
				echo "Error in inserting data in database.\n".mysqli_error($connection);
				mysqli_close($connection);
			}
		}else{
			echo "<h1>Errors found</h1>".$error_msg;
		}
		break;

		// HANDLING DISPLAY OF ALL EVENTS
		case 'display_all':
		$connection=mysqli_connect($servername, $username, $password, $dbname) or die("<h1>Errors found</h1>"."Unable to connect.");
		$query="SELECT * FROM event";
		$result=mysqli_query($connection, $query);

		if(mysqli_num_rows($result)>0){
			echo "<table border=\"1\" cellpadding=\"5\" style=\"border-style:solid\">";
			echo "<tr><th>Event ID</th><th>Date</th><th>Starting Time</th><th>Ending Time</th><th>Description</th></tr>";
			while($row=mysqli_fetch_assoc($result)){
				echo "<tr><td>".$row["event_id"]."</td><td>".$row["event_date"]."</td><td>".$row["start_time"]."</td><td>".$row["end_time"]."</td><td>".$row["description"]."</td></tr>";
			}
			echo "</table>";
		}else{
			echo "No events exist.";
		}
		mysqli_close($connection);
		break;

		// HANDLING DELETION OF SPECIFIED EVENT
		case 'delete':
		$id=$_POST["event_id"];

		$connection=mysqli_connect($servername, $username, $password, $dbname) or die("<h1>Errors found</h1>"."Unable to connect.");

		$exists=(mysqli_num_rows(mysqli_query($connection, "SELECT * FROM event WHERE event_id='$id'")) > 0);
		if($exists){
			if(mysqli_query($connection, "DELETE FROM event WHERE event_id=$id")){
				echo "Deletion was successful.<br>EVENT_ID deleted : ".$id;
			}else{
				echo "Error while deleting EVENT_ID $id : ".mysqli_error($connection);
			}
		}else{
			echo "<h1>Errors found</h1>"."EVENT_ID ".$id." doesn't exist.";
		}
		mysqli_close($connection);
		break;

		// HANDLING DISPLAYING OF EVENT BY DATE
		case 'display_date':
		$date=$_POST["date"];
		$error_msg=validate_date("Date",$date);
		if($error_msg==""){
			$connection=mysqli_connect($servername, $username, $password, $dbname) or die("<h1>Errors found</h1>"."Unable to connect.");
			$query="SELECT * FROM event WHERE event_date='$date'";
			$result=mysqli_query($connection, $query);
			if(mysqli_num_rows($result)>0){
				echo "Events for the date ".$date."<br><br>";
				echo "<table border=\"1\" cellpadding=\"5\" style=\"border-style:solid\">";
				echo "<tr><th>Event ID</th><th>Starting Time</th><th>Ending Time</th><th>Description</th></tr>";
				while($row=mysqli_fetch_assoc($result)){
					echo "<tr><td>".$row["event_id"]."</td><td>".$row["start_time"]."</td><td>".$row["end_time"]."</td><td>".$row["description"]."</td></tr>";
				}
				echo "</table>";
			}else{
				echo "No events exist for the date ".$date;
			}
			mysqli_close($connection);
		}else{
			echo "<h1>Errors found</h1>".$error_msg;
		}
		break;

		// HANDLING EVENT-UPDATE
		case 'update':
		$id=$_POST["event_id"];
		$date=$_POST["date"];
		$st_time=$_POST["st_time"];
		$end_time=$_POST["end_time"];
		

		$error_msg="";
		$error_msg.=validate_date("Date",$_POST["date"]);
		$t1=validate_time("Starting time",$_POST["st_time"]);
		$t2=validate_time("Ending time",$_POST["end_time"]);
		if($t1=="" && $t2==""){
			$error_msg.=validate_order($st_time,$end_time);
		}else{
			$error_msg.=$t1.$t2;
		}

		if($error_msg==""){
			// connect to database
			$connection=mysqli_connect($servername,$username,$password,$dbname) or die("<h1>Errors found</h1>"."Unable to connect.");
			$desc=mysqli_real_escape_string($connection,$_POST["desc"]);
			$exists=(mysqli_num_rows(mysqli_query($connection, "SELECT * FROM event WHERE event_id=$id")) > 0);
			if($exists){
				$query="UPDATE event SET event_date='$date',start_time='$st_time',end_time='$end_time',description='$desc' WHERE event_id='$id'";
				if(mysqli_query($connection, $query)){
					echo "Data successfully updated.<br>"."EVENT ID : ".$id;
				}else{
					echo $query."<br>";
					echo "Error in inserting data in database.\n".mysqli_error($connection);
				}
			}else{
				echo "<h1>Errors found</h1>"."EVENT_ID ".$id." does not exist.";
			}
			mysqli_close($connection);
		}else{
			echo "<h1>Errors found</h1>".$error_msg;
		}
		break;

		// DEFAULT ACTION
		default:
		die("<h1>Errors found</h1>"."Incorrect request format!");	
		break;	
	}
}else{
	die("<h1>Errors found</h1>"."Incorrect request format!");
}
?> 