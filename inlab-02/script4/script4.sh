#!/bin/bash

list=$(cat $1);
max="a";
min="b";

for num in $list;
do
  if [ $max == "a" ]
  then
    max=$num;
  elif [ $max -lt $num ]
  then
    min=$max;
    max=$num;
  elif [ $min == "b" ]
  then
    min=$num;
    elif [ $min -lt $num ]
  then
    min=$num;
  fi
done

echo $(( $max + $min));
echo $(( $max * $min));
