# Remove single line comments
s:^\s*\/\/.*$::

# Remove block comments
s:^\s*\/\*.*\*\/\s*$::
/^\s*\/\*/,/\*\/\s*$/s/.*//g


