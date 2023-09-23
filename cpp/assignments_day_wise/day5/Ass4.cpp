/*
Given a positive integer N, check if its palindrome or not. A palindrome number is a number that is same as its reverse.
For example:
Number = 32
Not a palindrome. (Reverse is 23 and not same as 32)
Number = 545
A palindrome. (Reverse is 545 and not same as 545)
*/
#include<iostream>
using namespace std;

int reverse_the_Number(int iNo)
{
    int iDigit=0;
    int iRev=0;

    while(iNo!=0)
    {
        iDigit=iNo%10;

        iRev=iRev*10 + iDigit;

        iNo = iNo / 10; 
    }
    cout<<"Reverse number is "<<iRev<<endl;
    return iRev; 
}
void check_pallindrome(int iNo)
{
    int iReverse=0;

    iReverse=reverse_the_Number(iNo);
    
    if(iReverse==iNo)
    {
        cout<<iNo<<" is pallindrome number"<<endl;
    }else{
        cout<<iNo<<" isn't pallindrome number"<<endl;
    }
}
int main()
{   
    int iNo=0;

    do{
        cout<<"Enter the number\n";
        cin>>iNo;
    }while(iNo<0);

    check_pallindrome(iNo);

    return 0;
}