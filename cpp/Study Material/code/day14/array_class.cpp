#include <iostream>

//template<class T1, class T2>
template<class T>
class Array {
    T* pData;
    const int size;

    void copyArray(T *dest, T *src, int size) {
        for (int i = 0; i < size; ++i) {
            dest[i] = src[i];
        }
    }
public:
    Array(int n) : size(n) {
        std::cout << "Allocate memory for array of size " << size << "\n";
        pData = new T[size];
    }
    ~Array() {
        std::cout << "Free array memory of size " << size << "\n";
        delete[] pData;
    }
    T& operator[](int i) {
        static T temp;

        if ((i < 0) || (i >= size)) {
            return temp;
        }

        return pData[i];
    }
    Array(Array& obj) : size(obj.size) {
        std::cout << "Array copy constructor of size " << size << "\n";
        pData = new T [size];
        copyArray(pData, obj.pData, size);
    }
};

int main() {
    Array<int> arr1(5);
    Array<int> arr2(arr1);
    Array<float> arr3(5);

    arr1[0] = 1;
    arr2[0] = 2;

    std::cout << "1st element of arr1 = " << arr1[0] << "\n";
    std::cout << "1st element of arr2 = " << arr2[0] << "\n";

    return 0;
}
