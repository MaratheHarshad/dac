#include <iostream>

void swap(int& a, int &b) {
    int t;

    t = a; a = b; b = t;
}
void swap(float& a, float &b) {
    float t;

    t = a; a = b; b = t;
}

int main() {
    int x = 10, y = 20;
    std::cout << "Before swap x = " << x << ", y = " << y << "\n";
    swap(x, y);
    std::cout << "After swap  x = " << x << ", y = " << y << "\n";

    float f1 = 1.5, f2 = 2.5;
    std::cout << "Before swap f1 = " << f1 << ", f2 = " << f2 << "\n";
    swap(f1, f2);
    std::cout << "After swap  f1 = " << f1 << ", f2 = " << f2 << "\n";

    return 0;
}
