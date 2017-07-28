./script3.sh testcase/input1 > out
diff out testcase/output1 >> result
rm -r test1 test2
./script3.sh testcase/input2 > out
diff out testcase/output2 >> result
rm -r test1 test2 test3

if [[ -s result ]];
then
	echo fail
else
	echo success
fi
rm out result
