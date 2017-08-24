#!/bin/bash

cat $1 | grep -o "\<[AaEeIiOoUu][A-Za-z]*[AaEeIiOoUu]\>" | sort | uniq
