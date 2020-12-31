#include <iostream>
#include<string.h>
#include<stdlib.h>
#include<stdio.h>
using namespace std;
main(){
    char cad[20]=" ";
    char cad2[20]=" ";
    cout << "ingrese palabra : ";
    gets(cad);
    int tam = strlen(cad);
    for(int i=0;i<tam;i++){
        cad2[tam-1-i] = cad[i];
    }
    if(strcmp(cad,cad2)==0){
        cout<<"Es Palindromo";
    }
    else{
        cout<<"NO es Palindromo";
    }
}
