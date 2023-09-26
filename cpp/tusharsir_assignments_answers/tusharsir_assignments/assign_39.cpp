// 39-> Implement class Complex with real (int) and imaginary (int) parts as data members of class->
// Implement below functions inside this class->
// default constructor, parameterized constructor, getter functions for real and imaginary parts,
// setter functions for real and imaginary parts, display function->


#include <iostream>
using namespace std;


class Complex{

    private:
        int real;
        int imaginary;

    public:
        Complex(){

        }

        Complex(int real, int imaginary){
            this->real = real;
            this->imaginary = imaginary;
        }


        int getReal();
        int getImaginary();
        void setReal(int real);
        void setImaginary(int imaginary);
        void display();
};

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

    Complex obj2(10,20);
    obj2.display();
}