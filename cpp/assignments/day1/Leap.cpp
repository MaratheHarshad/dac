
//write a program to find leap year by using
//a) if-else and logical operators
//b) Conditional operators

#include<iostream>
using namespace std;

void check_leap(int iYr)
{   
    if(iYr%4==0 && iYr%400==0 || iYr % 100 != 0)
    {
        cout<<"The given year is leap year\n";
    }else
    {
        cout<<"The given year is not leap year\n";
    }
}
int main()
{   
    int iYear = 0;

    cout<<"Enter the year\n";  
    cin>>iYear;

    check_leap(iYear);

    return 0;
}