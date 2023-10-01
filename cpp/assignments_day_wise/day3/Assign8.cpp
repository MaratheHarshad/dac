/*
Find product of all the digits in given number
*/
#include<iostream>
using namespace std;

int product_of_Digits(int iNUm)
{
    int iProd=1;
    int iDigit=0;

    while(iNUm!=0)
    {
        iDigit=iNUm%10;
        iProd=iProd*iDigit;
        iNUm=iNUm/10;
    }
    return iProd;
}
int main()
{
    int iNo=0;
    int iRet = 0;

    cout<<"Enter the number"<<endl;
    cin>>iNo;
    
    iRet=product_of_Digits(iNo);
    cout<<"Product of all digits is "<<iRet;
    
    return 0;
}