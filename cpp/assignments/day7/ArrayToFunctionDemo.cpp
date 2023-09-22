#include <iostream>
using namespace std;

// by default in this function arr is pointer to integer array
// because initially we does know the size of array

// void arrayToFunctionByPointer(int arr[]){

//     cout<<"Inside arrayToFunctionByPointer function "<<endl;

//     // arr is a pointer here
//     // and in this compiler the size of int* is 8 bytes i.e it return 8
//     cout<<"bytes of array "<<sizeof(arr)<<endl;

//     // sizeof(int) is 4 byte
//     // so it prints 2 as  output which is logically wrong
//     cout<<"size of array "<<sizeof(arr)/sizeof(int)<<endl;

// }





// incomplete demonstration
void arrayToFunctionByReference(){


    

}

int main(){

    int arr [] = {5,6,7,8,9,10,11,34,34,34,53,100,34,56,74,34};

    cout<<"Inside main function "<<endl;

    cout<<"bytes of array "<<sizeof(arr)<<endl;

    cout<<"size of array "<<sizeof(arr)/sizeof(int)<<endl;

    // arrayToFunctionByPointer(arr);

}