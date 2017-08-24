set xrange [-10:10]
set yrange [-10:10]

set style line 1 lc rgb "violet" lw 2
set style line 2 lc rgb "green" lw 2
set style line 3 lc rgb "cyan" lw 2
set style line 4 lc  rgb "gray" lw 1.5 dt 2

l(x)=0
f1(x)=x*x-2*x
f2(x)=x*x-4*x
f3(x)=x*x-6*x

set size ratio 0.5
set key right reverse

plot 0 ls 4 title 'poly(x)', \
     f1(x) ls 1 title 'poly1(x)', \
     f2(x) ls 2 title 'poly2(x)', \
     f3(x) ls 3 title 'poly3(x)'
