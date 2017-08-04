#!/bin/bash

awk '
BEGIN {
	IGNORECASE = 1;
	FS = "[\n\r]";
	RS = "Email[[:space:][:punct:]]*id[[:space:]]*:";
	OFS = "||";
	first = "true";
}

{
	if( first == "true" ){
		i = 1;
		first = "false";
	}
	else {
		i = 2;
		sub(/^\s*/,"",$1);
		email[name] = $1;
	}
	name = 0;	#False
	for(; i < NF; i++){
		sub(/^\s*/,"",$i);	#stripping whitespaces at the beginning
		sub(/[,[:space:]]*$/,"",$i);
		if ($i ~ /^\s*$/)	continue;
		else if (name == 0){
			person[$i] = $i;
			name = $i;
		}
		else	address[name] = address[name] "," $i;	
	}
	sub(/^,/,"",address[name]);
}

END {
	print "Name,Address,Email"
	for (i in person) {
		print i, address[i], email[i];
	}
}' $1
