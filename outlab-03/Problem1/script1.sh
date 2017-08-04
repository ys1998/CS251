#!/bin/bash

awk '
BEGIN {
# FS="[[:space:]]+";
}
NR==1 {
    printf "%s\t%s\t%s\t%s\tPoints\n",$1,$2,$3,$4
} 
NR>1 {
    printf "%s\t%d\t%d\t%d\t%d\n",$1,$2,$3,$4,4*$3+2*$4
}' $1
