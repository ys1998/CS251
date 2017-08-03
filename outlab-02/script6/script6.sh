#!/bin/bash

list=$(cat $1);
cp $2 output

for name in $list;
do
    sed -i "s/\<"$name"\>/bleep/gI" output;
done
