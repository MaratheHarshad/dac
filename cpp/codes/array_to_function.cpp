#include <iostream>

void f1(int arr[100]) {
    std::cout << "In f1\n";
    std::cout << "Elements in array - " << sizeof(arr) / sizeof(int) << "\n";
    std::cout << "Elements in array - " << sizeof(arr) / sizeof(arr[0]) << "\n";
}

void f2(int (&arr)[5]) {
    std::cout << "In f2\n";
    std::cout << "Elements in array - " << sizeof(arr) / sizeof(int) << "\n";
    std::cout << "Elements in array - " << sizeof(arr) / sizeof(arr[0]) << "\n";
}

int main() {
    int a = 10;
    int arr[] = {1, 2, 3, 4, 5};
    int *p = &a;

    std::cout << "sizeof int - " << sizeof(a) << "\n";
    std::cout << "sizeof pointer - " << sizeof(p) << "\n";

    std::cout << "Elements in array - " << sizeof(arr) / sizeof(int) << "\n";
    std::cout << "Elements in array - " << sizeof(arr) / sizeof(arr[0]) << "\n";

    f1(arr);
    f2(arr);

    return 0;
}
