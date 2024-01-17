#include<iostream>
#include<vector>

using namespace std;

int main(){

    vector<int> nums;

    nums.push_back(5);
    nums.push_back(7);

    for(auto a = nums.begin(); a != nums.end(); ++a){
        cout<<*a<<" ";
    }
}