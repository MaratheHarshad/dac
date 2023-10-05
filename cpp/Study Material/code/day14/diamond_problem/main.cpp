#include <iostream>

#include "classes.h"

int main() {
    std::cout << "\nCreate Derived1 object\n";
    Derived1 obj1;
    obj1.i = 10;
    std::cout << "i = " << obj1.i << "\n";

    std::cout << "\nCreate Derived object\n";
    Derived objD;
    objD.Derived1::i = 100;
    std::cout << "i = " << objD.Derived1::i << "\n";
    std::cout << "i = " << objD.Derived2::i << "\n";


    std::cout << "Sizeof Derived = " << sizeof(Derived) << "\n";
    
    return 0;
}