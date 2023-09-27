/*
Find the count of digits in given positive Number N
*/
#include<iostream>
using namespace std;

int count_Digits(int iNum)
{
    
    int iCnt=0;

    while(iNum!=0)
    {
        iNum = iNum/10;
        iCnt++;
    }

    return iCnt;

}
int main()
{   
    int iNo=0;
    int iRet=0;
    
    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iNo;

    }while(iNo < 1);
    
    iRet=count_Digits(iNo);
    cout<<"Number of digits in given integer are "<<iRet<<endl;

    return 0;
}