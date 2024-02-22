#include<bits/stdc++.h>
using namespace std;

int LargestOfArray(int arr[], int n){
    int max = INT_MIN;
    for(int i=0;i<n;i++){
        if(max < arr[i]){
            max = arr[i];
        }
    }
    return max;
}

int main(){
    int n;
    cin>>n;
    int arr[n];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    int lar = LargestOfArray(arr,n);

    cout<<lar<<endl;

    return 0;
}