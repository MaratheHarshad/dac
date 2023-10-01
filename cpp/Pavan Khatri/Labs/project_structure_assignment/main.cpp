#include <iostream>

#ifndef("Rectangle.h")
    #define include "Rectangle.h"
#endif


using namespace std;

int main(){

    Rectangle obj(10.7, 20);

    cout<<"area  " << obj.getArea() << endl;
    cout<<"perimeter  " << obj.getPerimeter() << endl;
}