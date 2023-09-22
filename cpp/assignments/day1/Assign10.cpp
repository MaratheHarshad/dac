/*
Given a positive integer and check whether its perfect number or not
*/

#include<iostream>
using namespace std;


int sum_of_factors(int iN)
{  
    int iSum=0;
   for(int iCnt=0;iCnt<iN;iCnt++)
   {   
       if((iN%iCnt)==0)
       {
          iSum=iSum+iCnt;
       }
   }
   return iSum;
}

int main()
{
    int iNum=0;
    int iRet=0;

    cout<<"Enter any positive integer"<<endl;
    cin>>iNum;

    iRet=sum_of_factors(iNum);
    
    if(iRet==iNum)
    {
        cout<<iNum<<"is perfect number "<<endl;
    }
    return 0;
}