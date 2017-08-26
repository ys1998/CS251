set key title sprintf("t = %f s",time)
plot f(x) title "   5sin(2x-100t)" with line dt '-' lw 1,\
	 g(x) title "   10sin(2x+50t)" with line dt '-' lw 1,\
	 f(x)+g(x) title "Superposed wave" with line lt rgb "black" lw 2
time=time+0.001
if(time<end_time) reread