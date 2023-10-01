#include <iostream>

class Base {
    int b;
public:
    Base(int x) : b(x) {
        std::cout << "Base default constructor\n";
    }
    ~Base() {
        std::cout << "Base destructor\n";
    }
    void setB(int b) {
        this->b = b;
    }
    int getB() {
        return b;
    }
};

class Derived : public Base {
    int d;
public:
    Derived(int x) : d(x), Base(x / 2) {
        std::cout << "Derived default constructor\n";
    }
    ~Derived() {
        std::cout << "Derived destructor\n";
    }
    void setD(int d) {
        this->d = d;
    }
    int getD() {
        return d;
    }
};

int main() {
    Derived objD(10);

    objD.setB(10);
    objD.setD(5);

    std::cout << "Size of Base = " << sizeof(Base) << "\n";
    std::cout << "Size of Derived = " << sizeof(Derived) << "\n";
    std::cout << "getB for Derived = " << objD.getB() << "\n";

    return 0;
}
