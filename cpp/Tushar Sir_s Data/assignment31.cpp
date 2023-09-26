#include<iostream>
#include<cstring>
#include<cstdlib>
using namespace std;
int main(){				//Assignment 31
	char temp[20], *t;
	int i, l, j, n=5;
	char *s[5];
	for(i=0; i<5; i++){
		cout<<"Emter name"<<endl;
		cin>>temp;
		l=strlen(temp);
		s[i]=(char*)malloc(sizeof(char)*l+1);
		strcpy(s[i],temp);
	}
	for(i=0; i<n-1; i++){
		for(j=i+1; j<n; j++){
			if(strcmp(s[i],s[j])>0)
			{
				t=s[i];
				s[i]=s[j];
				s[j]=t;
			}
		}
	}
	cout<<"Strings in alphabetical order-"<<endl;
	for(i=0; i<5; i++)
		cout<<s[i]<<endl;
	for(i=0; i<5; i++)
		free(s[i]);	//to avoid memory leakage
	return 0;
}
