#include<iostream>
using namespace std;

class print_N
{
    public:
    int iNumber;
    
    print_N()
    {   
        cout<<"---------------------------------------";
        cout<<"Inside the parameterless constructor\n";
    }
    
    void get_Number(int iNum)
    {   
        cout<<"Inside get_Number method\n";
        iNumber=iNum;
        cout<<"Number is=="<<iNumber<<"\n";
    }
    void print_Numbers()
    {   
        int iCnt=iVal;
        for(int i=0;i<=iCnt;i++)
        {
            cout<<i<<"\n";
        }
    }

};
int main()
{
    print_N obj1;
    print_N obj2(12);
    obj2.get_Number(10);
    print_N obj3;
    obj3.print_Numbers();

    return 0;
}