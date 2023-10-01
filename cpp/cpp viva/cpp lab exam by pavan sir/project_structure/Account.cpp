
#include <iostream>
#include <string.h>
#include "Account.h"


using namespace std;

Account:: Account(){

}

Account:: Account(char *accType, char *accName){

        Account::count++;

        strcpy(this->accType, accType);
        strcpy(this->accName, accName);    

        this->accNumber = count;
        
        // if account type is saving
        if(strcmp(accType, "saving") == 0 || strcmp(accType, "s") == 0){
            this->accBalance = 0;
        }
        else{
            this->accBalance = 1000;
        }

        cout<<endl;
        cout<<"Account created"<<endl;
        cout<<endl;


}

void Account:: deposite(int amount){

    cout<<"Balance before deposite "<<this->accBalance<<endl;

    this->accBalance += amount;

    cout<<"Balance after deposite "<<this->accBalance<<endl;


}

void Account:: withdraw(int amount){
    // validation amount <= balance

    if (amount > this->accBalance){
        cout<<endl;
        cout<<"Insufficient Balance"<<endl;
        cout<<endl;
        return;
    }

    cout<<"Balance before withdraw "<<this->accBalance<<endl;

    this->accBalance -= amount;

    cout<<"Balance after withdraw "<<this->accBalance<<endl;





}


void Account:: display(){


    cout<<"****************************************"<<endl;

    cout<<"Account Name : "<<this->accName<<endl;
    cout<<"Account Number : "<<this->accNumber<<endl;
    cout<<"Account Type : "<<this->accType<<endl;
    cout<<"Account Balance : "<<this->accBalance<<endl;

    cout<<"****************************************"<<endl;
    
}


int Account:: getAccountNumber(){

    return this->accNumber;

}

int Account:: count = 0;



