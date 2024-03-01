#include<bits/stdc++.h>
using namespace std;

int main(){

    char name[100];
    cin.getline(name,99);

    //inbuilt length function
    int n = strlen(name);
    cout<<n<<endl;

    //strcmp -> to compare two strings 
    char str1[100];
    char str2[100];
    cin.getline(str1,100);
    cin.getline(str2,100);
    if(strcmp(str1,str2)==0){
        cout<<"equal"<<endl;
    }else{
        cout<<"not equal"<<endl;
    }

    //strcpy -> copy string
    strcpy(str1,"Hello");
    cout<<str1<<endl;

    //strncpy -> copies first n characters strncpy(dest,source,n)
    strncpy(str1, "Welcome",5);
    cout<<str1<<endl;

    //string concatenate
    strcat(str1," World");
    cout<<str1<<endl;

    return 0;
}