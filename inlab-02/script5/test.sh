./script5.sh testcase/input > out

diff out testcase/output > result

if [[ -s result ]];
then
	echo fail
else
	echo success
fi
rm out result
