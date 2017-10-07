<?php
//https://www.tutorialspoint.com/php/php_get_post.htm
//https://stackoverflow.com/questions/2984786/php-sort-and-count-instances-of-words-in-a-given-string
if($_POST["filename"]){
$file = $_POST["filename"];
if (filesize($file)>10240) {
	  die("File size is too large");
}
else {
	$str = file_get_contents ($file);
	$words = array_count_values(str_word_count($str, 1));
	ksort($words);
	echo "<table>";
	foreach ($words as $keys=>$value){
		echo "<tr><td>".$keys."</td><td>";
		echo $value."</td></tr>";
	}
	echo "</table>";
	}
}
?>

<html>
 <head>
  <title>Q4</title>
 </head>
 <body>
 
<form id="form" method="post" action="<?php $_PHP_SELF ?>" onsubmit="return sSubmit()">
<input type="file" id="filename" name="filename" required>
<input type="submit" id="submit" value="submit">
</form>
<!--https://stackoverflow.com/questions/133925/javascript-post-request-like-a-form-submit-->
<!-- https://stackoverflow.com/questions/10516122/how-prevent-submit-if-input-are-empty-with-javascript -->
<!-- https://www.daniweb.com/programming/web-development/threads/300666/stop-form-submit-with-onclick -->
<script>

function sSubmit(){
var name=document.getElementById("filename").value;
if(!name.endsWith(".txt")){
	alert("incorrect name");
	return false;
} else{
	document.getElementbyId("form").submit();
	}
}
</script>

</body>
</html>


