//Find the second smallest elment of array

#include <iostream>
#include <climits>
using namespace std;

void read(int Ar[],int i)
{
    cout<<"Enter elements of array"<<endl;
    for(int iCnt=0;iCnt<i;iCnt++)
    {
        cin>>Ar[iCnt];
    }
}
void print(int Arr[],int j)
{
    cout<<"Elements of array are "<<endl;

    for(int iCnt=0;iCnt<j;iCnt++)
    {
        cout<<Arr[iCnt]<<"\t";
    }   

    cout<<endl;
}

int findMin(int Arrr[],int k)
{ 
    int iMin = INT_MAX;

    for(int i=0;i<k;i++)
    {
        if(Arrr[i] < iMin)
        {
            iMin=Arrr[i];
        }
    }

    return iMin;
}

int findSecondMin(int arr[],int j,int min)
{
    int secMin = INT_MAX ;
    
    for(int i=0;i<j;i++)
    {
        if( arr[i] > min && arr[i] < secMin)
        {
            secMin=arr[i];
        }
    }
    return secMin;
}

int main()
{   
    int i;
    int min;
    int secondMin;

    cout<<"Enter the number of elements you want to store in array"<<endl;
    cin>>i;

    int Arr[i];
    
    read(Arr,i);
    print(Arr,i);
    
    min=findMin(Arr,i);
    cout<<"Smallest element in array is : "<<min<<endl;
    
    secondMin=findSecondMin(Arr,i,min);
    cout<<"Second smallest element in array is : "<<secondMin<<endl;

    return 0;
}    

