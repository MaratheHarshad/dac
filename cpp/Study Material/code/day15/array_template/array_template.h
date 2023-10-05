#include <iostream>

template<class T>
class Array {
    T* pData;
    const int size;
public:
    Array(int s);
    int getSize() const;
    ~Array();
};

template<class T>
Array<T>::Array(int s) : size(s) {
    std::cout << "Template class constructor\n";
    pData = new T[size];
}

template<class T>
Array<T>::~Array() {
    std::cout << "Template class destructor\n";
    delete[] pData;
}

template<class T>
int Array<T>::getSize() const {
    return size;
}


template<>
class Array<char> {
    char* pData;
    const int size;
public:
    Array(int s);
    int getSize() const;
    ~Array();
};

Array<char>::Array(int s) : size(s) {
    std::cout << "Template class specialization constructor\n";
    pData = new char [size];
}

Array<char>::~Array() {
    std::cout << "Template class specialization destructor\n";
    delete[] pData;
}

int Array<char>::getSize() const {
    return size;
}