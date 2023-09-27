/*
Find the sum of all digits in a given number
*/
#include<iostream>
using namespace std;

int sum_of_Digits(int iNUm)
{
    int iSum=0;
    int iDigit=0;

    while(iNUm!=0)
    {
        iDigit=iNUm%10;
        iSum=iSum+iDigit;
        iNUm=iNUm/10;
    }
    return iSum;
}
int main()
{
    int iNo=0;
    int iRet = 0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iNo;

    }while(iNo < 1);
    
    iRet=sum_of_Digits(iNo);
    cout<<"Summation of all digits is "<<iRet;
    
    return 0;
}