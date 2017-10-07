
<?php
session_start();
if(isset($_POST["username"])){
		
	if( $_POST["username"] == 'eval' && $_POST["password"] == 'eval'){
		$_SESSION['imagecount'] = 0;		
		$_SESSION['active']=1;	
		header("Location: album.php");
		exit();
	} else {
		header('Location:index.php');
		$_SESSION['error']="invalid credentials";
	}
}
else{
	header('Location:index.php');
	$_SESSION['error']="password not sent";
}
?>
