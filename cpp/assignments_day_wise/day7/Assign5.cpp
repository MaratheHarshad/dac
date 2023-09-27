// program to check element is present or not in the array


#include <iostream>
using namespace std;

void read(int Ar[],int i)
{
    cout<<"Enter elements of array"<<endl;


    for(int iCnt=0;iCnt<i;iCnt++)
    {
        cin>>Ar[iCnt];
    }
}


bool search(int arr[] , int size,  int number){


    for(int i = 0; i < size; i++){
        if(arr[i] == number){
            return true;
        }
    }

    return false;

}



int main(){

    int size;
    int number;

    cout<<"Enter the number of elements you want to store in array"<<endl;
    cin>>size;


    int arr[size];
    
    read(arr,size);

    cout<<"Enter the element you want to search in array"<<endl;
    cin>>number;

    // cout<<"Size of array in main "<<sizeof(arr)/sizeof(int)<<endl;


    if(search(arr , size , number)){
        cout<<number<<" is present in array"<<endl;
    }else{
        cout<<number<<" is not present in array"<<endl;
    }
}
