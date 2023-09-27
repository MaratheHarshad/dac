
// 1. In BigInt class overload following operators:
//    Binary operators + - * / to work with
//    - both operands of type BigInt
//    - one BigInt operand and one int
//    Unary operators ++ and -- in both pre and post form.
//    Also write a small program to demonstrate the use of BigInt class and overloaded operators.



#include <iostream>
using namespace std;

class BigInt {


    
	int num;

    public:

	BigInt() : num(0) {
	}
	BigInt(int n) : num(n) {
	}

    int get(){
        return num;
    }

	void Read() {
		cin >> num;
	}
	void Write() {
		cout << num;
	}

    // Below are the operator overloaded member functions 
    // operator overloaded member functions are the functions in which the first operand is always the class object

	bool operator==(BigInt obj2) {
		if (num == obj2.num) {
			return true;
		}
		return false;
	}

    bool operator > (BigInt obj2){

        if(num > obj2.num){
            return true;
        }

        return false;
    }


    BigInt operator * (BigInt obj2){

        BigInt result(num * obj2.num);
        return result;

    }

    BigInt operator * (int number){

        BigInt result(num * number);
        return result;

    }

    // The problem with pre and post (increment / decrement) operator is 
    // same operator ++ / -- is used 
    // compiler designers knew this problem
    // so they defined the compiler in a way 
    // for post operator (i++)
    // internally compiler convert this into like
    // BigInt operator ++ (int)
    // This is how compiler differentiate between pre and post operator


    // This is for post increment (i++)
    BigInt operator ++ (int){

        
        BigInt result(num);
        num++;

        return result;


    }

    // this is for pre increment (++i)
    BigInt operator ++ (){

        num++;
        BigInt result(num);

        return result;
    }

    friend BigInt operator * (int, BigInt);
};

// operator overloaded global function 
// operator overloaded global function are the functions in which first operand type doesn't matter whatever it is unlinke overloaded member function


// BigInt operator * (int n, BigInt obj){
//     return n * obj.get(); // if there exists get method , otherwise it would through an error because we coldn't access the private element outside of class 
// }


// or 

// correct approach ( By Navendu Singh , sir)

// BigInt operator * (int n, BigInt obj){
//     return obj * n; // internally overloaded member function will be called because we changed the order of arguments
// }

// or by making overloaded global function as a friend function

BigInt operator * (int n, BigInt obj){
    return n * obj.num;
}


int main() {

	BigInt i(10);
	BigInt j(20);

	if (i == j) {
		cout << "They are equal\n";
	}
	else {
		cout << "They are NOT equal\n";
	}


    if (i > j){
        cout<<"object 1 is greater than 2\n";
    }else{
        cout<<"object 2 is greater than 1\n";
    }

    BigInt product = i * j;

    BigInt productWithIntSecond = i * 5;

    cout<<"product of 2 objects : "<<product.get()<<" \n";
    cout<<"productWithIntSecond of 1 object and 1 int : "<<productWithIntSecond.get()<<" \n";


    BigInt productWithIntFirst = 5 * j;

    cout<<"productWithIntFirst of 1 object and 1 int : "<<productWithIntFirst.get()<<" \n";



    BigInt postIncrement = i++;

    cout<<"value of i " <<i.get()<<endl;
    cout<<"value of postIncrement "<<postIncrement.get()<<endl;



    BigInt preIncrement = ++j;

    cout<<"value of j " <<j.get()<<endl;
    cout<<"value of preIncrement "<<preIncrement.get()<<endl;


	return 0;
}



