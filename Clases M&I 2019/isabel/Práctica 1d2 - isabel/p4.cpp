#include<iostream>
using namespace std;

int numTriangulares(int n){
	int valor = 0;
	for (int i=1;i<=n;i++){
		valor = valor +i;
	}
	return valor;
}

int main(){
	int i, elem;
	cout << "Ingrese nro de elemento: ";
	cin >> i;
	elem = numTriangulares(i);
	cout << "El " << i << " elemento de los numeros triangulares es:" << endl;
	cout << "num = "<< elem;
}
