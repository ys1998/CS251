#!/bin/bash

sed 's/\s\s*/\ /g' test2 | sed 's/^\s//g' | sed 's/\s$//g' | sed '/^\ *$/d'
