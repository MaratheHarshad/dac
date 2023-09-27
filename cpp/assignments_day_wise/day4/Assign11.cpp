/*
Given a positive integer N,Check whether it is armstrong or not
*/
#include<iostream>
using namespace std;

int pow(int num, int r){

    int result = 1;

    while(r > 0){
        result *= num;
        r--;
    }

    return result;

}


int getCountOfDigits(int number){

    int count = 0;

    while(number != 0){
        number /= 10;
        count++;
    }

    return count;
}

int check_Armstrong(int iNumber)
{
    int iDigit=0;
    int iSum=0;
    int countOfDigits = getCountOfDigits(iNumber);
    
    while(iNumber!=0)
    {
        iDigit=iNumber%10;
        iSum=iSum+pow(iDigit , countOfDigits);
        iNumber=iNumber/10;
    }
    // cout<<"Sumation is"<<iSum<<endl;
    
    return iSum;

}
int main()
{
    int Input=0;
    int iRet=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>Input;

    }while(Input < 1);
    
    iRet=check_Armstrong(Input);

    if(iRet==Input)
    {
       cout<<"The given number is armstrong number "<<endl;
    }else
    {
        cout<<"The given number is not armstrong number "<<endl;
    }
    return 0;
}