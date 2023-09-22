/*
2. Find prime numbers between two positive integers N and M, including N and M.
For example:
N = 3
M = 10
Prime Numbers = 3 5 7
*/


/*
Find prime number between two positive integers and print them
*/

#include<iostream>
using namespace std;



bool isPrime(int iNumber)
{
    int iCnt=1;

    for(iCnt=2; iCnt<=(iNumber/2) ;iCnt++)
    {
        if((iNumber%iCnt)==0)
        {
            return false;
        }
    }

    return true;
}

void print_Prime_Bet(int iM,int iN)
{
    for(int iCnt=iM;iCnt<=iN;iCnt++)
    {

        if(iCnt == 1){
            continue;
        }
        
        
        if(isPrime(iCnt)){
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























