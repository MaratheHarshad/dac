// Assignment: 

// 1. In String class, implement following:
//    - Copy constructor to perform deep copy.
//    - Overload assignment operator, to perform deep copy.



#include<iostream>
#include<stdio.h>
#include<string.h>
using namespace std;

class String
{
        char str[20];
        public:


        String(){

        }

        // copy constructor to perform deep copy of the object

        String (String &other){

            strcpy(str, other.str);

        }

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


        // overloading = operator to perform deep copy of the object (but without overloading it is performing deep copy as well i think)

        String & operator = (String &other){
            strcpy(str, other.str);
            return *this;
        }


        // if we want compiler to not internally call assignment operator , we have to write this empty function

        // String & operator = (String &){
            // strcpy(str, other.str);
            // return *this;
        // }




        void print(){

            cout<<str<<endl;
        }







};

int main()
{
        String s1;
        s1.getdata();

        String s2(s1);


        cout<<"s1 data ";
        s1.print();
        cout<<endl;
        cout<<"s2 data ";
        s2.print();
        cout<<endl;;
       

       s1.getdata();


        cout<<"s1 data ";
        s1.print();
        cout<<endl;
        cout<<"s2 data ";
        s2.print();
        cout<<endl;;
       

        s2 = s1;


        cout<<"s1 data ";
        s1.print();
        cout<<endl;
        cout<<"s2 data ";
        s2.print();
        cout<<endl;
       
       s1.getdata();

       cout<<"s1 data ";
        s1.print();
        cout<<endl;
        cout<<"s2 data ";
        s2.print();
        cout<<endl;



        
        return 0;
}