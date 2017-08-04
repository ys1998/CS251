#!/bin/bash

sed -E 's/[[:space:]][[:space:]]*/ /g' $1 | sed 's/^[[:space:]][[:space:]]*//g' | sed 's/[[:space:]][[:space:]]*$//g' | sed '/^[[:space:]]*$/d'
