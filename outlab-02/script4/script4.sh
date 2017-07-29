#!/bin/bash

while read line
do
 Tname=$( echo $line | cut -d ',' -f1)
 for i in 2 4 6
 do
  let j=$i+1
  s=$(echo $line | cut -d ',' -f $i)
  r=$(echo $line | cut -d ',' -f $j) 
  #list="$list $(echo $Tname,$s,$r)"
  #list=$(echo $Tname,$s,$r + $list)
  #echo $list
  echo $Tname,$s,$r >>temp
 done
done < $1

cat temp | sort > output
rm temp

