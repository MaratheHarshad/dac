/*
Find prime number between two positive integers and print them
*/

#include<iostream>
using namespace std;

int check_Prime(int iNumber)
{
    int iCnt=1;

    for(iCnt=2; iCnt<iNumber; iCnt++)
    {
        if((iNumber%iCnt)==0)
        {
            return 1;
        }
    }

    return 0;
}
void print_Prime_Bet(int iM,int iN)
{
    for(int iCnt=iM;iCnt<=iN;iCnt++)
    {

        if(iCnt == 1){
            continue;
        }
        
        int iRet = check_Prime(iCnt);

        if(iRet == 0){
            cout<<iCnt<<" ";
        }
    }
}
int main()
{   
    int M,N;

    cout<<"Enter the numbers"<<endl;
    cin>>M>>N;
     
    print_Prime_Bet(M,N) ;

    return 0;
}

// 2 10

// 3     10


// 3  0 prime
// 4  1 Np
// 5  0 prime
// 6   1 np























