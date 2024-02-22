#include<bits/stdc++.h>
using namespace std;

int main(){
    int m,n;
    cin>>m>>n;
    cout<<"Before swapping"<<endl;
    cout<<m<<" "<<n<<endl;

    //swapping using third variable
    // int temp;
    // temp = m;
    // m = n;
    // n = temp;

    //Using Bitwise Operator XOR Swap Algorithm
    // m = m^n;
    // n = m^n;
    // m = m^n;

    //using inbuilt function
    swap(m,n);
    cout<<"After swapping"<<endl;
    cout<<m<<" "<<n<<endl;

    return 0;
}