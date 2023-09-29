#include <iostream>

class X {
    int i;
    static int objCount;
public:
    X() : i (10) {
        ++objCount;
    }
    ~X() {
        --objCount;
    }
    static int getObjCount() {
        //++i;

        X obj;
        ++obj.i;

        return objCount;
    }
};

int X::objCount = 0;

void f1() {
    X o1;
    X o2[3];

    std::cout << "Object count = " << o1.getObjCount() << "\n";    
}

void f2() {
    std::cout << "Object count = " << X::getObjCount() << "\n";    
}

int main() {
    X o1;
    X o2[5];

    std::cout << "Object count = " << o1.getObjCount() << "\n";    
    f1();
    std::cout << "Object count = " << o1.getObjCount() << "\n";    
    f2();

    return 0;
}
