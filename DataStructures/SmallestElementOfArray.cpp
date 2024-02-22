#include<bits/stdc++.h>
using namespace std;

int SmallestOfArray(int arr[], int n){
    int min = INT_MAX;
    for(int i=0;i<n;i++){
        if(min> arr[i]){
            min = arr[i];
        }
    }
    return min;
}

int main(){
    int n;
    cin>>n;
    int arr[n];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    int small = SmallestOfArray(arr,n);

    cout<<small<<endl;

    return 0;
}