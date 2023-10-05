class Base {
public:
    int i;
    Base(int v);
    void f1();
};

class Derived1 : virtual public Base {
public:
    Derived1();
};

class Derived2 : virtual public Base {
public:
    Derived2();
};

class Derived : public Derived1, public Derived2 {
public:
    Derived();
};


// virtual inheritance is used to resolve the issue of dimond shape problem