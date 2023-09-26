#include<stdio.h>

int main()
{
	int a;  // a is an int
	
	int *b; // b is a pointer to an integer
	
	int c[5]; // c is an array of integer
	
	char *d[3]; //d is an array of pointers to character
	
	float (*e)[4]; //e is a pointer to an array of float 
	
	double (*f[2])[2]; //f is an array of pointers to an 
			   //array of doubles
	
	void (*g)(float); // g is a pointer to function with
			  // return type void and float arg.
	
	float (*h[2])(int, int); // h is an array of pointers
				 //to function with return type
				 //float and 2 int args.
	return 0;
}
