
// 1. Given a positive integer N, find its reverse.
// For example:
// N = 534
// Reverse = 435
// N = 5
// Reverse = 5


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


int main()
{
    int input=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>input;

    }while(input < 1);
    
    int Ans = reverse(input);

    cout<<"Reverse number is "<<Ans<<"\n";

    return 0;
}


