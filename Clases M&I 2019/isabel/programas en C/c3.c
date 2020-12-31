#include<stdio.h>
#include<string.h>
main(){
    char cadena[20] = " ";
    int n,c,cmay=0,i;
    double por;
	printf("ingrese n : ");    
	scanf("%d",&n);
    for (i=1;i<=n;i++){
        printf("correo [%d] : ",i);
		scanf("%s",&cadena);
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
    printf("El porcentaje es : %.0f ",por);
}
