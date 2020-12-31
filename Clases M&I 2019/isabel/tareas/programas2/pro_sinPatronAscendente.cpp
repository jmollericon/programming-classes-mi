#include <iostream>
#include <math.h>
using namespace std;
int udn (int n){
	return n%10;
}

int ordenadoAsce (int n){
	int nOrdenado = 0, np = n, i;
	//n= 38126;  d1=6 d2=2
	int d1,d2,na,aux;
	for (i=1;i<=5;i++){
		na=np/pow(10,i-1);
		d1 = na%10;
		na=np/pow(10,i);
		d2 = na%10; // na=3812
		cout <<i<< " d1= "<<d1<<"d2= "<<d2<<"na= "<<na<<"\n";
		if(d1<d2){
			aux = d1*10+d2;
			np=n/pow(10,i+1);
			np=np*100 + aux;
			cout << "aux "<<aux<<" n = "<<n<<" np = "<<np<<"\n";
		}
		
		
		
		
	}
	return nOrdenado;
}


int main(int argc, char *argv[]) {
	int n,d,nn=0,pp=0;
	cout << "Ingrese un numero: ";
	cin >> n;
	cout << "ordenando = " << ordenadoAsce(n);
	return 0;
}
