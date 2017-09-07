#https://stackoverflow.com/questions/53513/best-way-to-check-if-a-list-is-empty
#http://www.python-course.eu/python3_lambda.php
from functools import reduce
def collapse(l):
	strg=reduce(f,['']+l)
	strg=strg[0:-1]
	return strg

f= lambda string,lst: string if (not lst) else string + reduce(g,lst)+' '
g= lambda s1,s2: s1 if (not s2) else s1 +' '+ s2