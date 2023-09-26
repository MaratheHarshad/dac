// 23. Write a program which accepts two integers in main(). Pass these as arguments to function
// max(). In max(), find the maximum of these two numbers and using a return statement, return
// the address of the maximum number and print it in main().


#include <iostream>
using namespace std;


int * maxNumber(int &first, int &second){
    return first > second ? &first :  &second;
}

int main(){

    int first;
    int second;


    cout<<"enter nos ";
    cin>>first>>second;

    int *max = maxNumber(first, second);

    cout<<"Max is "<<*max<<endl;
    
}