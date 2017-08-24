./script6.sh testcase/input6 > out

diff testcase/output6 out > result

if [[ -s result ]];
then
	echo failed
else
	echo passed
fi
rm out result
