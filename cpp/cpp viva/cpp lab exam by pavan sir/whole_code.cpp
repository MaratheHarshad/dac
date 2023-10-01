

// // member variables -> 
// // acc number -> int
// // acc type -> (saving , current) -> string
// // acc balance -> saving = 0, current = 1000
// // acc name -> string


// // member functions

// // withdraw(int accno, int amount)
// // validation , acc balance >= amount


// // deposite (int accno, int amount)
// // accbalance += amount;

// // display 
// // display this account details


// // constructor
// // Account(accname , acctype)
// // if acctype = 'saving'
//     // balance = 0;
// // else if acctype = 'current'
//     // balance = 1000


// #include <iostream>
// #include <stdio.h>
// #include <string.h>

// using namespace std;

// class Account {

//     int accNumber;
//     char accType [10];
//     double accBalance;
//     char accName [20];

//     static int count;


//     public:

//         Account();
//         Account(char *accType, char *accName);


//         void deposite(int amount);
//         void withdraw(int amount);
//         void display();
//         int getAccountNumber();

// };


// Account:: Account(){

// }

// Account:: Account(char *accType, char *accName){

//         Account::count++;

//         strcpy(this->accType, accType);
//         strcpy(this->accName, accName);    
//         this->accNumber = count;
        
//         // if account type is saving
//         if(strcmp(accType, "saving") == 0 || strcmp(accType, "s") == 0){
//             this->accBalance = 0;
//         }
//         else{
//             this->accBalance = 1000;
//         }


//         cout<<"Account created"<<endl;


// }

// void Account:: deposite(int amount){

//     cout<<"Balance before deposite "<<this->accBalance<<endl;

//     this->accBalance += amount;

//     cout<<"Balance after deposite "<<this->accBalance<<endl;


// }

// void Account:: withdraw(int amount){
//     // validation amount <= balance

//     if (amount > this->accBalance){
//         cout<<"Insufficient Balance"<<endl;
//         return;
//     }

//     cout<<"Balance before withdraw "<<this->accBalance<<endl;

//     this->accBalance -= amount;

//     cout<<"Balance after withdraw "<<this->accBalance<<endl;





// }


// void Account:: display(){


//     cout<<"****************************************"<<endl;

//     cout<<"Account Name : "<<this->accName<<endl;
//     cout<<"Account Number : "<<this->accNumber<<endl;
//     cout<<"Account Type : "<<this->accType<<endl;
//     cout<<"Account Balance : "<<this->accBalance<<endl;

//     cout<<"****************************************"<<endl;
    
// }


// int Account:: getAccountNumber(){

//     return this->accNumber;

// }

// int Account:: count = 0;


// Account & createAccount(Account &obj, char *accType, char *accName){

//     Account o(accType, accName);
//     obj = o;

//     return obj;
// }



// int main(){


//     Account objects[100];
//     int index = -1;
//     int i = 0;
//     int accNumber = 0;
//     char accName[50];
//     char accType[10];


//     while(true){


//         int choice;
//         int amount = 0;

//         cout<<"Enter Your Choice"<<endl;
//         cout<<"1. Add Account"<<endl;
//         cout<<"2. Withdraw"<<endl;
//         cout<<"3. Deposite"<<endl;
//         cout<<"4. Display All Account Details"<<endl;
//         cout<<"5. Display Account Details"<<endl;


//         cin>>choice;

//         Account obj;


//         switch (choice)
//         {
//             case 1:
//                 // Add Account
                
                

//                 cout<<"Enter Account Name :";
//                 cin>>accName;


//                 do
//                 {
//                     cout<<"Enter Account Type :";
//                     cin>>accType;

//                 } while (!(strcmp(accType, "saving") == 0 || strcmp(accType, "current") == 0 || strcmp(accType, "s") == 0 || strcmp(accType, "c") == 0));

//                 obj = createAccount(obj, accType, accName);

//                 objects[++index] = obj;

                
//                 break;

//             case 2:

//                 // withdraw amount;

//                 cout<<"Enter Amount ";
//                 cin>>amount;



//                 do
//                 {
                
//                     cout<<"Enter account number to withdraw amount ";
//                     cin>>accNumber;
//                     i = 0;

                

//                     for(i = 0; i <= index; i++){

//                         if(objects[i].getAccountNumber() == accNumber){
//                             objects[i].withdraw(amount);
//                             break;
//                         }

//                     }

//                 } while (i > index);
                



//                 break;

//             case 3:

//                 // deposite

//                 cout<<"Enter Amount ";
//                 cin>>amount;
                

//                 do
//                 {
                
//                     cout<<"Enter Account Number ";
//                     cin>>accNumber;

//                     i = 0;

                

//                     for(i = 0; i <= index; i++){

//                         if(objects[i].getAccountNumber() == accNumber){
//                             objects[i].deposite(amount);
//                             break;
//                         }

//                     }

//                 } while (i > index);


//                 break;

//             case 4:
//                 // display all account details

//                 for(i = 0; i <= index; i++){
//                     objects[i].display();
//                 }


//                 break;

//             case 5: 

                

//                 // display 

//                 do
//                 {
                
//                     cout<<"Enter Valid Account Number to Display Details ";
//                     cin>>accNumber;

//                     i = 0;

                

//                     for(i = 0; i <= index; i++){

//                         if(objects[i].getAccountNumber() == accNumber){
//                             objects[i].deposite(amount);
//                             break;
//                         }

//                     }

//                 } while (i > index);

//                 break;






            
//             default:
//                 cout<<"Please Enter a valid choice"<<endl;

//         }



//     }

// }




