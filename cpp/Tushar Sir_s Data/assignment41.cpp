#include<iostream>
using namespace std;

class Array
{
	int size;
	int *arr;
public:
	Array();
	Array(int);
	void Accept();
	void Display();
	~Array();
	Array(Array &);
};

Array::Array()
{
	size=5;
	arr=new int[size];
	for(int i=0; i<size; i++)
		arr[i]=0;
}
Array::Array(int s)
{
	size=s;
	arr=new int[size];
	for(int i=0; i<size; i++)
		arr[i]=0;

}

void Array::Accept()
{
	cout<<"Enter array elements:"<<endl;
	for(int i=0; i<size; i++)
		cin>>arr[i];
}
void Array::Display()
{
	cout<<"Array elements:"<<endl;
	for(int i=0; i<size; i++)
		cout<<arr[i]<<"  ";
	cout<<endl;
}
	
Array::~Array()
{
	delete []arr;
}

Array::Array(Array &a)
{
	size=a.size;
	arr=new int[size];
	for(int i=0; i<size; i++)
		arr[i]=a.arr[i];		
}

int main()
{
	Array a1(7);
	a1.Accept();
	
	Array a2(a1);
	a2.Display();
		
	return 0;
}

