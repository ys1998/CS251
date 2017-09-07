#include "../ganit.h"

/* Definition of double isPrime(double a); in this file */
// You must cast 'a' to int in the body.
double isPrime(double a){
	long long m = (long long) a;
	for(int i = 2; i * i <= m ; i++)
		if(m % i == 0)	return 0;
	return 1;
}
