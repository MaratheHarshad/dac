/*
Given a positive integer N,Check whether it is armstrong or not
*/
#include<iostream>
using namespace std;

int check_Armstrong(int iNumber)
{
    int iDigit=0;
    int iSum=0;
    
    while(iNumber!=0)
    {
        iDigit=iNumber%10;
        iSum=iSum+(iDigit*iDigit*iDigit);
        iNumber=iNumber/10;
    }
    cout<<"Sumation is"<<iSum<<endl;
    
    return iSum;

}
int main()
{
    int Input=0;
    int iRet=0;

    cout<<"Enter the Number want to check"<<endl;
    cin>>Input;
    
    iRet=check_Armstrong(Input);

    if(iRet==Input)
    {
       cout<<"The given number is armstrong number"<<endl;
    }else
    {
        cout<<"The given number is not armstrong number"<<endl;
    }
    return 0;
}