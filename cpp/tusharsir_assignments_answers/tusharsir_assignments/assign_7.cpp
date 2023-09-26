// 7. Write a program to find leap year by using:
// a. if-else and logical operators (&amp;&amp; and ||)
// b. Conditional Operators (? :)

// b ->


#include <iostream>
using namespace std;

int main(){

    int year;
    cout<<"enter year : ";
    cin>>year;

    // bool result = (year % 4 == 0 && year % 100 != 0) ? true : year % 400 == 0 ? true : false;

    // without using logical operator
    bool result = year % 4 == 0 ? year % 100 != 0 ?  true : year % 400 == 0 ? true : false : false;


    cout<<result<<endl;;

    if(result == true){
        cout<<"leap year";
    } 
    else{
        cout<<"not leap year";
    }

    cout<<endl;
}