unset title
unset label
unset offsets
unset key
set xlabel "Humidity (%)"
set ylabel "Temperature (deg. C)"
set title "Temperature vs. Humidity plot"


set xtics 5
set ytics 0.5
set datafile separator ","
set key right top Right title "  StationName  -  Lab  \nLong - 72.82579803\n  Lat  -  18.97500038  "
plot "< awk '(NR>1){print $0}' Plot5Data.csv" using 2:1 with points pointtype 13 notitle 