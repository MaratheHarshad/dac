#include <iostream>

int main() {
    int a = 2000;
    char *pc = (char *) &a;

    std::cout << (int)(*pc) << "\n";

    return 0;
}
