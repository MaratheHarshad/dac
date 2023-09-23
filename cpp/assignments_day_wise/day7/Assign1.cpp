//Given the Array of integers; 
//Find the largest element and return from function

#include <iostream>
using namespace std;

void read(int Ar[],int i)
{
    cout<<"Enter elements of array"<<endl;
    for(int iCnt=0;iCnt<i;iCnt++)
    {
        cin>>Ar[iCnt];
    }
}
void echo_p(int Arr[],int j)
{
    cout<<"Elements of array are "<<endl;

    for(int iCnt=0;iCnt<j;iCnt++)
    {
        cout<<Arr[iCnt]<<"\t";
    }   
}
int print_Max(int Arrr[],int k)
{ 
    int iMax=0;
    for(int i=0;i<k;i++)
    {
        if(Arrr[i]>iMax)
        {
            iMax=Arrr[i];
        }
    }
    return iMax;
}
int main()
{   
    int i;
    int iRet;

    cout<<"Enter the number of elements you want to store in array"<<endl;
    cin>>i;

    int Arr[i];
    
    read(Arr,i);
    echo_p(Arr,i);
    
    iRet=print_Max(Arr,i);
    cout<<"Largest element in array is : "<<iRet<<endl;

    return 0;
}    

