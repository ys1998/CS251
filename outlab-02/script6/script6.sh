#!/bin/bash

list=$(cat $1);

for name in $list;
do
    sed -i "s/\<"$name"\>/bleep/gI" $2;
done
