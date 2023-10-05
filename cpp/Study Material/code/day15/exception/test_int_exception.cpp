#include <iostream>

#include "function.h"

void onlyPositiveAllowed(int num) /*noexcept*/ {
    if (num < 0) {
        throw 1;
    }
    std::cout << "Got positive number - " << num << "\n";
}

void testF3() {
    try {
        onlyPositiveAllowed(100);
        onlyPositiveAllowed(-10);
        std::cout << "Done\n";
    } catch (int e) {
        std::cout << "\nCaught exception - " << e << "\n";
    }
    std::cout << "Function ending\n";
}
