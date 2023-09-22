#include<iostream>
using namespace std;



int main(){

    int choice = 2;

    switch(choice){

        case 1:
            cout<<"Case 1";


        case 2:
            cout<<"Case 2";


        
        case 3:
            cout<<"Case 3";

        default:
            cout<<"Default case";

    }
}


// Without Break statement all the statements below the matching case along with default would execute