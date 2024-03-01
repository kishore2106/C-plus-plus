#include<bits/stdc++.h>
using namespace std;

int main(){
    char name[100];
    cout<<"Enter your name : ";
    cin>>name;
    cout<<"Your name is : "<<name<<endl;

    name[4] = 'x';
    cout<<name<<endl;//abc bcz name[3] contians '\0'

    name[3] = 'd';
    cout<<name<<endl;

    name[3] = '\0';
    cout<<name<<endl;

    return 0;
}