
#include "Rectangle.h"

// we'll have to give scope as, Rectangle class
// other it will considerd as global scope member functions


Rectangle::Rectangle():width(0), height(0){

}


Rectangle::Rectangle(double w, double h){
    width  = w;
    height = h;
}



double Rectangle::getArea(){
    return width * height;
}

double Rectangle::getPerimeter(){
    return (2 * width)  + (2 * height);
}
