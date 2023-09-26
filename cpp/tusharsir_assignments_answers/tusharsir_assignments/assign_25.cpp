// 25. Write a program to delete an element from a user entered array. Accept position of element to
// be deleted from user.



// [0,0,0,0,0]

// delete(pos)

// pos >= size : print not possible
// pos < 0 : print not possible


// [3,4,5,6,7]

// move all the elements after position to its left by 1 position
// decrease the numberOfElements by 1

// move elements after position

// [3,4,5,6,0]

// ps = 2
// nel = 4



// for(int i = pos; i < size && i < numberOfElements - 1; i++){

//     arr[i] = arr[i+1];
// }


#include <iostream>
using namespace std;

void remove(int arr[], int &size, int position){

    if(position >= size || position < 0){
        cout<<"Not possible"<<endl;
    }else{


        for(int i = position; i < size - 1 ; i++){
            arr[i] = arr[i+1];
        }

        size--;
    }

}

void display(int arr[] , int size){

    for(int i = 0; i < size; i++){
        cout<<arr[i]<<" ";
    }

    cout<<endl;
}

int main(){

    int numberOfElementssize;
    int size;
    int position;
    cout<<"Enter the size of array : ";
    cin>>size;

    int numberOfElements = size;

    int arr[size];

    cout<<"Enter the elements of array : "<<endl;

    for(int i = 0; i < size; i++){
        cin>>arr[i];
    }

    

    cout<<"Enter the position of element you want to delete : "<<endl;
    cin>>position;

    display(arr, numberOfElements);
    remove(arr, numberOfElements, position);
    display(arr, numberOfElements);


}