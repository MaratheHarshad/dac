/*
find the first digit in a positive integer
Input 53
output 5


*/
#include<iostream>
using namespace std;

void print_First_digit(int iNum)
{
    int iDigit = 0;
    
    while(iNum!=0)
    {
    iDigit = iNum%10;
    iNum = iNum/10;
    }
    cout<<"First digit of number is : "<<iDigit;

}
int main()
{   
    int iNo=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iNo;

    }while(iNo < 1);
    
    print_First_digit(iNo);

    return 0;
}