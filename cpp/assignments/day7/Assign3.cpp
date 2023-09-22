//Find the second largest elments of array

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

    cout<<endl;
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
int print_SecLarge(int arr[],int j,int maxxx)
{
    int SecLarg=0;
    
    for(int i=0;i<j;i++)
    {
        if( arr[i] < maxxx && arr[i] > SecLarg)
        {
            SecLarg=arr[i];
        }
    }
    
    return SecLarg;
}
int main()
{   
    int i;
    int iRet;
    int iResult;

    cout<<"Enter the number of elements you want to store in array"<<endl;
    cin>>i;

    int Arr[i];
    
    read(Arr,i);
    echo_p(Arr,i);
    
    iRet=print_Max(Arr,i);
    cout<<"Largest element in array is : "<<iRet<<endl;
    
    iResult=print_SecLarge(Arr,i,iRet);
    cout<<"Second Largest element in array is : "<<iResult<<endl;

    return 0;
}    
