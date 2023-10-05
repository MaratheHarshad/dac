#include <iostream>

class Base {
public:
    int i;
    void f1() const {
        std::cout << "Base::f1\n";
    }
    void f2() const {
        std::cout << "Base::f2\n";
    }
};
class Derived : public Base {
public:
    int j;
    Derived() : j(100) {}
    void f1() const {
        std::cout << "Derived::f1\n";
    }
    void f2() const {
        std::cout << "Derived::f2\n";
    }
};

void testF1(Base& obj) {
    std::cout << "Received type is - " << typeid(obj).name() << "\n";

    try {
        Derived& objD = static_cast<Derived&>(obj);
        objD.f2();
        std::cout << "j = " << objD.j << "\n";
    } catch (std::bad_cast& e) {
        std::cout << "Upcast failed - " << e.what() << "\n";
    }
}

void testF2(Base* pObj) {
    std::cout << "Received type is - " << typeid(*pObj).name() << "\n";

    Derived* pObjD = static_cast<Derived*>(pObj);
    if (pObjD == nullptr) {
        std::cout << "Upcast failed\n";
        return;
    }
    pObjD->f2();
    std::cout << "j = " << pObjD->j << "\n";
}

int main() {
    Base objB;
    Derived objD;

    std::cout << "\nTrying with Base object\n";
    testF1(objB);

    std::cout << "\nTrying with Derived object\n";
    testF1(objD);

    std::cout << "\nTrying with Base object\n";
    testF2(&objB);

    std::cout << "\nTrying with Derived object\n";
    testF2(&objD);

    return 0;
}