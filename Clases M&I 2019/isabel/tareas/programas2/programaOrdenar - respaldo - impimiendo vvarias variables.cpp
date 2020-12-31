#include <iostream>
#include <math.h>
using namespace std;
int udn (int n){
	return n%10;
}

int ordenadarAscendente (int n, int nd){
	int nOrdenado = 0, np = n, i,k;
	int d1,d2,na,aux,aux2,po;
	for (k=1;k<nd;k++)
	{
		for (i=1;i<nd;i++)
		{
			na=np/pow(10,i-1);
			d1 = na%10;
			na=np/pow(10,i);
			d2 = na%10; // na=3812
			cout <<"\n"<<i<< " d1= "<<d1<<" d2= "<<d2<<" na= "<<na;
			if(d1<d2)
			{
				aux = d1*10+d2;
				po=(int)pow(10,i-1);
				aux2=np % po;
				np=np/pow(10,i+1);
				np=np*100 + aux;
				np=np*po + aux2;
				cout << "\naux "<<aux<<" n = "<<n<<" np = "<<np<<" aux2 = "<<aux2<<"\n";
			}
			cout <<"  np = "<<np<<"\n";
		}
	}
	return np;
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
	int n,d,nn=0,pp=0,digitos;
	cout << "Ingrese un numero: ";
	cin >> n;
	digitos = numeroDigitos(n);
	cout << "ordenando = " << ordenadarAscendente(n, digitos);
	return 0;
}
