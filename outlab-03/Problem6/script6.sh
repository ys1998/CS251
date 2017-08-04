#!/bin/bash

# get word count from three files and store in respective temp files
cat $1 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out1

cat $2 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out2

cat $3 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out3

# merge the three files
cat out1 >> out2
cat out2 >> out3

# find total word count using awk
cat out3 | sort --key=2,2 | awk 'BEGIN { cnt=0; word=""; OFS="\t"} \
	{ if($2!=word){\
		print cnt,word; word=$2; cnt=$1; }\
	else{ cnt=cnt+$1; }} END { print cnt,word;}' | sed -e '/^0\s*$/d'
rm out1 out2 out3
