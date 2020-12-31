#include<iostream>
using namespace std;

int nuevoNumero(long long n){
	long long aux,val=0;
	int d;
	for (int i=9;i>=0;i--){
		aux = n;
		while (aux>0){
			d = aux % 10;
			aux = aux /10;
			if (d == i){
				val = val*10 + d;
			}
		}
	}
	return val;
}

int main(){
	long long N;
	cout << "Ingrese N: ";
	cin >> N;
	long long nuevoN = nuevoNumero(N);
	cout << "Nuevo numero: " << nuevoN;

}