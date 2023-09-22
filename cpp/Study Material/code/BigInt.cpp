#include <iostream>

class BigInt {
	int num;
public:
	BigInt() : num(0) {
	}
	BigInt(int n) : num(n) {
	}

	void Read() {
		std::cin >> num;
	}
	void Write() {
		std::cout << num;
	}

	bool operator==(BigInt obj2) {
		if (num == obj2.num) {
			return true;
		}
		return false;
	}
};

int main() {
	BigInt i(10);
	BigInt j(20);

	if (i == j) {
		std::cout << "They are equal\n";
	}
	else {
		std::cout << "They are NOT equal\n";
	}

	return 0;
}