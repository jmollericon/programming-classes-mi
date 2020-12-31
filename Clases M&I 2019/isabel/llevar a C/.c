#include<stdio.h>
#include<time.h>
#include<stdlib.h>
main(){
int nA; //num aleatorio
int n,r1=0,r2=50;
printf("Estoy pensando un número entre 0 y 50\n");
//generamos número aleatorio
srand(time(NULL));
nA=rand()%50;
for (int i=1;i<=5;i++){
    printf("Intento %d:\n",i);
    printf("?");
    scanf("%d",&n);
    if(n==nA){
        printf("Felicidades adivinaste el numero.!\n");
        break;
    }
    else if(n<nA){
        printf("El número esta entre %d y %d\n",n,r2);
        r1=n;
    }
    else {
        printf("El número esta entre %d y %d\n",r1,n);
        r2=n;
    }
}
    printf("El numero era: %d\n",nA);
}
