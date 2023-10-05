#include <iostream>

#include "function.h"

int main() {
    try {
        testF4();
    }
    catch(...) {
        std::cout << "In main caught some exception\n";
    }

    return 0;
}