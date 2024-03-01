#include<bits/stdc++.h>
using namespace std;

int length(char str[]){
    int res = 0;
    for(int i=0;str[i]!='\0';i++){
        res++;
    }
    return res;
}

int main(){
    char str[100];
    cout<<"Enter the string : ";
    cin>>str;
    int n = length(str);
    cout<<"Length of the string str : "<<n<<endl;

    return 0;
}