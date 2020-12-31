#include<stdio.h>
#include<string.h>
main(){
    char cadena[20];
    int n,c,cLP=0,cCBBA=0,cSCZ=0,cO=0,cPo=0,cPa=0,cT=0,cS=0,cB=0,cEx=0,i;
    printf("ingrese n : ");
    scanf("%d",&n);
    for (i=1;i<=n;i++){
        printf("ci [%d] : ",i);
		scanf("%s",&cadena);
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
    printf("# de CI\tciudad\n");
    printf("%d \tLA PAZ\n",cLP);
    printf("%d \tCOCHABAMBA\n",cCBBA);
    printf("%d \tSANTA CRUZ\n",cSCZ);
    printf("%d \tORURO\n",cO);
    printf("%d \tPOTOSI\n",cPo);
    printf("%d \tPANDO\n",cPa);
    printf("%d \tTARIJA\n",cT);
    printf("%d \tSUCRE\n",cS);
    printf("%d \tCENI\n",cB);
    printf("%d \tEXTRANJEROS\n",cEx);
}
