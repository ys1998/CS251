./script4.sh testcase/input1 >> out
./script4.sh testcase/input2 >> out
./script4.sh testcase/input3 >> out
diff out testcase/output >> result

if [[ -s result ]];
then
	echo fail
else
	echo success
fi
rm out result
