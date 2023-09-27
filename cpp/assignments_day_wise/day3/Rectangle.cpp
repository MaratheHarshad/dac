//Draw the rectangle of user defined length and breadth

#include<iostream>
using namespace std;
void Draw_rect(int iL, int iB)
{
    for(int i=0;i<=iL;i++)
    {
        for(int j=0;j<=iB;j++)
        {
            cout<<"*";
        }

        cout<<"\n";
    }
}
int main()
{   
    int iLen,iBredth;
    cout<<"Enter the length of rectangle"<<endl;
    cin>>iLen;

    cout<<"Enter the breadth of rectangle"<<endl;
    cin>>iBredth;

    Draw_rect(iLen,iBredth);
    return 0;
}