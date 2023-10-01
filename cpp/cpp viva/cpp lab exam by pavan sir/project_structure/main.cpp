

#include <iostream>
#include <string.h>
#include <cstdio>
#include "Account.h"

using namespace std;




Account & createAccount(Account &obj, char *accType, char *accName){

    Account o(accType, accName);
    obj = o;

    return obj;
}




int main(){


    Account objects[100];
    int index = -1;
    int i = 0;
    int accNumber = 0;
    char accName[50];
    char accType[10];


    while(true){


        int choice;
        int amount = 0;

        cout<<endl;
        cout<<"Enter Your Choice"<<endl;
        cout<<"1. Add Account"<<endl;
        cout<<"2. Withdraw"<<endl;
        cout<<"3. Deposite"<<endl;
        cout<<"4. Display All Account Details"<<endl;
        cout<<"5. Display Account Details"<<endl;
        cout<<endl;


        cin>>choice;

        Account obj;


        switch (choice)
        {
            case 1:
                // Add Account
                
                
                cout<<endl;
                cout<<"Enter Account Name :";
                cin>>accName;


                do
                {
                    cout<<endl;
                    cout<<"Enter Account Type :";
                    cin>>accType;

                } while (!(strcmp(accType, "saving") == 0 || strcmp(accType, "current") == 0 || strcmp(accType, "s") == 0 || strcmp(accType, "c") == 0));

                obj = createAccount(obj, accType, accName);

                objects[++index] = obj;

                
                break;

            case 2:

                // withdraw amount;
                cout<<endl;
                cout<<"Enter Amount ";
                cin>>amount;



                do
                {
                    cout<<endl;
                    cout<<"Enter account number to withdraw amount ";
                    cin>>accNumber;
                    i = 0;

                

                    for(i = 0; i <= index; i++){

                        if(objects[i].getAccountNumber() == accNumber){
                            objects[i].withdraw(amount);
                            break;
                        }

                    }

                } while (i > index);
                



                break;

            case 3:

                // deposite
                cout<<endl;
                cout<<"Enter Amount ";
                cin>>amount;
                

                do
                {
                    cout<<endl;
                    cout<<"Enter Account Number ";
                    cin>>accNumber;

                    i = 0;

                

                    for(i = 0; i <= index; i++){

                        if(objects[i].getAccountNumber() == accNumber){
                            objects[i].deposite(amount);
                            break;
                        }

                    }

                } while (i > index);


                break;

            case 4:
                // display all account details

                if (index < 0){
                    cout<<endl;
                    cout<<"Empty "<<endl;
                    cout<<endl;
                }

                for(i = 0; i <= index; i++){
                    objects[i].display();
                }


                break;

            case 5: 

                

                // display 

                do
                {
                    cout<<endl;
                    cout<<"Enter Valid Account Number to Display Details ";
                    cin>>accNumber;

                    i = 0;

                

                    for(i = 0; i <= index; i++){

                        if(objects[i].getAccountNumber() == accNumber){
                            objects[i].display();
                            break;
                        }

                    }

                } while (i > index);

                break;


            case 6:
                exit(0);



            
            default:
                cout<<endl;
                cout<<"Please Enter a valid choice"<<endl;
                cout<<endl;

        }



    }

}

