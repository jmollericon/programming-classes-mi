#include<iostream>
using namespace std;

int verificar(int n1, int n2){
	int v1=0,v2=0;
	for (int i=1;i<n1;i++){
		if (n1%i == 0) v1 = v1 + i;
	}
	for (int i=1;i<n2;i++){
		if (n2%i == 0) v2 = v2 + i;
	}
	if (v1 == n2 && v2 ==n1) return 1;
	else return 0;
}

int main(){
	int n1,n2;
	cout << "ingrese primer numero: ";
	cin >> n1;
	cout << "ingrese segundo numero: ";
	cin >> n2;
	if (verificar(n1, n2)==1) cout << n1 << " y "<< n2 << " Son amigos";
	else cout << n1 << " y "<< n2 << " NO son amigos";
}