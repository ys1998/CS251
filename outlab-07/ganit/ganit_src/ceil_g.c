#include "../ganit.h"

/* Definition of double _ceil(double a); in this file */
double _ceil(double a){
	long long num = (long long)a;
	if (a == (double)num) {
		return num;
	}
	else if(a > 0)	return num + 1;
	return num;
}
