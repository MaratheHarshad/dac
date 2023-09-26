// 8.

// Write a program to accept the basic salary and total sales amount for a salesperson and
// calculate commission according to sales amount. Display the net salary and commission earned.
// (Net Salary = Basic Salary + Commission) The range is as follows.
// Sales Amount in Rupees Commission on Sales
// 5000 to 7500 3%
// 7501 to 10500 8%
// 10501 to 15000 11%
// 15000 and above 15%


#include <iostream>
using namespace std;


float findPercent(float number, float percent){

    return (number * percent) / 100;
}

int main(){

    int basicSalary;
    int totalSalesAmount;

    cout <<"Enter basic salary : ";
    cin>>basicSalary;

    cout <<"Enter sales amount : ";
    cin>>totalSalesAmount;

    int commission = 0;

    if(totalSalesAmount >= 5000 && totalSalesAmount <= 7000){
        commission = findPercent(totalSalesAmount , 3);
    }else if(totalSalesAmount >= 7501 && totalSalesAmount <= 10500){
        commission = findPercent(totalSalesAmount , 8);
    }else if(totalSalesAmount >= 10501 && totalSalesAmount <= 15000){
        commission = findPercent(totalSalesAmount , 11);
    }else if(totalSalesAmount > 15000){
        commission = findPercent(totalSalesAmount , 15);
    }


    cout<<"Net salary is "<< basicSalary + commission<<endl;
    cout<<"Commission earned "<< commission<<endl;
    




}