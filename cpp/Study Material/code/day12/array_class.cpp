#include <iostream>

#include "array_class.h"

    void Array::copyArray(int *dest, int *src, int size) {
        for (int i = 0; i < size; ++i) {
            dest[i] = src[i];
        }
    }
    Array::Array(int n) : size(n) {
        std::cout << "Allocate memory for array of size " << size << "\n";
        pData = new int[size];
    }
    Array::~Array() {
        std::cout << "Free array memory of size " << size << "\n";
        delete[] pData;
    }
    int& Array::operator[](int i) {
        static int temp;

        if ((i < 0) || (i >= size)) {
            return temp;
        }

        return pData[i];
    }
    Array::Array(Array& obj) : size(obj.size) {
        std::cout << "Array copy constructor of size " << size << "\n";
        pData = new int[size];
        copyArray(pData, obj.pData, size);
    }

