// Compare the two strings and return true if they are same else return false.
// bool Compare(char s1[], char s2[]);
/* Declare s1 and s2
   Accept strings 
   Accept string function definition

*/

#include<iostream>
#include<stdio.h>
using namespace std;

bool Compare(char s1[], char s2[])
{
     while(*s1!='\0')
     {
      if(*s1==*s2)
      {
        s1++;
        s2++;
      }else
      {
        return false;
      }
     }    

     return true;
}

void Accept(char S1[])
{
    gets(S1);
}

int main()
{
    char str1[30];
    char str2[30];
     
    cout<<"Enter string 1 : \n";
    Accept(str1);

    cout<<"Enter string 2 : \n";
    Accept(str2);

    bool result  = Compare(str1,str2);

    if(result == true){

        cout<<str1<<" and "<<str2<<" are equal"<<endl;

    }else{

        cout<<str1<<" and "<<str2<<" are not equal"<<endl;
    }
    return 0;
}
