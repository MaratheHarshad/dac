// Assignment:
// Implement swap function to swap two values.
// Overload the function for various types.
// Implement function using reference.



#include<iostream>
using namespace std;


void swap(int &p, int &q)
{
    int temp = p;
    p = q;
    q = temp;
    
}


void swap(float &p, float &q)
{
    float temp = p;
    p = q;
    q = temp;
    
}

int main()
{
    int a = 5;
    int b = 10;

    cout<<"Before Swapping"<<endl;
    cout<<"a : "<<a<<endl;
    cout<<"b : "<<b<<endl;



    swap(a,b);

    cout<<"After Swapping"<<endl;
    cout<<"a : "<<a<<endl;
    cout<<"b : "<<b<<endl;



    float c = 5.6f;
    float d = 10.20f;

    cout<<"Before Swapping"<<endl;
    cout<<"c : "<<c<<endl;
    cout<<"d : "<<d<<endl;



    swap(c,d);

    cout<<"After Swapping"<<endl;
    cout<<"c : "<<c<<endl;
    cout<<"d : "<<d<<endl;
    
    return 0;
}