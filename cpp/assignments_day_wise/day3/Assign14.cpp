
// 14. Given a positive integer N, print the number in words.
// For example:
// N = 5312
// Result = Five Thousand Three Hundred Twelve

/*

Algorithm

start
get a number +ve
function to print into words -> printIntoWords(num)

    inside printIntoWords(num)

    

    take a reverse of number (reverse(num)) -> reverse -> 213
    take a count of digits in numbr (countDigits(num)) -> count -> 3

    iterate till count != 0

        if (num < 20)
            printString(num) ->  prints appropriate words for a num
            count-=2
        
        else if (num < 99)

            take last 2 digits
            printString(digits)
            count -= 2
        

        else if count is even or reverse < 999 ->     

            take last digit from reverse -> 
            digits = 
            printString(digits)
            printUnit(count)    // print appropriate unit (hundred, thousand) depend on number of digits
            count--;

        else count is odd


            take last 2 digits 



            



*/

// [,,,hundred,thousand,thousand,lakh,lakh,crore,crore]

// five thousand three hundred

#include <iostream>
using namespace std;



char units[][50] = {"","","","hundred","thousand","thousand","lakh","lakh","crore","crore"};



int countDigits(int number){

    int count = 0;

    while(number != 0){
        number /= 10;
        count++;
    }

    return count;
}

void printUnit(int count){
    cout<<units[count]<<" ";
}


void reverse(int *rev, int iNo)
{

    int count = countDigits(iNo);

    // rev = new int[count];
    int index = count - 1;

    int iDigit = 0;

    while(iNo != 0){

        iDigit = iNo % 10;
        rev[index--] = iDigit;
        iNo = iNo / 10;

    }
    
}





void printString(int num){

    switch(num){

        case 1:
            cout<<"One ";
            break;
            
        case 2:
            cout<<"Two ";
            break;
            
        case 3:
            cout<<"Three ";
            break;
            
        case 4:
            cout<<"Four ";
            break;
            
        case 5:
            cout<<"Five ";
            break;
            
        case 6:
            cout<<"Six ";
            break;
            
        case 7:
            cout<<"Seven ";
            break;
            
        case 8:
            cout<<"Eight ";
            break;
            
        case 9:
            cout<<"Nine ";
            break;
            
        case 10:
            cout<<"Ten ";
            break;
            
        case 11:
            cout<<"Eleven ";
            break;
            
        case 12:
            cout<<"Twelve ";
            break;
            
        case 13:
            cout<<"Thirteen ";
            break;
            
        case 14:
            cout<<"Fourteen ";
            break;
            
        case 15:
            cout<<"Fifteen ";
            break;
            
        case 16:
            cout<<"Sixteen ";
            break;

        case 17:
            cout<<"Seventeen ";
            break;

        case 18:
            cout<<"Eighteen ";
            break;

        case 19:
            cout<<"Nineteen ";
            break;

        case 20:
            cout<<"Twenty ";
            break;
        
        case 30:
            cout<<"Thiry ";
            break;
        case 40:
            cout<<"Fourty ";
            break;

        case 50:
            cout<<"Fifty ";
            break;

        case 60:
            cout<<"Sixty ";
            break;

        case 70:
            cout<<"Seventy ";
            break;

        case 80:
            cout<<"Eighty ";
            break;

        case 90:
            cout<<"Ninty ";
            break;
    }
}

void printIntoWords(int num){


    if(num < 20){
        printString(num);
        return;
    }

    int count = countDigits(num);
    int *rev = new int[count];
    reverse(rev, num);
    

    int index = 0;


    while(count > 0){

        if(count < 3 && rev[index] < 2){

            int n = rev[index] * 10 + rev[index + 1];
            printString(n);
            count -= 2;
            index += 2;

        }else if(count < 3){

            printString(rev[index++] * 10);
            printString(rev[index++]);

            count -= 2;

        }
         else if(count < 4){

            printString(rev[index]);
            index++;

            printUnit(count);

            count -= 1;



        } else if ((count % 2) == 0 ){

            printString(rev[index]);
            index++;

            printUnit(count);

            count -= 1;


        } else{


            printString(rev[index++] * 10);
            printString(rev[index++]);

            printUnit(count);

            count -= 2;

        }

       
    }

    delete [] rev;

}

int main(){

    int num;


    cout<<"Enter +ve number ";
    cin>>num;

    printIntoWords(num);
}

