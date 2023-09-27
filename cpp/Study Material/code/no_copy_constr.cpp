#include <iostream>

class X {
    int i;
public:
    X() {
        std::cout << "Constructor\n";
    }
    ~X() {
        std::cout << "Destructor\n";
    }

private:
    X(X&) {
        std::cout << "Copy constructor\n";
    }
    X& operator=(X&) {
        std::cout << "Assignment operator\n";
        return *this;
    }
};

int main() {
    X obj1;
    X obj2(obj1);

    X obj3;
    obj3 = obj1;

    return 0;
}
