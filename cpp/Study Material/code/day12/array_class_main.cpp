#include <iostream>

#include "array_class.h"

int main() {
    Array arr1(5);
    Array arr2(arr1);

    arr1[0] = 1;
    arr2[0] = 2;

    std::cout << "1st element of arr1 = " << arr1[0] << "\n";
    std::cout << "1st element of arr2 = " << arr2[0] << "\n";

    return 0;
}
