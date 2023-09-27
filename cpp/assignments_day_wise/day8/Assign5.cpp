// 4. In the given string, convert all lower case chanracters to upper case.
// void ToUpper(char s[]);

#include<iostream>
#include<stdio.h>
using namespace std;

void ToLower(char s1[])
{
     while(*s1!='\0')
     {

        if((int)(*s1) <= 90)
        {
            *s1 = (char)((int)(*s1) + 32);
        }

        s1++;

     }    
   
}

void Accept(char S1[])
{
    gets(S1);
}

int main()
{
    char str1[30];
   
    cout<<"Enter string  : \n";
    Accept(str1);

    cout<<str1<<" before toLower"<<endl;

    ToLower(str1);

    cout<<str1<<" after toLower"<<endl;

    
    return 0;
}
