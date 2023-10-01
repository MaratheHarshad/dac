class Base {
	int b1;
protected:
	int b2;
public:
	void f1() {
		b1 = 10;
		b2 = 20;
	}
};
class Derived : protected Base {
	int d1;
protected:
	int d2;
public:
	void f2() {
		//b1 = 10; // private of base not accessible in derived
		b2 = 20;
		d1 = 100;
		d2 = 200;
		f1();
	}
};
int main() {
	Base objB;
	//objB.b1 = 10; // private member
	//objB.b2 = 20; // protected member
	objB.f1();

	Derived objD;
	//objD.b1 = 10; // private member
	//objD.b2 = 20; // protected member
	//objD.d1 = 100; // private member
	//objD.d2 = 200; // protected member
	objD.f1();
	objD.f2();
	return 0;
}