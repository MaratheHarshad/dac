#include<iostream>
using namespace std;

void Accept(int [][3]);   //subscript notation
void Display(int (*)[3]); //pointer notation
int main() {
	int i, j;
	int arr[3][3];
	Accept(arr);
	Display(arr);
	return 0;	
}
void Accept(int arr[][3]) {
	int i,j;
	cout<<"Enter array elements"<<endl;
	for(i=0; i<3; i++) {
		for(j=0; j<3; j++){
			cin>>*(*(arr+i)+j);  //arr[i][j]
		}
	}
}
void Display(int (*arr)[3]){
	int i,j;
	cout<<"Array elements-"<<endl;
	for(i=0; i<3; i++){
		for(j=0; j<3; j++){
			cout<<*(*(arr+i)+j)<<"  ";
		}
		cout<<endl;
	}
}
