#include<iostream>
using namespace std;


void print_number(int &ref){

    cout<<"number is "<<ref<<endl;
    cout<<"address is "<<&ref<<endl;
}

int main()
{
    
    int a = 5;
    cout<<"number inside main "<<a<<endl;
    cout<<"address inside main "<<&a<<endl;
    print_number(a);

    return 0;
}