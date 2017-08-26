reset
set term gif animate
set output "bonus.gif"

end_time=2*pi/50

f(x)=5*sin(2*x-100*time)
g(x)=10*sin(2*x+50*time)

set xlabel "{/Times-Italic x}"
set ylabel "{/Times-Italic y}"

set yrange [-40:40]
set grid x,y
set ytics 5

set key box opaque

set title "Superposition of two waves having different frequencies and amplitudes"

time=0
load "bonus_helper.plot"
set output
