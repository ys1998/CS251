#https://stackoverflow.com/questions/12489504/how-to-overlay-2-graphs-in-a-single-plot-in-gnu-plot
#http://xmodulo.com/how-to-export-gnuplot-output-to-png-jpg-and-pdf.html
set xrange [-1:1]
set yrange [-1:1]
set xtics 0.2
set ytics 0.2
f(x)=sqrt(1-x*x)
g(x)=-sqrt(1-x*x)

plot f(x), g(x) linestyle(1)
