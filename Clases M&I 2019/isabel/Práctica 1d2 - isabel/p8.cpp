#include<iostream>
using namespace std;

int creciente(int n){
	int aux, d, nn=0;
	for (int i=0;i<=9;i++){
		aux = n;
		while (aux > 0){
			d = aux%10;
			if (d == i){
				nn = nn*10 + d;
			}
			aux = aux/10;
		}
	}
	return nn;
}
int decreciente(int n){
	int aux, d, nn=0;
	for (int i=9;i>=0;i--){
		aux = n;
		while (aux > 0){
			d = aux%10;
			if (d == i){
				nn = nn*10 + d;
			}
			aux=aux/10;
		}
	}
	return nn;
}
int crearDosNumeros(int n){
	int d, n1=0, n2=0;
	while (n>0){
		d=n%10;
		if (d==2 || d==3 || d==5 || d==7){
			// es primo
			n1 = n1*10 + d;
		}
		else {
			// no es primo
			n2 = n2*10 + d;
		}
		n=n/10;
	}
	//cout << "n1: " << n1 << endl;
	//cout << "n2: " << n2 << endl;
	cout << "n1 = " << creciente(n1) << endl;
	cout << "n2 = " << decreciente(n2);
	return 0;
}
int fibonacci(int n){
	int a=0, b=1, aux, c=0;
	while (c<(n-1)){
		aux = a+b;
		a=b;
		b=aux;
		c++;
	}
	return a;
}

int main(){
	int i;
	cout << "Ingrese nro de termimo: ";
	cin >> i;
	int fibo = fibonacci(i);
	cout << "Termino " << i << " = " << fibo << endl;
	crearDosNumeros(fibo);
}
