// 20. Find the sine value of an angle by calculating the following series up to first 5 items

// sin(x) = x – x^3/3! + x^5/5! – x^7/7! + x^9/9!
// Where x is in radians.
// Radian = 180/PI
// PI = 3.142
// Make use of following functions:
// int factorial(int); and int power(int, int);

#include <iostream>
using namespace std;

float pow(int num, int power){

    float result = 1;

    while(power != 0){
        result *= num;
        power--;
    }

    return result;

    
}

int fact(int number){

    int result = 1;

    while(number > 0){
        result *= number;
        number--;
    }

    return result;
}

int main(){

    int x;
    cout<<"Enter x ";
    cin>>x;


    float result = x - (pow(x,3)/fact(3)) + (pow(x,5)/fact(5)) - (pow(x,7)/fact(7)) + (pow(x,9)/fact(9));

    cout<<result;


}