import os
import re
def findKey():
	for r,d,n in os.walk("./World"):
		file=open(os.path.join(r,n[0]))
		found=False
		for line in file:
			if re.findall(r'The key is: (.{32})',line):
				print("Complete path of key.txt : \n"+os.path.join(r,n[0])+"\nContent of key.txt :\n"+line)
				found=True
				break
		if found:
			break
		else:
			file.close()


if __name__ == '__main__':
	findKey()