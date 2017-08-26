#http://lowrank.net/gnuplot/plotpm3d-e.html#6.7
#http://www.techrepublic.com/blog/linux-and-open-source/how-to-create-conditional-plotting-with-gnuplot/
#http://www.careerride.com/view/why-the-origin-of-z-axis-is-not-on-the-xy-plane-gnuplot-programming-3448.aspx
set xrange [-4 : 4]
set yrange [-4 : 4]
#set zrange [0:1000]
set xtics 2;
set ytics 2;
set ticslevel 0;
#set ztics 200;
set pm3d;
set linetype 1 lc rgb "yellow";
func(x,y) = ( x+y>0 ? 1000/64*(x+y)*(x+y) : 1/0);
splot func(x,y) linetype(1);
