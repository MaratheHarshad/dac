#include<iostream>
using namespace std;


void printString(char  str[]){

    while(*str != '\0'){
        cout<<*str;
        str++;
    }
}


void readString(char str[], int size){
    cout<<"Enter the string : ";
    cin.get(str, size);

}

int main(){

    char str[100];

    // Enter the string
    readString(str, 100);
    printString(str);
    
    

}

