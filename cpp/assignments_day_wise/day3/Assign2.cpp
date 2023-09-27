// Given a positive integer N, find its reverse.

#include<iostream>
using namespace std;

int reverse_Num(int iNo)
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


int main()
{
    int iN=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iN;

    }while(iN < 1);
    
    int Ans = reverse_Num(iN);

    cout<<"Reverse number is "<<Ans<<"\n";

    return 0;
}