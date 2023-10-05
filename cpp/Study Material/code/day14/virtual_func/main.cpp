#include <iostream>

#include "animals.h"

void printAnimalName(const Animals& obj) {
    std::cout << "Hello " << obj.getName() << "\n";
}

int main() {
    Lion obj1;
    Rat obj2;

    std::cout << "Sizeof Animal = " << sizeof(Animals) << "\n";
    // std::cout << "Sizeof Lion = " << sizeof(Lion) << "\n";
    // std::cout << "Sizeof Rat = " << sizeof(Rat) << "\n";

    printAnimalName(obj1);
    printAnimalName(obj2);

    //Animals obj3; // Can not create objects of abstract class
    //printAnimalName(obj3);

    return 0;
}