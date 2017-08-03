#!/bin/awk -f
BEGIN {
	RS = "@";
	FS = "\n";
	OFS = ",";
	first = "true";
}

{
	if( first == "true" ){
		i = 1;
		first = "false";
	}
	else {
		i = 2;
		email[name] = email[name] "@" $1;
	}
	name = 0;	#False
	for(; i < NF; i++){
		sub(/^\s*/,"",$i);	#stripping whitespaces at the beginning
		if ($i ~ /^\s*$/)	continue;
		else if (name == 0){
			person[$i] = $i;
			name = $i;
		#	address[name] = "";
		}
		else	address[name] = address[name] " " $i;	
	}
	email[name] = $NF;		#For the last line
	first = "false";		
}

END {
	print "Name,Address,Email"
	for (i in person) {
		print i, address[i], email[i];
	}
}
