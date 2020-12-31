#include<stdio.h>
#include<string.h>
#include<stdlib.h>
main(){
    char cad[20]=" ";
    char cad2[20]=" ";
    int i;
    printf("ingrese palabra : ");
    gets(cad);
    int tam = strlen(cad);
    for(i=0;i<tam;i++){
        cad2[tam-1-i] = cad[i];
    }
    if(strcmp(cad,cad2)==0){
        printf("Es Palindromo");
    }
    else{
        printf("NO es Palindromo");
    }
}
