/*
Swapping values stored in two differnt variables using pointers
*/
#include<iostream>
using namespace std;


void swap(int *p, int *q)
{
    int temp = *p;
    *p = *q;
    *q = temp;
    
}

int main()
{
    int a = 5;
    int b = 10;

    cout<<"Before Swapping"<<endl;
    cout<<"a : "<<a<<endl;
    cout<<"b : "<<b<<endl;



    swap(&a,&b);

    cout<<"After Swapping"<<endl;
    cout<<"a : "<<a<<endl;
    cout<<"b : "<<b<<endl;
    
    return 0;
}