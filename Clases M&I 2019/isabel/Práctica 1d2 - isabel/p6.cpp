#include<iostream>
using namespace std;

long long factorial(int N){
	long long fac = 1;
	for (int i=1;i<=N;i++){
		fac = fac *i;
	}
	return fac;
}
int crearNumero(long long n){
	int primos[4], d;
	primos[0]=2; primos[1]=3;
	primos[2]=5; primos[3]=7;
	long long aux,nuevoN=0;
	for (int i=0;i<4;i++){
		aux = n;
		while (aux>0){
			d = aux % 10;
			//cout << d << endl;
			aux = aux /10;
			if (d == primos[i]){
				nuevoN = nuevoN*10 + d;
			}
		}
	}
	return nuevoN;
}

int main(){
	int N;
	cout << "Ingrese N: ";
	cin >> N;
	long long fa = factorial(N);
	cout << "factorial: " << fa << endl;
	long long nuevoNum = crearNumero(fa);
	cout << "Nuevo numero: " << nuevoNum;
}