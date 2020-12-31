#include <iostream>
#include<string.h>
using namespace std;
main(){
    char cadena[50];
    char * pch;
    int n,c,cNomComp=0;
    cout << "ingrese n : ";
    cin >> n;
    for (int i=1;i<=n;i++){
        cout << "nombre ["<<i<<"] : ";
        cin>>cadena;
        c = 0;
        pch = strtok(cadena, "-");
        while (pch != NULL){
            c = c + 1;
            pch = strtok (NULL, "-");
        }
        if(c >=2 ){
            cNomComp = cNomComp + 1;
        }
    }
    cout <<"Número de personas con nombres compuestos: "<<cNomComp;
}

