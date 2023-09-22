//Given the Array of integers; 
//Find the smalest element and return from function

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
void echo_p(int Arr[],int j)
{
    cout<<"Elements of array are "<<endl;

    for(int iCnt=0;iCnt<j;iCnt++)
    {
        cout<<Arr[iCnt]<<"\t";
    }   

    cout<<endl;
}

int print_Min(int Arrr[],int k)
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
int main()
{   
    int i;
    int iRet;

    cout<<"Enter the number of elements you want to store in array"<<endl;
    cin>>i;

    int Arr[i];
    
    read(Arr,i);
    echo_p(Arr,i);
    
    iRet=print_Min(Arr,i);
    cout<<"Smallest element in array is : "<<iRet<<endl;

    return 0;
}    

