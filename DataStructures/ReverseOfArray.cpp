#include<bits/stdc++.h>
using namespace std;

void reverseArray(int arr[], int n){
    int start = 0,end = n-1;
    while(start<end){
        swap(arr[start],arr[end]);
        start++;
        end--;
    }
}

int main(){
    int n;
    cin>>n;
    int arr[n];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    //Printing in reverse order
    for(int i=n-1;i>=0;i--){
        cout<<arr[i]<<" ";
    }

    //Reversing Array
    reverseArray(arr,n);

    // Printing Reverse Order of array elements
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }

    return 0;
}