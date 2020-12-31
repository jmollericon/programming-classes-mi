#include<stdio.h>
#include<string.h>
main(){
    char cadena[20];
    int n,c,cmay=0,i;
    double por;
	printf("ingrese n : ");
	scanf("%d",&n);
    for (i = 1 ; i <= n ; i++) {
        printf("persona [%d] : ",i);
		scanf("%s",&cadena); // cedula;nombre;edad;nacionalidad
        char * pch;
        c = 0;
        pch = strtok(cadena, ";");
        while (pch != NULL)        {
            c = c + 1;
            if (c==3){ // verificar si son mayores de 18
                if(strcmp(pch,"17")==1){
                    cmay = cmay + 1;
                }
                printf("%d - - %s\n",c,pch);
            }
            pch = strtok (NULL, ";");
        }
    }
	por = (cmay*100/n);
	printf("El porcentaje es : %.0f ",por);
}
