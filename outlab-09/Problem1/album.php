<?php
//https://stackoverflow.com/questions/9581268/how-can-i-redirect-a-php-page-to-another-php-page
//https://www.youtube.com/watch?v=f_KVTQL9q1Y
//https://www.youtube.com/watch?v=_Ks5Kz6bxJg
//https://stackoverflow.com/questions/17564795/destroy-a-php-session-on-clicking-a-link
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
if(isset($_POST["i"]))
	$i=$_POST['i'];
else
	$i=1;
?>

<html>
<style>
.spanFormat
{
  text-align: right;
  display: table-cell;
  min-width: 10px;
  padding-right: 10px;
}
</style>
<body>
<div id="image">
<?php
	if ($i > $_SESSION['imagecount']){
		$i = $_SESSION['imagecount'];
	} else if ($i < 1){
		$i = 1;
	}
	if($_SESSION['imagecount'] != 0){
		echo "<img src=images/".$_SESSION['image'][$i]." width = 500 height = 500>";
	}
?>
</div align="left">
<span class="spanFormat">
<form method='post' action='album.php'>
<input type="hidden" name="i" value=<?php echo 1; ?> >
<input type="submit" id="first" value="First"> 
</form>
</span>
<span class="spanFormat">
<form method='post' action='album.php'>
<input type="hidden" name="i" value=<?php echo $i-1; ?> >
<input type="submit" id="previous" value="Previous"> 
</form>
</span>
<span class="spanFormat">
<form method='post' action='album.php'>
<input type="hidden" name="i" value=<?php echo $i+1; ?> >
<input type="submit" id="next" value="Next"> 
</form>
</span>
<span class="spanFormat">
<form method='post' action='album.php'>
<input type="hidden" name="i" value=<?php echo $_SESSION['imagecount']; ?> >
<input type="submit" id="last" value="Last"> 
</form>
</span>
</div>

<?php	echo "Files uploaded: ".$_SESSION["imagecount"]; ?>
<br>
<br>

<form method="post" action="new_upload.php">
<input type="submit" name="new_upload_submit" value="Upload file">
</form>
<br><br>
<a href="?logout=1">Logout</a>

</body>
</html>
