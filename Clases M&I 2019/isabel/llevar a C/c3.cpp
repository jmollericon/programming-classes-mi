#include <iostream>
#include<string.h>
using namespace std;
main(){
    char cadena[20] = " ";
    int n,c,cmay=0;
    double por;
    cout << "ingrese n : ";
    cin >> n;
    for (int i=1;i<=n;i++){
        cout << "correo ["<<i<<"] : ";
        cin >> cadena;
        char * pch;
        c = 0;
        pch = strtok(cadena, "@");
        while (pch != NULL)        {
            c = c + 1;
            if ((c == 2) && (strcmp(pch,"gmail.com")==0)){
                cmay = cmay + 1;
            }
            pch = strtok (NULL, "@");
        }
    }
    por = (cmay*100/n);
    cout <<"El porcentaje es : "<<por<<"%.";
}
