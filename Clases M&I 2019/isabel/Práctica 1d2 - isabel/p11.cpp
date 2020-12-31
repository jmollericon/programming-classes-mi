#include<iostream>
using namespace std;

int numeroPerfecto(int n){
	int c=0;
	for (int i=1;i<=n/2;i++){
		if (n%i == 0) c = c + i;
	}
	if (c == n) return 1;
	return 0;
}
int numeroPrimo(int n){
	int c=0;
	for (int i=1;i<=n;i++){
		if (n%i == 0) c++;
	}
	if (c == 2) return 1;
	return 0;
}

int main(){
	int sw =1;
	int cpri=0, cper=0;
	while (sw == 1){
		int n;
		cout << "n = ";
		cin >> n;
		if (numeroPrimo(n) == 1) cpri++;
		if (numeroPerfecto(n) == 1) cper++;
		cout << "# de primos = "<<cpri;
		cout << "\n# de perfectos = " << cper << endl;
		if (cpri > 3){
			cpri--;
			cper=0;
			cout << "# de primos = "<<cpri;
		    cout << "\n# de perfectos = " << cper << endl;
		}
		if (cper > 4){
			if (cpri>1) cpri--;
			cper--;
			cout << "# de primos = "<<cpri;
		    cout << "\n# de perfectos = " << cper << endl;
		}
		if (cpri == 3 && cper == 4) sw = 0;
	}
}