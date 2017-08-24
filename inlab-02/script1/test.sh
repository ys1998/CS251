./script1.sh 5 >> out
./script1.sh 10 >> out
./script1.sh 20 >> out
diff out output/testcase >> result

if [[ -s result ]];
then
	echo fail
else
	echo success
fi
rm out result
