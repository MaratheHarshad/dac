// 2. Given a number, check if its prime or not. Return true if its prime else return false.
// bool isPrimt(int num);

#include<iostream>
using namespace std;

bool isPrime(int iNumber)
{
    int iCnt=1;

    for(iCnt=2;iCnt<(iNumber/2);iCnt++)
    {
        if((iNumber%iCnt)==0)
        {
            return false;
        }
    }

    return true;
}

int main()
{
    int Input;
    
    do{
    cout<<"Enter the positive number to check number is prime or not"<<endl;
    cin>>Input;
    }while(Input<0);

    bool bRes = isPrime(Input);

    //cout<<"bRes : "<<bRes<<endl;

    if(bRes == 1){
        cout<<"The given number prime number"<<endl;
    }else{
        cout<<"The given number is Not prime number"<<endl;
    }

    return 0;
}

