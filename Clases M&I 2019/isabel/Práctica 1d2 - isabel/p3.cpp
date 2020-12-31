#include<iostream>
using namespace std;

double potencia(int n1, int n2){
	double valor = 1;
	for (int i=1;i<=n2;i++)
	{
		valor = valor*n1;
	}
	return valor;
}

int main(){
	int A,B;
	cout << "ingrese A: ";
	cin >> A;
	cout << "ingrese B: ";
	cin >> B;
	double po = potencia(A,B);
	cout << A << "^" << B << "=" <<po;
}