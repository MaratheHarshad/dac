#include<iostream>
using namespace std;
int main() {
	int num, i, status,m ,n;
	cout<<"Enter range:"<<endl;
	cin>>m>>n;
	for(num=m; num<=n; num++) {
		if(num==1)
			continue;
		status=0;
		for(i=2; i<num; i++) {
			if(num%i==0) {
				status=1;
				break;
			}
		}
		if(status==0)
			cout<<num<<"  ";
	}
	cout<<endl;	
	return 0;
}
