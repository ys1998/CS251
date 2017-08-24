BEGIN {
	FS=","
	RS="!"
	OFS="\t"
	print "Value\tSensorNumber"
}
{
	print $1,$2
}
