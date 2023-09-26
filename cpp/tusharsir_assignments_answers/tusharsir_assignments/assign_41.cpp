// Write a class Array which will store integer elements in dynamically allocated space.

// class Array
// {
// int size;
// int *arr;
// }

// Provide below functions in Array class -
// 1. Default constructor - Take 5 as default size. Initialize the array elements to 0
// 2. Parameterized constructor - Takes size as parameter. Initialize the array elements to 0.
// 3. Copy constructor - Performs deep copy of Array object.
// 4. Destructor - Deletes memory which is allocated dynamically.



#include<iostream>
using namespace std;


class Array{

    private:
        
        int size;
        int *arr;

    public:

        Array(){

            size = 5;
            arr = new int[size];

            for(int i = 0; i < size; i++){
                arr[i] = 0;
            }
        }

        Array(int size){

            size = size;
            arr = new int[size];

            for(int i = 0; i < size; i++){
                arr[i] = 0;
            }
        }

        Array(Array &other){

            size = other.size;

            arr = new int[other.size];

            for(int i = 0; i < size; i++){
                arr[i] = other.arr[i];
            }
        }

        ~Array(){
            delete [] arr;
        }




        void accept(){

            cout<<"Enter Elements : "<<endl;

            for(int i = 0; i < size; i++){
                cin>>arr[i];
            }
        }

        void display(){

            cout<<"Array Elements : "<<endl;
            
            for(int i = 0; i < size; i++){
                cout<<arr[i]<<" ";
            }

            cout<<endl;
        }


};



int main(){

    Array obj;
    
    obj.display();
    obj.accept();
    obj.display();

    // for(int i = 0; i < 5; i++){
    //     cout<<obj.arr[i]<<endl;
    // }
    
    Array obj2(obj);
    obj2.display();
}
