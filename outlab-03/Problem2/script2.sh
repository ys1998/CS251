#!/bin/bash

sed '/^[[:space:]]*$/d' $1 | awk '
BEGIN {
    FS = "\n";
    RS = "\"";
    OFS = "\n";
    ORS = "\"";
    bracket = 1;
}

($0 ~ /^[[:space:]]*$/) { bracket = 2; print" ";}

($0 !~ /^[[:space:]]*$/) {
    for(i = 1; i <= NF; i++){
	gsub(/[[:space:]][[:space:]]*/, " ", $i);
	gsub(/^[[:space:]]*/, "", $i);
	gsub(/[[:space:]]*$/, "", $i);
	gsub(/\([[:punct:]]\)[[:space:]]\([[:alnum:]]\)/, "\1\2", $i);
    }
    if(bracket == 0){
	bracket = 1;
    }
    else if(bracket == 1){
	$0 = " " $0 " ";
	bracket = 0;
    }
    else{
	bracket = 1;
    }
    print $0;
}' | sed -e 's/^[[:space:]]//' -e '$s/[[:space:]]\"$//'
