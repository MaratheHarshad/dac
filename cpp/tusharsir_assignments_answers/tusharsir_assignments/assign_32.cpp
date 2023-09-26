// 32. Define a structure “Book” having members – bookId, title, price. Use typedef to name this
// structure “BOOK”. Accept the data for a book and display the record.

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

    char str[20];
    BOOK obj;

    accept(&obj);

    // cout<<"Enter book id : ";
    // cin>>obj.bookId;

    // cout<<"Enter title : ";
    // cin>>str;
    // strcpy(obj.title, str);

    // cout<<"Enter price : ";
    // cin>>obj.price;

    // cout<<"Book Id : "<<obj.bookId<<endl;
    // cout<<"Title : "<<obj.title<<endl;
    // cout<<"price : "<<obj.price<<endl;

    display(&obj);


}