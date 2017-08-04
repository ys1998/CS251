#!/bin/bash

lines=$( awk 'END {print NR}' $1)

# create temporary file
cat $1 |  sed -e :a -e '/^\n*$/{$d;N;ba' -e '}' |  sed '/./,$!d' | sed -e 's/^\s*//' -e 's/\s\s*/ /g' -e 's/\s*$//' > temp

# variables
words=$( awk 'BEGIN { w=0 }{ w=w+NF } END { print w }' temp )
chars=$( awk 'BEGIN { c=0 }{ for(i=1;i<=NF;++i){ c=c+length($i)}} END { print c }' temp )
paras=$( awk 'BEGIN { p=0; prev="a";}{ if($0 ==""){if(prev!=""){p++; prev=""; }}else{prev="a"; }}\
	      	END { p++; print p; }' temp )

if [ $# -eq 1 ]; then
	echo "$chars characters, $words words, $lines lines, $paras paragraphs"
elif [ $# -eq 2 ]; then
	param=$2
	if [ $param = "-chars" ]; then
		echo "$chars characters"
		
	elif [ $param = "-words" ]; then
		echo "$words words"

	elif [ $param = "-lines" ]; then
		echo "$lines lines"

	elif [ $param = "-paras" ]; then
		echo "$paras paragraphs"		
	fi
fi
rm temp
