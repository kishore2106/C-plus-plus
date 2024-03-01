#include<bits/stdc++.h>
using namespace std;

void printAllPrefixes(char str[]){
    int n = strlen(str);
    for(int e = 0;str[e]!='\0';e++){
        for(int s=0;s<=e;s++){
            cout<<str[s];
        }
        cout<<endl;
    }
}

int main(){
    char name[100];
    cin.getline(name,99);
    printAllPrefixes(name);

    return 0;
}