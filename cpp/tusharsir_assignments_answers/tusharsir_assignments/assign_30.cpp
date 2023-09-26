// 30. Write a program that calculates the average marks of all the subjects. The number of subjects
// ‘n’ is accepted from the user. Allocate memory dynamically for ‘n’ integers. Free the memory
// when not in use.


#include <iostream>
// #include <stdlib.h>
using namespace std;

int main(){

    int n;

    cout<<"Enter the number of subjects ";
    cin>>n;

    // if n = 5, means we're allocation 20 bytes
    // subjects[i] internally converted into *(subjects + i);
    // and as a integer pointer it is always moves bytes ahead
    // i.e we don't need to say (int *subjects[5])
    int *subjects = (int *)(malloc(sizeof(int) * n));



    int sumOfMarks = 0;

    cout<<"Enter the marks of "<<n<<" subjects "<<endl;
    
    for(int i = 0; i < n; i++){
        cin>>subjects[i];
    }

    for(int i = 0; i < n; i++){
        sumOfMarks += subjects[i];
    }

    cout<<"Total marks obtain : "<<sumOfMarks<<endl;
    cout<<"Average is "<<(sumOfMarks / n)<<endl;

    // free is a function which deallocates the memory which is dynamically allocatd 
    // subjects is a pointer to an integer (not an array) i.e no need to deallocate memory for each index
    free(subjects);

    

}

// valgrind -> is a tool to check memory leakage in program
// steps
// g++ assign_30.cpp
// valgrind ./a.out