#include <iostream>
#include <math.h>
using namespace std;
int udn (int n){
	return n%10;
}
int ordenadarAscendente (int n, int nd){
	int nOrdenado = n, i, k;
	int d1,d2,na,aux,aux2,po;
	for (k=1;k<nd;k++)
	{
		for (i=1;i<nd;i++)
		{
			na = nOrdenado/pow(10,i-1);
			d1 = na%10;
			na = nOrdenado/pow(10,i);
			d2 = na%10;
			if(d1<d2)
			{
				aux = d1*10+d2;
				po = (int)pow(10,i-1);
				aux2 = nOrdenado % po;
				nOrdenado = nOrdenado/pow(10,i+1);
				nOrdenado = nOrdenado*100 + aux;
				nOrdenado = nOrdenado*po + aux2;
			}
		}
	}
	return nOrdenado;
}
int numeroDigitos(int n){
	int c=0;
	while(n>0){
		c++;
		n=n/10;
	}
	return c;
}

int main(int argc, char *argv[]) {
	int n,digitos;
	cout << "Ingrese un numero: ";
	cin >> n;
	digitos = numeroDigitos(n);
	cout << "ordenando = " << ordenadarAscendente(n, digitos);
	return 0;
}
