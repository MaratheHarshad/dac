// 31. Write a program to sort five user entered strings into alphabetical order. Use dynamic memory
// allocation to store strings.

// sort n user entered strings 
// we have to allocate the memory dynamically for n strings


// Algorithm (allocate memory at compile time)

// steps

// start
// create array of characters , suppose size initially is 20
// iterate n times
    // enter the string and insert it into the current position

// sort the string (may be use brute force approach)



// #include <iostream>
// #include <string.h>

// using namespace std;

// int main(){
    
//     char strings[n][20];
//     char temp[20];

//     cout<<"enter strings  "<<endl;

//     for(int i = 0; i < n; i++){
//         cin>>strings[i];
//     }

//     cout<<" strings are  "<<endl;

//     for(int i = 0; i < n; i++){
//         cout<<strings[i]<<endl;
//     }

//     for(int i = 0; i < n; i++){
//         for(int j = i + 1; j < n; j++){

//             int cmp = strcmp(strings[i], strings[j]);

//             // cout<<"String[i] "<<strings[i]<<endl;
//             // cout<<"String[j] "<<strings[j]<<endl;
//             // cout<<cmp<<endl;

//             if(cmp > 0){
//                 // swap the values
//                 strcpy(temp, strings[i]);
//                 strcpy(strings[i], strings[j]);
//                 strcpy(strings[j], temp);
//             }
//         }

//     }

//     cout<<"Sorted strings are : "<<endl;

//     for(int i = 0; i < n; i++){
//         cout<<strings[i]<<endl;
//     }
// }


// ["abc" "def" "bcd" "cde" "bec"]

// // after 1st iteration
// ["abc" "def" "bcd" "cde" "bec"]

// // after 2nd iteration

// ["abc" "bcd" "def" "cde" "bec"]

// // after 3rd iteration

// ["abc" "bcd" "bec" "def" "cde"]







// **************************************************************************************************88

// Using dynamic memory allocation for user entered strings

#include <iostream>
#include <cstring>

using namespace std;

int main(){
    
    int n = 2;
    char *strings[n];
    char temp[20];

    cout<<"enter strings  "<<endl;

    for(int i = 0; i < n; i++){
        cin>>temp;
        strings[i] = (char *)(malloc(strlen(temp)  * sizeof(char) + 1));
        strcpy(strings[i], temp);
    }

    cout<<" strings are  "<<endl;

    for(int i = 0; i < n; i++){
        cout<<strings[i]<<endl;
    }

    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){

            int cmp = strcmp(strings[i], strings[j]);

            // cout<<"String[i] "<<strings[i]<<endl;
            // cout<<"String[j] "<<strings[j]<<endl;
            // cout<<cmp<<endl;

            if(cmp > 0){
                // swap the values
                strcpy(temp, strings[i]);
                strcpy(strings[i], strings[j]);
                strcpy(strings[j], temp);
            }
        }

    }

    cout<<"Sorted strings are : "<<endl;

    for(int i = 0; i < n; i++){
        cout<<strings[i]<<endl;
    }


    // deallocate the memory

    for(int i = 0; i < n; i++){ 
        free(strings[i]);
    }

}