// 33. Modify above assignment - 32 to hold record of five books. Display the records of all the books
// using a function.


#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

typedef struct
{
    int bookId;
    char title[20];
    int price;

}BOOK;


void accept(BOOK *obj){


    // it works if title is taken first
    // otherwise there is some istream issue (in c language , flush())is used

    // cout<<"Enter title : ";
    // // cin>>obj->title;
    // // gets(obj->title);
    
    // cin.getline(obj->title, 20);
    // cin.getline(obj->title, 20);

    // other wise have to take 2 times cin


    

    cout<<"Enter book id : ";
    cin>>obj->bookId;

    cout<<"Enter title : ";
    // cin>>obj->title;
    // gets(obj->title);
    
    cin.getline(obj->title, 20);
    cin.getline(obj->title, 20);


    cout<<"Enter price : ";
    cin>>obj->price;
}

void display( BOOK *obj){

    cout<<"Book Id : "<<obj->bookId<<endl;
    cout<<"Title : "<<obj->title<<endl;
    cout<<"price : "<<obj->price<<endl;

}


int main(){

    BOOK obj[5];

    for(int i = 0; i < 5; i++){
        cout<<"Enter Records of Book "<<i+1<<endl;
        accept(&obj[i]);
    }

    for(int i = 0; i < 5; i++){
        cout<<"Records of "<<i+1<<endl;
        display(&obj[i]);
    }



}