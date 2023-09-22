#include<iostream>
#include "p2.cpp"
using namespace std;

void function1(int number); // function prototype
void greet();


int main(){

    cout<<"Inside main function"<<endl;
    function1(6);
    greet();
    
    return 0;
}