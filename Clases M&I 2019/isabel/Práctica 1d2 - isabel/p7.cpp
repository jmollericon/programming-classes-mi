#include<iostream>
using namespace std;

int mayor(int n1, int n2){
	if (n1 > n2) return n1;
	else return n2;
}
int menor(int n1, int n2){
	if (n1 < n2) return n1;
	else return n2;
}
int ordenar(int n){
	int a, d, ord=0;
	for (int i=0;i<=9;i++){
		a = n;
		while (a > 0){
			d = a%10;
			if (d == i){
				ord = ord*10 + d;
			}
			a=a/10;
		}
	}
	return ord;
}
int crearNumero(int n1, int n2){
    int aux=0;
    int d;
    while (n1 > 0){
    	d = n1%10;
    	if (d %2 == 1){
    		aux = aux*10 + d;
    	}
    	n1 = n1/10;
    }
    while (n2 > 0){
    	d = n2%10;
    	if (d %2 == 0){
    		aux = aux*10 + d;
    	}
    	n2 = n2/10;
    }
    return ordenar(aux);
}

int main(){
	int num1, num2, num3;
	cout << "Ingrese numero 1: ";
	cin >> num1;
	cout << "Ingrese numero 2: ";
	cin >> num2;
	cout << "Ingrese numero 3: ";
	cin >> num3;
	int may = mayor(mayor(num1,num2),num3);
	int men = menor(menor(num1,num2),num3);
	int nuevoNum = crearNumero(may, men);
	cout << "Nuevo Numero = " << nuevoNum;
	
	
}