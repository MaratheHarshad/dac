#include <iostream>
#include <stdlib.h>

class X {
public:
    X() {
        std::cout << "X default constructor\n";
    }
    ~X() {
    std::cout << "X destructor\n";
    }
};

void UseMalloc() {
    X *pObj = (X*) malloc(sizeof(X));

    free(pObj);
}

void UseNew() {
    X *pObj = new X();

    delete pObj;
}

void UseNewForObjectArrayWithWrongDelete() {
    X *pObj = new X[3];

    delete pObj;
}

void UseNewForObjectArrayWithCorrectDelete() {
    X *pObj = new X[3];

    delete[] pObj;
}

int main() {
    std::cout << "Calling UseMalloc\n";
    UseMalloc();

    std::cout << "Calling UseNew\n";
    UseNew();

    //std::cout << "Calling UseNewForObjectArrayWithWrongDelete\n";
    //UseNewForObjectArrayWithWrongDelete();

    std::cout << "Calling UseNewForObjectArrayWithCorrectDelete\n";
    UseNewForObjectArrayWithCorrectDelete();

    return 0;
}
