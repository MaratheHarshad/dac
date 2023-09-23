// 2. Copy the source string "src" into destination string "dest".
// void StrCpy(char dest[], char src[]);


#include<iostream>
using namespace std;


void readString(char str[], int size)
{
    cin.get(str, size);
}


void printString(char  str[]){

    while(*str != '\0'){
        cout<<*str;
        str++;
    }

    cout<<endl;
}

void StrCpy(char dest[], char src[]){

    while(*src != '\0'){
        *dest = *src;
        src++;
        dest++;
    }

    *dest = '\0';

}

int main()
{
    char src[100];
    char dest[100];

    // Enter the src string
    cout<<"Enter source string : ";
    readString(src, 100);

    StrCpy(dest, src);

    cout<<"source string is ";
    printString(src);
    cout<<"destination string is ";
    printString(dest);
    
}
