#include<iostream>
using namespace std;
//How to read a declaration?
int main()
{
	int a; //a is an integer
	
	int *b; //b is a pointer to an integer
	
	float c[5]; //c is an array of float
	
	
	int *d[3]; //d is an array of pointers to integer
	
	double (*e)[5]; //e is a pointer to an array of doubles
	
 char (*f[3])[3]; //f is an array of ptrs to an array of chars	
 
	void (*g)(int);  // g is a pointer to fn with return
			//type void and int arg.
			
	int (*h[2])(float, float); //h is an array of pointers
	//to function with return type int and 2float args
	
	return 0;
}

