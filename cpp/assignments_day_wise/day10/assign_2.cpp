 
// 2. For the Date class overload following operators.
//    Binary operator + to work with
//    - one Date operand and one int
//    Binary operator - to work with
//    - both operands of type Date
//    - one Date operand and one int
//    Unary operators ++ and -- in both pre and post form.
//    Also write a small program to demonstrate the use of Date class and overloaded relational operators.

#include<iostream>
using namespace std;

class Date 
{ 
 public:   
    int day;
	int month;
	int year;
 public:
     Date()
     {
         cout<<"Default constructor\n";
     } 
     Date(int d, int m, int y)
     {
        day=d;
        month=m;
        year=y;
     }  
     void Read()
    {
        cout<<day<<"-"<<month<<"-"<<year<<endl;     
    }
    void write()
    {
        cout<<"Enter the day\n";
        cin>>day;
        cout<<"Enter the month\n";
        cin>>month;
        cout<<"Enter the year\n";
        cin>>year;
    }


    
    bool isLeap(int iYr)
    {   
        if(iYr%4==0 && iYr%400==0 || iYr % 100 != 0)
        {
            return true;
        }else
        {
           return false;
        }
    }




    bool operator == (Date &other){
        
        if((this->day == other.day) && (this->month == other.month) && (this->year == other.year)){
            return true;
        }
        else{
            return false;
        }

    }



    bool operator > (Date &other){


        if(this->year > other.year){
            return true;
        }else if(this->year == other.year){

            if(this->month > other.month){
                return true;
            }else if(this->month == other.month){

                if(this->day > other.day){
                    return true;
                }else{
                    return false;
                }

            }else{
                return false;
            }

        }else{
            return false;
        }

        
        
        if((this->day == other.day) && (this->month == other.month) && (this->year == other.year)){
            return true;
        }
        else{
            return false;
        }

    }


     bool operator < (Date &other){
        
        if(*this == other){
            return false;
        }

        return !(*this > other);
     }

    // maybe we should return new object
    //post increment
     Date & operator ++ (int){

        // here incrementation of date is dependent on the month

        switch(this->month){

            case 1:

                if(this->day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 2;
                }

                break;

            case 2:

                if (day < 28){
                    day++;
                }else if(day == 28 && isLeap(year)){
                    day = 29;
                }else{
                    day = 1;
                    month = 3;
                }


                break;

            case 3:

                if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 4;
                }


                break;

            case 4:

                 if (day < 30){
                    day++;
                }else{
                    day = 1;
                    month = 5;
                }

                break;

            case 5:

                 if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 6;
                }

                break;

            case 6:

                 if (day < 30){
                    day++;
                }else{
                    day = 1;
                    month = 7;
                }


                break;

            case 7:

                 if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 8;
                }
                break;

            case 8:

                 if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 9;
                }
                break;

            case 9:

                 if (day < 30){
                    day++;
                }else{
                    day = 1;
                    month = 10;
                }
                break;

            case 10:

                 if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 11;
                }
                break;

            case 11:

                 if (day < 30){
                    day++;
                }else{
                    day = 1;
                    month = 12;
                }

                break;

            case 12:

                 if (day < 31){
                    day++;
                }else{
                    day = 1;
                    month = 1;
                    year++;
                }

                break;
        }

        return *this;

     }



};
int main()
{
    Date D1(26,9,2023);
    //D1.Read();

    Date D2;
    D2.write();
    D2.Read();

    if(D1 == D2){
        cout<<"same "<<endl;
    }else{
        cout<<"not same"<<endl;
    }


    if (D1 > D2){
        cout<<"D1 is after D2\n";
    }else{
        cout<<"D2 is after D1\n";
    }


     if (D1 < D2){
        cout<<"D1 is before D2\n";
    }else{
        cout<<"D2 is before D1\n";
    }

    D2.Read();
    D2++;
    D2.Read();

    return 0;
}