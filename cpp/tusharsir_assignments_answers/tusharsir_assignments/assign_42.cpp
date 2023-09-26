// 42. Write a class Employee for an application which will have data members for employee id,
// employee name and salary. Provide the following functionalities in Employee class.
// 1. Initialing objects using default and parameterized constructors.
// 2. Accepting and displaying the information of employee from console

// class Employee
// {

// int emp_id;
// char emp_name[20];
// double salary;
// public:

// Employee();
// Employee(int, char*, double);
// void Accept();
// void Display();

// };

// In main function declare an array of Employee objects. Write a menu driven program to -
// a. Insert record into an array.
// b. Update information of specific employee on the basis of emp_id accepted from user
// c. Display all records.


#include <iostream>
#include <cstring>
using namespace std;

class Employee
{

    int emp_id;
    char emp_name[20];
    double salary;

    public:

        Employee(){

            emp_id = 0;
            strcpy(emp_name, "");
            salary = 0;
        }

        Employee(int id, char* name, double salary){
            emp_id = id;
            strcpy(emp_name, name);
            salary = salary;
        }

        void Accept(){

            cout<<"Enter name ";
            // getline(cin, emp_name);
            cin.getline(emp_name, 20);
            cin.getline(emp_name, 20);

            cout<<"Enter id ";
            cin>>emp_id;

            cout<<"Enter Salary ";
            cin>>salary;
        }

        void Display(){

            cout<<" id "<<emp_id<<endl;

            cout<<" name "<<emp_name<<endl;

            cout<<" Salary "<<salary<<endl;

        }

        int getEmpId(){
            return emp_id;
        }

};



int main(){

    Employee objects[10];
    int index = -1;

    while(true){


        int choice;

        cout<<"1 for insert data "<<endl;
        cout<<"2 for display "<<endl;
        cout<<"3 to update information "<<endl;
        cout<<"4 for exit "<<endl;


        cin>>choice;

        switch (choice)
        {
            case 1:

                index++;
                // objects[index] = new Employee();
                objects[index].Accept();
                
                break;

            case 2:

                if(index < 0){
                    cout<<"Empty : ";
                }else{
                    for(int i = 0; i <= index; i++){
                        objects[i].Display();
                    }
                }
                break;

            case 3:

                int id;
                cout<<"Enter the id of employee to update information ";
                cin>>id;


                // int emp_index = -1;

                // above line gives this error

                // n_42 && "/home/dac/dac_hm/cpp/tusharsir_assignments/"assign_42
                // assign_42.cpp: In function ‘int main()’:
                // assign_42.cpp:151:18: error: jump to case label
                //   151 |             case 4:
                //       |                  ^
                // assign_42.cpp:130:21: note:   crosses initialization of ‘int emp_index’
                //   130 |                 int emp_index = -1;

                int emp_index;
                emp_index = -1;

                for(int i = 0; i <= index; i++){

                    if(objects[i].getEmpId() == id){

                        emp_index = i;
                        break;
                    }
                }
                
                if(emp_index == -1){
                    cout<<"Employee does not exist "<<endl;
                }else{
                    cout<<"update the employee information "<<endl;
                    objects[emp_index].Accept();
                }


                break;

            case 4:
                exit(0);

            
        }
        



    }

}
                                                                                                                                                                                                                                                                                                                                                                                                    