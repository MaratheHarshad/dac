
/*
Given the positive integer N ,print the digits in the number as words
Input 231
output two three one
*/
#include<iostream>
using namespace std;


int reverse_Num(int iNo)
{
    int Ans = 0;
    int iDigit = 0;

    while(iNo > 0){

        iDigit = iNo % 10;
        Ans = Ans * 10 + iDigit;
        iNo = iNo / 10;
    }
    // cout<<"Reverse number is "<<Ans<<"\n";
    
    return Ans;

}

void print_in_words(int iNum)
{
    int iRev = reverse_Num(iNum);
    int iDigit =0;

    while(iRev!=0)
    {
        iDigit= iRev%10;   
        
        switch(iDigit){

            case 0:
                cout<<"zero ";
                break;

            case 1:
                cout<<"one ";
                break;

            
            case 2:
                cout<<"two ";
                break;

            case 3:
                cout<<"three ";
                break;

            case 4:
                cout<<"four ";
                break;

            case 5:
                cout<<"five ";
                break;

            case 6:
                cout<<"six ";
                break;

            case 7:
                cout<<"seven ";
                break;

            case 8:
                cout<<"eight ";
                break;

            case 9:
                cout<<"nine ";
                break;

        }

        iRev = iRev / 10;
    }

    cout<<endl;

}
int main()
{
    int iN=0;

    // input validation
    do{

        cout<<"Enter the positive number\n";
        cin>>iN;

    }while(iN < 1);
    
    print_in_words(iN);

    return 0;
}