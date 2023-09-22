#include<iostream>
using namespace std;

int check_Prime(int iNumber)
{
    int iCnt=1;

    for(iCnt=2;iCnt<(iNumber/2);iCnt++)
    {
        if((iNumber%iCnt)==0)
        {
            return 1;
        }
    }

    return 0;
}
int main()
{
    int Input;
    
    cout<<"Enter the number want to check"<<endl;
    cin>>Input;

    if(check_Prime(Input)){
        cout<<"The given number isn't prime number"<<endl;
    }else{
        cout<<"The given number is prime number"<<endl;
    }

    return 0;
}

