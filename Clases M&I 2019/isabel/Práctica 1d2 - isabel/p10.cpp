#include<iostream>
using namespace std;

int frecDigitos(int n, int nm){
	int d,c,dn, aux;
	while (nm>0){
		d=nm%10;
		aux = n;
		c=0;
		while (aux > 0){
			dn = aux%10;
			if (d == dn) c++;
			aux = aux/10;
		}
		cout << "El digito " << d << " aparece " << c << " veces.\n";
		nm =nm/10;
	}
	return 0;
}
int mcd(int a, int b){
	int r;
	while (b!=0){
		r = a%b;
		a=b;
		b=r;
	}
	return a;
}

int main(){
	int a, b;
	cout << "ingrese a = ";
    cin >> a;
    cout << "ingrese b = ";
    cin >> b;
	int nm = mcd(a,b);
	cout << "mcd = "<< nm;
	cout << "\nFrecuencia de los digitos del mcd en el primer numero [" << a << "]:" << endl;
	frecDigitos(a,nm);
		cout << "\nFrecuencia de los digitos del mcd en el segundo numero [" << b <<"]:" << endl;
	frecDigitos(b,nm);
	
}