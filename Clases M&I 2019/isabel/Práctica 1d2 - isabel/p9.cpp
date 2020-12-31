#include<iostream>
using namespace std;

int crearNumero(int i, int j){
	int d, nn=0;
	while (i>0){
		d = i%10;
		if (d==2 || d==3 || d==5 || d==7) nn = nn*10 + d;
		i = i/10;
	}
		while (j>0){
		d = j%10;
		if (d==2 || d==3 || d==5 || d==7) nn = nn*10 + d;
		j = j/10;
	}
	return nn;
}
int verificar(int n1, int n2){
	int v1=0,v2=0;
	for (int i=1;i<=n1/2;i++){
		if (n1%i == 0) v1 = v1 + i;
	}
	for (int i=1;i<=n2/2;i++){
		if (n2%i == 0) v2 = v2 + i;
	}
	if (v1 == n2 && v2 ==n1) return 1;
	else return 0;
}

int numeroAmigoN(int N){
	int datos = 10000, c=0;
	for (int i=1;i<=datos;i++){
		for (int j=1;j<=datos;j++){
		    	if (i/2<=j && j/2<=i){
    		    	if (verificar(i,j)==1) {
    		    	    cout << "("<<i<<","<<j<<")"<<endl;
    		    	    c++;
    		    	}
   			}
   			if(c == N){
   			 return crearNumero(i,j);
   				break;
   				break;
   			}
		}
	}
	return 0;
}
int main(){
	int N;
	do{
	    cout << "ingrese N [0-10]: ";
	    cin >> N;
	}while (N<0 || N>10);
    int nu = numeroAmigoN(N);
    cout << "el nro es: " << nu;
}