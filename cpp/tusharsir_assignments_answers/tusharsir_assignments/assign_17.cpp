// 17. Write a program to generate following output.

// 1 2 3 4 5 4 3 2 1
// 1 2 3 4   4 3 2 1
// 1 2 3       3 2 1
// 1 2           2 1
// 1               1



#include <iostream>
using namespace std;

int main(){
    
    int n, spaces = 2;
    cout<<"enter n "<<endl;

    cin>>n;


    for(int i = 1; i <= n; i++){
        cout<<i<<" ";
    }

    for(int j = n -1 ; j >= 1; j--){
        cout<<j<<" ";
    }

    cout<<endl;



    for(int i = 1; i <= n - 1; i++){

        int j = 1;

        for(j = 1; j <= n - i ; j++){
                cout<<j<<" ";
        }

        for(int j = 1; j <= spaces; j++){
            cout<<" ";
        }

        for(j = n - i; j >= 1; j--){
            cout<<j<<" ";
        }

        cout<<endl;

        spaces += 4;
    }

    cout<<endl;

}