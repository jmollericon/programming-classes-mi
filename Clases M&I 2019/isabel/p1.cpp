#include<iostream>
using namespace std;
main(){
	int n1,n2,aux1,aux2,c=0,acarreo=0;
	cout << "introducir dos numeros : \n";
	cin >> n1; 
	cin >> n2;
	aux1=n1; 
	aux2=n2;

	while (aux1 > 0 || aux2 > 0)
	{
		acarreo = (acarreo + aux1%10 + aux2%10)/10; 
		if(acarreo == 1) c++; // si existe acarreo incrementa c
		aux1=aux1/10;
		aux2=aux2/10;
	}
	cout << c << " operaciones de acarreo";
}

