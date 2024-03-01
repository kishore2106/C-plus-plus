#include<bits/stdc++.h>
using namespace std;

int length(char str[]){
    int res = 0;
    for(int i=0;str[i]!='\0';i++){
        res++;
    }
    return res;
}

void reverse(char str[]){
    int start = 0,end = length(str)-1;
    cout<<end;
    while(start<end){
        swap(str[start],str[end]);
        start++;end--;
    }
}

int main(){

    char str[100];
    cin.getline(str,7);
    cout<<"The entered string is : "<<str<<endl;
    reverse(str);
    cout<<"After reversing a string : "<<str<<endl;
    
    return 0;
}