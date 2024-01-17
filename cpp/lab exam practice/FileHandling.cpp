#include<iostream>
#include<fstream>
#include<string.h>
using namespace std;

int main(){


    string line;

      // Creation of ifstream class object to read the file
    ifstream fin;
 
    // by default open mode = ios::in mode
    fin.open("sample.txt");
 
    // Execute a loop until EOF (End of File)
    while (getline(fin, line)) {
       
       
       if(line.size() == 0){

        cout<<"****"<<endl;
       }else{
        cout << line << endl;

       }
        
    }
 
    // Close the file
    fin.close();
}