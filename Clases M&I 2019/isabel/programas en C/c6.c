#include<stdio.h>
#include<string.h>
main(){
    char cadena[50];
    char * pch;
    int n,c,cNomComp=0,i;
	printf("ingrese n : ");
    scanf("%d",&n);
    for (i=1;i<=n;i++){
        printf("nombre [%d] : ",i);
		scanf("%s",&cadena);
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
    printf("Número de personas con nombres compuestos: %d",cNomComp);
}
