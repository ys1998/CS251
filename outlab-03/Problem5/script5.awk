#!/bin/awk -f
BEGIN {
	FS = ",";
	OFS = ",";
	city[""] = 0;
}

{
	city[$2] += $3;
}

END {
	for (i in city)
		if (i != "")	print i, city[i];
}

