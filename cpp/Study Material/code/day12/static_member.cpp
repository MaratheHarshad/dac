#include <iostream>

class X {
    int i;
public:
    static int j;
    X() : i(1) {
        std::cout << "X Constructor\n";
    }
};

class Y {
    int i;
public:
    Y() {
        std::cout << "Y Constructor\n";
    }
};

int main() {
    std::cout << "Size of X = " << sizeof(X) << "\n";
    std::cout << "Size of Y = " << sizeof(Y) << "\n";
    std::cout << "Val of j is = " << X::j << "\n";
    return 0;
}

int X::j = 10;
