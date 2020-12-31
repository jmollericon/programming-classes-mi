#include <iostream>
using namespace std;
int udn (int n){
	return n%10;
}

int ordenaAsce (int n){
	int p = 0; // patron
	int nOrdenado = 0, np = n;
	while(p<=9){
		while (n>0){
			if (udn(n)==p){
				nOrdenado = (nOrdenado*10)+ udn(n);
			}
			n= (int)(n/10);
		}
		n = np;
		p++;
	}
	return nOrdenado;
}


int main(int argc, char *argv[]) {
	int n;
	cout << "Ingrese un numero: ";
	cin >> n;
	cout << "Numero ordenando = " << ordenaAsce(n);
	return 0;
}