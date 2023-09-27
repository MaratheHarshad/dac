/*
find the sum between two positive integers M & N including M & N 
*/

#include<iostream>
using namespace std;

int print_Sum_Bet(int iM,int iN)
{
    int iSum=0;
    for(int i=iM;i<=iN;i++)
    {
       iSum=iSum+i;
    }
    return iSum;
}
int main()
{   
    int M,N;
    int iRet=0;

    cout<<"Enter the numbers"<<endl;
    cin>>M>>N;
     
    iRet=print_Sum_Bet(M,N) ;

    cout<<"Summation between M And N is "<<iRet<<endl;

    return 0;
}