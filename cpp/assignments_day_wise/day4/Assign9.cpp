/*
Given the positive integer N  Check if its pallindrome or not
*/

#include<iostream>
using namespace std;

int reverse_Num(int iNo)
{
    int Ans = 0;
    int iDigit = 0;

    while(iNo > 0){

        iDigit = iNo % 10;
        Ans = Ans * 10 + iDigit;
        iNo = iNo / 10;
    }
    cout<<"Reverse number is "<<Ans<<"\n";
    
    return Ans;

}

int main()
{   int iNum = 0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iNum;

    }while(iNum < 1);

    int iRet;
    iRet=reverse_Num(iNum);
    
    if(iRet==iNum)
    {
        cout<<"The given number is palllindrome number\n";
    }else
    {
        cout<<"The given number is not pallindrome number\n";
    }
    return 0;
}    