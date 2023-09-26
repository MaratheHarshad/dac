#include<iostream>
using namespace std;

int main()
{
	int matchsticks=21;
	int pick;

	while(matchsticks!=1)
	{
		do{	
			cout<<"Pick matchsticks between 1 to 4"<<endl;
			cin>>pick;
		}while(pick<=0 || pick>=5);
		cout<<"Computer picks - "<<5-pick<<endl;
		matchsticks=matchsticks-5;
		cout<<"Number of matchsticks left-"<<matchsticks<<endl;
	}
	cout<<"1 matchstick remaining.."<<endl;
	cout<<"Computer wins !!"<<endl;
}
