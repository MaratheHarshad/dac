// 35. Write a program to accept marks of a student in ‘n’ subjects. Allocate the space for the array of
// marks dynamically. Display average of marks. Use cin, cout, new, delete.



#include <iostream>
using namespace std;

int main(){

    int n;

    cout<<"Enter the number of subjects ";
    cin>>n;

    // if n = 5, means we're allocation 20 bytes
    // subjects[i] internally converted into *(subjects + i);
    // and as a integer pointer it is always moves bytes ahead
    // i.e we don't need to say (int *subjects[5])
    
    int *subjects = new int[n];


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

    // release the memory pointed by the pointer variable
    delete [] subjects;
    

}