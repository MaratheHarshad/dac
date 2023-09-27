#include<iostream>
using namespace std;

int *add(int a, int b){


    int res = a + b;
    cout<<&res<<endl;
    return &res;
}

int main(){

    int a = 5;
    int b = 10;

    int* r = add(8,8);
    cout<<&r<<endl;

    cout<<*r<<endl; // segmentation fault (core dumped) occurs -> because *r trying to access the invalid memory location
}

// segmentation fault is a runtime error 
// segmentatio fault occurs when pointer variable is trying to access the invalid memory location