#include <iostream>

#include "classes.h"

Base::Base(int v) : i(v) {
    std::cout << "Base::Base\n";
}

Derived1::Derived1() : Base(1) {
    std::cout << "Derived1::Derived1\n";
}

Derived2::Derived2() : Base(2) {
    std::cout << "Derived2::Derived2\n";
}

Derived::Derived() : Base(3) {
    std::cout << "Derived::Derived\n";
}
