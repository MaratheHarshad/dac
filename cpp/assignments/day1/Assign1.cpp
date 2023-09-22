/*
Given the positive integer N,Find all factors of N.
*/

#include<iostream>
using namespace std;

void print_Factors(int iNumber)
{
    int iCnt=0;

    for(iCnt=1;iCnt<=iNumber;iCnt++)
    {
        if((iNumber%iCnt)==0)
        {
            cout<<iCnt<<"\t";
        }
    }
}
int main()
{
    int iInput=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iInput;

    }while(iInput < 1);

    print_Factors(iInput);

    return 0;
}