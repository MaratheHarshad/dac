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

int reverse(int iNo)
{
    int Ans = 0;
    int iDigit = 0;

    while(iNo != 0){

        iDigit = iNo % 10;
        Ans = Ans * 10 + iDigit;
        iNo = iNo / 10;
    }
    
    return Ans;

}


void isPalindrome(int iNo)
{
    int iReverse=0;

    iReverse=reverse(iNo);
    
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

    isPalindrome(iNo);

    return 0;
}