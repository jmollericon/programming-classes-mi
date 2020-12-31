#include <iostream>
#include<string.h>
using namespace std;
main(){
    char cadena[20];
    int n,c,cmay=0;
    double por;
    cout << "ingrese n : ";
    cin >> n;
    for (int i=1;i<=n;i++){
        cout << "persona ["<<i<<"] : ";
        // cedula;nombre;edad;nacionalidad
        cin >> cadena;
        char * pch;
        c = 0;
        pch = strtok(cadena, ";");
        while (pch != NULL)        {
            c = c + 1;
            if (c==3){ // verificar si son mayores de 18
                if(strcmp(pch,"17")==1){
                    cmay = cmay + 1;
                }
                //cout <<c<<" - "<<pch<<"\n";
            }
            pch = strtok (NULL, ";");
        }
    }
    por = (cmay*100/n);
    cout <<"El porcentaje es : "<<por<<"%.";
}
