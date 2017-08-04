#!/bin/bash

cat $(find $1 -type -f) | grep -v "/^\s*$/" | wc -l
