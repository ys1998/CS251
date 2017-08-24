# https://stackoverflow.com/questions/14871272/plotting-using-a-csv-file
# http://gnuplot.sourceforge.net/demo/datastrings.html
# https://stackoverflow.com/questions/35526481/gnuplot-shortest-way-to-ignore-first-line-in-datafile


unset label
unset title
unset key
unset xtics
unset ytics
unset offsets
unset style

set title ""
set xlabel "Roll No. -->"
set ylabel "Gradepoint -->"
set grid x,y

set offsets 1,2,0.5,1
set xtics 1 offset -1 rotate by 45 right
set ytics 1 offset -1

set key auto
set style textbox opaque
grade(x) = (x<=39)? 4:((x<=44)? 5:((x<=49)? 6:((x<=54)? 7:((x<=59)? 8:((x<=69)? 9:10)))))
set datafile separator ","
plot "file.csv" using 1:(grade($2)) title "Grade Chart" with lines lw 3, \
	 "" using 1:(grade($2)):2 with labels center boxed notitle
	 
	 