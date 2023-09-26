// 5. Write a program to calculate Net Salary of an employee. Accept Basic Salary (BS) from the user.

// HRA is 15% of BS
// DA is 30% of BS
// PF is 12.5% of GS
// Gross Salary is BS + HRA + DA
// Net Salary = Gross Salary – PF



#include <iostream>
using namespace std;

float findPercent(float number, float percent){

    return (number * 15) / percent;
}



float calculateNetSalary(float basicSalary){



    float HRA = findPercent(basicSalary , 15);
    float DA = findPercent(basicSalary , 30);
    float PF = findPercent(basicSalary , 12.5);

    float grossSalary = basicSalary + HRA + DA;

    float netSalary = grossSalary - PF;




    return netSalary;
}




int main(){

    float basicSalary;

    cout<<"Enter Basic Salary : "<<endl;
    cin>>basicSalary;
    cout<<"Net Salary is : "<< calculateNetSalary(basicSalary);



}
