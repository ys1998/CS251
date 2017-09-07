#include "../ganit.h"

/* Definition of double factorial(double a); in this file */
// You must cast 'a' as int in the body.

double factorial(double a){
	if((int) a < 0)		return 0;
	double f = 1;
	for(int i = (int) a; i > 0; i--)	f *= i;
	return f;
}

