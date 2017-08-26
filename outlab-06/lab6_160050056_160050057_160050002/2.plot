set xrange [0 : 3]
set yrange [0 : 3]
set isosamples 3	;
set samples 4;
set linetype 1 lc rgb 0x006400 lw 3;

set title "Ackermann function";
ack(x,y) = ( x==0 ? y+1 : y==0 ? ack(x-1,1) : ack(x-1,ack(x,y-1)));
#ack(x,y) = (int(x)!=0 && int(y)!=0 ? ( x>0 ? y+1 : y==0 ? ack(x-1,1) : ack(x-1,ack(x,y-1))) : 1/0);
splot ack(x,y) linetype(1);
