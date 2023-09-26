#include<iostream>
using namespace std;
int main(){
	int arr[100],n,max,smax,i;
	cout<<"How many integers"<<endl;
	cin>>n;
	cout<<"Enter elements"<<endl;
	for(i=0; i<n; i++)
		cin>>arr[i];
	max=smax=arr[0];
	for(i=1; i<n; i++) {
		if(arr[i]>max) {
			smax=max;
			max=arr[i];		
		}
		else if(arr[i]>smax){
			smax=arr[i];
		}
	}
	if(max==arr[0]) {
		smax=arr[1];
		for(i=2; i<n; i++) {
			if(arr[i]>smax)
				smax=arr[i];
		}
	}
	cout<<"max="<<max<<" smax="<<smax<<endl;
	return 0;
}
