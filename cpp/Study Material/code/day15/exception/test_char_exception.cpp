#include <iostream>

#include "function.h"

int sumDigits(int num) {
    if (num < 0) {
        throw "Negative number not allowed";
    }
    return num;
}

void testF1() {
    std::cout << "sumDigits(5) = " << sumDigits(5) << "\n";
    std::cout << "sumDigits(-5) = " << sumDigits(-5) << "\n";
    std::cout << "Done\n";
}

void testF2() {
    try {
        std::cout << "sumDigits(5) = " << sumDigits(5) << "\n";
        std::cout << "sumDigits(-5) = " << sumDigits(-5) << "\n";
        std::cout << "Done\n";
    } catch (const char * e) {
        std::cout << "\nCaught exception - " << e << "\n";
    }
}
