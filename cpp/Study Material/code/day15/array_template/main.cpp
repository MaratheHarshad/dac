#include <iostream>

#include "array_template.h"

int main() {
    std::cout << "\nCreating int array using template\n";
    Array<int> intArr(10);
    std::cout << "Array size is = " << intArr.getSize() << "\n";

    std::cout << "\nCreating char array using template specialization\n";
    Array<char> charArr(100);
    std::cout << "Array size is = " << charArr.getSize() << "\n";

    std::cout << "\nDone\n";
    return 0;
}