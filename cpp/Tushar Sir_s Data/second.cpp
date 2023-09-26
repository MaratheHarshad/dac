#include<stdio.h>

//() paranthesis  [] subscripts	 {}  block

int main()
{
  int x=19;
  int arr[5]={10,20,30,40,50};
	
  printf("%u\n",arr);  //1000
  printf("%u\n",&arr); //1000
  printf("%u\n",*arr); //10
	
  printf("%u\n",arr+1);  //1004
  printf("%u\n",&arr+1); //1020
  printf("%u\n",*arr+1); //11
	
  //printf("%u\n", ++arr); //error  int * const arr
	
  printf("%u\n",arr[3]);
	
  return 0;
}
