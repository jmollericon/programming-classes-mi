#include<stdio.h>
int leerNumero(){
	int sw=1;
	float numero;
	while (sw == 1){
		printf("ingrese valor de n = ");
	    scanf("%f",&numero);
		if (numero>0 && (int)numero == numero){
			sw = 0;
		}
	}
	return (int)numero;
}

double factorial(int num){
	int i;
	double fac=1;
	for (i=1;i<=num;i++){
		fac=fac*i;
	}
	return fac;
}

int esPrimo(int num){
	int i, c=0;
	for (i=1;i<=num;i++){
		if ((num%i)==0) c++;
	}
	if (c==2) return 1;
	else return 0;
}
int fibonacci(int n){
	int a=1, b=1, aux;
	double suma=0;
	while(n>0){
		if(esPrimo(a)==1) {
			printf("%d ", a);			
			suma=suma+factorial(a);
			n--;
		}
		aux=a;
		a=b;
		b=aux+b;
		//n--;
	}
	printf("\nla suma es: %.0f ",suma);
	return 0;
}
int main(){
	int n=leerNumero();
	fibonacci(n);
	/*if (esPrimo(22)==1) printf("si es primo");
	else printf("no es primo");*/
    //printf("\n\nn = %f",factorial(89));
	
}