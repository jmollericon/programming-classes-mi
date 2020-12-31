#include <iostream>
#include<string.h>
using namespace std;
main(){
    char cadena[20];
    int n,c,cLP=0,cCBBA=0,cSCZ=0,cO=0,cPo=0,cPa=0,cT=0,cS=0,cB=0,cEx=0;
    cout << "ingrese n : ";
    cin >> n;
    for (int i=1;i<=n;i++){
        cout << "ci ["<<i<<"] : ";
        cin >> cadena;
        char * pch;
        c = 0;
        pch = strtok(cadena, "-");
        while (pch != NULL)        {
            c = c + 1;
            if (c==2){ 
                if(strcmp(pch,"LP")==0) cLP = cLP +1;
                else if (strcmp(pch,"CBBA")==0) cCBBA = cCBBA +1;
                else if (strcmp(pch,"SCZ")==0) cSCZ = cSCZ +1;
                else if (strcmp(pch,"O")==0) cO = cO +1;
                else if (strcmp(pch,"PO")==0) cPo = cPo +1;
                else if (strcmp(pch,"PA")==0) cPa = cPa +1;
                else if (strcmp(pch,"T")==0) cT = cT +1;
                else if (strcmp(pch,"S")==0) cS = cS +1;
                else if (strcmp(pch,"B")==0) cB = cB +1;
                else cEx = cEx + 1;
            }
            pch = strtok (NULL, "-");
        }
    }
    cout<<"# de CI\tciudad\n";
    cout <<cLP<<"\tLA PAZ\n";
    cout <<cCBBA<<"\tCOCHABAMBA\n";
    cout <<cSCZ<<"\tSANTA CRUZ\n";
    cout <<cO<<"\tORURO\n";
    cout <<cPo<<"\tPOTOSI\n";
    cout <<cPa<<"\tPANDO\n";
    cout <<cT<<"\tTARIJA\n";
    cout <<cS<<"\tSUCRE\n";
    cout <<cB<<"\tCENI\n";
    cout <<cEx<<"\tEXTRANJEROS\n";
}
