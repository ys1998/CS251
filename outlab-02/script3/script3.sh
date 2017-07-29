#!/bin/bash

cat $(find $1 -type -f) | sed '/^\s*&/d' | wc -l
