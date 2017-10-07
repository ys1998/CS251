<html>
<body>
<form action="<?php $_PHP_SELF ?>" method="POST">
	<p>Enter comma separated numbers in the space below :</p>
	<input type="text" name="numbers">
	<input type="submit" value="Sort">
</form>
<?php
if($_POST["numbers"]){
function myGnomeSort($arr){
	$i = 1;
	$j = 2;
	while($i < count($arr)){
		if ($arr[$i-1] <= $arr[$i]){
			$i = $j;
			$j++;
		}else{
			list($arr[$i],$arr[$i-1]) = array($arr[$i-1],$arr[$i]);
			$i--;
			if($i == 0){
				$i = $j;
				$j++;
			}
		}
	}
	return $arr;
}
$nums=$_POST["numbers"];

$arr=explode(",", $nums);
for ($i=0; $i < count($arr); $i++) { 
	$arr[$i]=intval($arr[$i]);
}
echo "Sorted sequence : ";
$arr=myGnomeSort($arr);
for ($i=0; $i < count($arr); $i++) { 
	echo $arr[$i]." ";
}
}

?>
</body>
</html>
