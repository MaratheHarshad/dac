// Given a string, return its length.
// int Strlen(char s[]);

#include<iostream>
using namespace std;

void readString(char str[], int size)
{
    cout<<"Enter the string : ";
    cin.get(str, size);
}


int Strlen(char  str[])
{
    int iCounter=0;
    while(*str != '\0')
    {
        str++;
        iCounter++;
    }
    cout<<"\n";
    

    return iCounter;
}

int main()
{
    char str[100];

    // Enter the string
    readString(str, 100);
    int length = Strlen(str);
    cout<<"No of character in string are : "<<length<<endl;
    
    return 0;
}

