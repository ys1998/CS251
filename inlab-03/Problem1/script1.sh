#!/bin/bash

grep -oE '(^\<[a-zA-Z][a-zA-Z0-9\.\_][a-zA-Z0-9\.\_]*\@[a-zA-Z][a-zA-Z]*\.[a-zA-Z\.][a-zA-Z\.]*\>)|(\s* \<[a-zA-Z][a-zA-Z0-9\.\_][a-zA-Z0-9\.\_]*\@[a-zA-Z][a-zA-Z]*\.[a-zA-Z\.][a-zA-Z\.]*\>)' $1 | sed 's/\s*//g'
