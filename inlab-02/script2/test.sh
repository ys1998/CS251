mkdir testcase
mkdir testcase/test1
mkdir testcase/test2
mkdir testcase/test1\ test2/
./script2.sh testcase > out
echo 3 > tc
diff out tc > result
if [[ -s result ]];
then
	echo fail
else
	echo success
fi
rm -r testcase
rm tc out result
