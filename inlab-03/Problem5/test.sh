./script5.sh testcase/input5 > out

diff testcase/output5 out > result

if [[ -s result ]];
then
	echo failed
else
	echo passed
fi
rm out result
