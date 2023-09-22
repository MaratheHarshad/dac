
#include<iostream>
using namespace std;

int main(){

    int arr[] = {10, 9, 8, 7};

    cout << arr[0];
    cout << *arr + 1;

}

/*

arr = [ 10 , 9 , 8 , 7]
        100 104 108 112

        *(arr + 1) = 104

        scaling factor is 4
*/