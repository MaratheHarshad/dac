


// 3. write a small program to demonstrate the use of String class and overloaded relational operators. Also Design (define what all constructors, member functions and operator functions to overload relational operators) and implement them.


#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;

class String
{
        char str[20];
        public:

          void getdata()
        {
             gets(str);

        }

         bool operator ==(String s)
        {
               if(!strcmp(str,s.str)){
                    return true;
               }

                return false;
        }





};

int main()
{
        String s1,s2;

        cout<<"Enter first string :: ";
        s1.getdata();
        cout<<"\nEnter second string :: ";
        s2.getdata();
        if(s1==s2)
        {
            cout<<"\nStrigs are Equal\n";
        }
        else
        {
            cout<<"\nStrings are Not Equal\n";
        }
        
        return 0;
}