#!/bin/bash

# get word count from three files and store in respective temp files
cat $1 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out1

cat $2 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out2

cat $3 | sed -e '/^\s*$/d' -e 's/^\s*//' -e 's/\s*$//' -e 's/\s\s*/\n/g' | sed -e 's/^[[:punct:]]*//' -e 's/[[:punct:]]*$//' | tr [:upper:] [:lower:] | sort | uniq -c > out3

# merge the three files
cat out1 >> out2
cat out2 >> out3
total=$( awk 'BEGIN { total=0; } { if($0!=""){ total=total+$1; }} END { print total }' out3 )
# find total word count using awk
cat out3 | sort --key=2,2 | awk -v tot=$total 'BEGIN { t=tot; OFS=","; cnt=0; word="";} \
	{ if($2!=word){\
		print word,cnt/t; word=$2; cnt=$1; }\
	else{ cnt=cnt+$1; }} END { print word,cnt/t;}' | sed '/^,0$/d'
rm out1 out2 out3
