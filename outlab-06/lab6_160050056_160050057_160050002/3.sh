#!/bin/bash

sort inputdata3 | uniq -c | sed 's/^\ *//' | awk 'BEGIN {FS=" ";} {print $2 " " $ 1}' > "subFreq"

