// 1. Reverse the given number and return it.
// int reverse(int num);


#include <iostream>
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



bool isPrime(int iNumber)
{
    int iCnt=1;

    if (iNumber == 1) return false;

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

