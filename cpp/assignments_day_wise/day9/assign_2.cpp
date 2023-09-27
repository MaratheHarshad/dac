 /*Implement a Date class with following member functions. Also overload remaining relational operators to compare two dates.
   Also write a small program to demonstrate the use of Date class and overloaded relational operators.
class Date {
	int day;
	int month;
	int year;
public:
	Date();
	Date(int d, int m, int y);
	void Read();
	void Write();
	bool operator==(Date obj2);
*/

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

    return 0;
}