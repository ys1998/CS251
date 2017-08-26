#https://stackoverflow.com/questions/4805930/making-x-axis-tics-from-column-in-data-file-in-gnuplot
#http://gnuplot.sourceforge.net/demo/histograms.html
#https://stackoverflow.com/questions/13580236/gnuplot-max-and-min-values-in-a-range
#https://stackoverflow.com/questions/24378542/space-between-y-axis-and-first-bar-charts
set style data histogram
set style fill solid 1.0 border 0.5
set xlabel "Subject";
set ylabel "Frequency";
set offsets graph 0, 0, 1, 0
set offset -0.7,-0.5,0,0
set tics out nomirror
set size 1, 1
set xtic right rotate by 45 offset 0,0,graph 0 
set yrange[0:8]
plot "subFreq" using 2:xtic(1) title "Frequency Count"
