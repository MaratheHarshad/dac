#include <iostream>

int main() {
    /* const */ int i = 10;
    const int &cr = i;
    //cr = 100;

    int &j = const_cast<int&>(cr);
    j = 20;
    std::cout << "i = " << i << "\n";
    std::cout << "j = " << j << "\n";

    char ch;
    int *p = reinterpret_cast<int*>(&ch); // (int*) &ch;

    return 0;
}