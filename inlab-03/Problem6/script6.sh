#!/bin/bash

grep -oE "\<[a-zA-Z][a-zA-Z\'\-\`\’\-]*\>" $1 | tr [:upper:] [:lower:] | sort -u

