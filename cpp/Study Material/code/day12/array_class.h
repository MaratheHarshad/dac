class Array {
    int* pData;
    const int size;

    void copyArray(int *dest, int *src, int size); 
public:
    Array(int n);
    ~Array();
    int& operator[](int i);
    Array(Array& obj);
};

