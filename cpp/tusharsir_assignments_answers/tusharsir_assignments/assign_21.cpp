// 21. Write a menu driven program, which allows the user to select either a circle or rectangle.

// a. Write a single function areaCircum() that calculates the area and circumference of a circle.
// The values of area and circumference should be printed in main()

// b. Write a single function areaPeri() that calculates the area and perimeter of a rectangle. The
// values of area and perimeter should be printed in main()


#include <iostream>
using namespace std;

void areaCircum(float radius, float *area, float *circumference){

    *area = 3.14 * radius * radius;
    *circumference  = 2 * 3.14 * radius;

}


// incomplete function
void areaPeri(){

}

int main(){

    int choice;


   
    while(true){


        cout<<"Enter 1 for circle"<<endl;
        cout<<"Enter 2 for rectangle"<<endl;
        cout<<"Enter 3 for exit"<<endl;


        cin>>choice;

        switch(choice){

            case 1: 
                float area;
                float circumeference;
                float radius;

                cout<<"Enter radius of circle "<<endl;
                cin>>radius;
                areaCircum(radius, &area, &circumeference);
                cout<<"area is "<<area<<endl;
                cout<<"circumference is "<<circumeference<<endl;

                break;

            case 2:

            

                break;

            case 3:
                exit(0);
            
            default:
                cout<<"invalid choice"<<endl;
        }
    }

}