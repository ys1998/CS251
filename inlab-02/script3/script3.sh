#!/bin/bash

list=$(cat $1);

for name in $list;
do
  if ! ls -d */ | grep -q "^$name/";
  then
    mkdir $name
    echo "created $name";
  else
    echo "could not create $name";
  fi
done
