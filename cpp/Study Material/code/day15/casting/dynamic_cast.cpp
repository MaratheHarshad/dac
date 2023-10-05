#include <iostream>

class Base {
public:
    virtual void f1() const {
        std::cout << "Base::f1\n";
    }
    void f2() const {
        std::cout << "Base::f2\n";
    }
};
class Derived : public Base {
public:
    void f1() const {
        std::cout << "Derived::f1\n";
    }
    void f2() const {
        std::cout << "Derived::f2\n";
    }
};

void testF1(const Base& obj) {
    std::cout << "Received type is - " << typeid(obj).name() << "\n";
    try {
        const Derived& objD = dynamic_cast<const Derived&>(obj);
        objD.f2();
    } catch (std::bad_cast& e) {
        std::cout << "Upcast failed - " << e.what() << "\n";
    }
}

void testF2(const Base* pObj) {
    std::cout << "Received type is - " << typeid(*pObj).name() << "\n";

    const Derived* pObjD = dynamic_cast<const Derived*>(pObj);
    if (pObjD == nullptr) {
        std::cout << "Upcast failed\n";
        return;
    }
    pObjD->f2();
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