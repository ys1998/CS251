<?php
	session_start();	
	if(isset($_GET['logout'])){
	if($_GET['logout']==1){
		session_destroy();
		$_SESSION = array(); 
		header("Location: index.php");		
		exit();
	}}
	if(!isset($_SESSION['active'])){
	 	session_destroy();
		$_SESSION = array();	
		header("Location: index.php");		
		exit();
	}
	//echo "SID: ".SID."<br>session_id(): ".session_id()."<br>COOKIE: ".$_COOKIE["PHPSESSID"]."<br>";
	//session_set_cookie_params(60 * 60 * 24 * 7 , "/"); 
	//ini_set('session.cookie_lifetime', 60 * 60 * 24 * 7);
	//session_start();
	echo "Files uploaded: ".$_SESSION['imagecount'];
?>

<html>
<body>
<br>
<br>
<form name="upload_form" method="post" action="upload.php" enctype="multipart/form-data" onsubmit="return isimg();" multiple>
<input type="file" name="image" accept=".jpg">
<input type="submit" name="upload_submit" value="Upload file">
<input type="hidden" name="from" value="album">
<!--<?php
	echo "<br>";
	echo "<br>";
	print_r($_SESSION);
?>-->
</form>
<form method='post' action='album.php'><input type='submit' value='Back'></form>

<a href="?logout=1">Logout</a>

</body>
<script>
function isimg(){
	var name=document.forms["upload_form"]["image"].value;
	if(!name.endsWith(".jpg")){
		alert("Please choose a correct file.");
		return false;
	}
	return true;
}
</script>
</html>

