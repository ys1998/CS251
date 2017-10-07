
<?php
header("Cache-Control: private, must-revalidate, max-age=0");
session_start();
if(isset($_SESSION['active'])){
	header("Location: album.php");		
}
?>
<html>

 <head>
<style>
#form {
  position: absolute;
  width: 300px;
  height: 200px;
  z-index: 15;
  top: 50%;
  left: 50%;
  margin: -100px 0 0 -150px;
}
</style>
  <title>Q1</title>
 </head>
 <body>

<div id="form">   
<form id="login_form" method="post" action="login.php">
<input type="text" id="username" name="username" placeholder="Username" required>
<br><br>
<input type="password" id="password" name="password" placeholder="Password" required>
<br><br>
<input type="submit" value="submit">
<center><?php if(isset($_SESSION['error'])){	echo $_SESSION['error']; $_SESSION['error']="";} ?></center>
</form>
</div>

</body>
</html>


