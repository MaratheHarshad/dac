// program to create array using variable length argument

#include<iostream>
using namespace std;


int main(){

    int n; 

    cout<<"Enter number to create n size array : ";
    cin>>n;

    cout<<n<<endl;

    int arr[n];

    

    for(int i = 0; i < sizeof(arr) / sizeof(int); i++){
        cout<<i+1<<endl;
    }




}