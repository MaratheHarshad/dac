// 40. Write a program to count number of objects created for above class Complex . Use static data
// member and member function.



#include <iostream>
using namespace std;


class Complex{

    private:
        int real;
        int imaginary;
        static int count;
        static void increaseCount(){
            cout<<"inside increase count"<<endl;
            Complex::count = Complex::count + 1;
        }
        

    public:
        Complex(){
            increaseCount();
        }

        Complex(int real, int imaginary){
            this->real = real;
            this->imaginary = imaginary;
            increaseCount();
        }

        static int getObjectsCount(){
            return count;
        }

        int getReal();
        int getImaginary();
        void setReal(int real);
        void setImaginary(int imaginary);
        void display();
};


// important statement for static variables

// a static variable inside a class should be initialized explicitly by the user using the class name and scope resolution operator outside the class as shown below:

int Complex::count = 0;


int Complex::getReal(){

    return this->real;
}

int Complex::getImaginary(){

    return this->imaginary;
}

void Complex::setReal(int real){
    this->real = real;
}

void Complex::setImaginary(int imaginary){
    this->imaginary = imaginary;
}

void Complex::display(){
    cout<<"Real "<<this->real<<endl;
    cout<<"Imaginary  "<<this->imaginary<<endl;
}


int main(){

    
    Complex obj;
    obj.setReal(5);
    obj.setImaginary(10);
    obj.display();

    cout<<Complex::getObjectsCount()<<endl;

    Complex obj2(10,20);
    obj2.display();

    cout<<Complex::getObjectsCount()<<endl;
}