// 1. Finish the implementation of BigInt class by overloading remaining relational operators to compare two BigInt objects.
//    Also write a small program to demonstrate the use of BigInt class and overloaded relational operators.






#include <iostream>
using namespace std;

class BigInt {


	int num;
    public:

	BigInt() : num(0) {
	}
	BigInt(int n) : num(n) {
	}

	void Read() {
		cin >> num;
	}
	void Write() {
		cout << num;
	}

	bool operator==(BigInt obj2) {
		if (num == obj2.num) {
			return true;
		}
		return false;
	}

	bool operator != (BigInt obj2) {
		if (num != obj2.num) {
			return true;
		}
		return false;
	}

    bool operator > (BigInt obj2){

        if(num > obj2.num){
            return true;
        }

        return false;
    }

	bool operator < (BigInt obj2){

        if(num < obj2.num){
            return true;
        }

        return false;
    }
};

int main() {

	BigInt i(10);
	BigInt j(20);

	if (i == j) {
		cout << "They are equal\n";
	}
	else {
		cout << "They are NOT equal\n";
	}


    if (i > j){
        cout<<"object 1 is greater than 2\n";
    }else{
        cout<<"object 2 is greater than 1\n";
    }


	if (i != j){
		cout<<"object 1 is not equal to object 2\n";
	}else{
		cout<<"object 1 is equal to  object 2\n";
	}

	return 0;
}