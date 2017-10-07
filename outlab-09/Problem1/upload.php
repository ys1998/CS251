<?php
	session_start();
	if(!isset($_SESSION['active'])){
		session_destroy();
		$_SESSION = array();	
		header("Location: index.php");		
		exit();
	}
	if(!isset($_POST['from'])){
		header("Location: album.php");		
		exit();			
	} else if($_POST['from']!='album'){
		echo $_POST['from'];		
		header("Location: album.php");		
		exit();
	}			
//$a = session_id($_COOKIE['PHPSESSID']);
	//if(empty($a)){
	//	echo "Starting session<br>";
	//}
	//else	echo "<br>";
	//echo "SID: ".SID."<br>session_id(): ".session_id()."<br>COOKIE: ".$_COOKIE["PHPSESSID"]."<br>";
?>

<?php
//https://stackoverflow.com/questions/7450371/can-a-php-session-variable-have-numeric-id-thus-session1234
//https://stackoverflow.com/questions/619610/whats-the-most-efficient-test-of-whether-a-php-string-ends-with-another-string
//https://stackoverflow.com/questions/16333682/back-button-in-php
//https://www.youtube.com/watch?v=f_KVTQL9q1Y
//https://www.w3schools.com/php/php_file_upload.asp
//http://php.net/manual/en/function.session-id.php
	
	
	//echo $_SESSION['imagecount']."<br>";	//Working

	if (!file_exists('./images/')) {
		mkdir('./images/', 0777, true);
	}
	
	$file="file";
	if(isset($_POST['upload_submit'])){
		$back_button = "<form method='post' action='new_upload.php'><input type='submit' value='Back'></form>";
		$file = $_FILES['image']['name'];
		if ($_SESSION['imagecount'] >= 10){
			echo $back_button;
			die("Too many files uploaded!");
		} else if (!endsWith($_FILES['image']['name'],".jpg")) {
			echo $back_button;
			die("Please choose a correct file.");
		} else if ($_FILES['image']['size']>204800) {	  
			echo $back_button;
			die("File size is too large");
		} else {
			$target_dir = "./images/";
			$target_file = $target_dir . basename($_FILES["image"]["name"]);
			if(move_uploaded_file ($_FILES['image']['tmp_name'],$target_dir.'/'.$file)){	
				$old_count = $_SESSION['imagecount'];
				$_SESSION['imagecount']=0;
				$opened = opendir($target_dir);	
				while ($images = readdir($opened) != false )			//to check if a previous file was overwritten	
					$_SESSION['imagecount']++;
				closedir($opened);
				$_SESSION['imagecount'] = $_SESSION['imagecount'] -2;	
								
				if($old_count < $_SESSION['imagecount']){
					$count = $_SESSION['imagecount'];
					$_SESSION['image'][ $count] = $_FILES['image']['name'];	
				}
				echo '<a href="album.php">Go back</a>';
				//print_r($_SESSION);
			}
			//echo $back_button;
		}
	}
	
	function endsWith($string, $test) {
		$strlen = strlen($string);
		$testlen = strlen($test);
		if ($testlen > $strlen) return false;
		return substr_compare($string, $test, $strlen - $testlen, $testlen) === 0;
	}
?>
