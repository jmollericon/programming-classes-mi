#include <iostream>
#include <math.h>
using namespace std;

int main(){ // 200 100 50 20
	int n ;
	cin >> n;
	int n200,n100,n50,n20;
	n200=n / 200;
	n = n % 200;
	n100 = n / 100;
	n = n % 100;
	n50 = n / 50;
	n = n % 50;
	n20 = n / 20;
	cout << "billetes de 200 : "<<n200;
cout << "\nbilletes de 100 : "<<n100;
cout << "\nbilletes de 50 : "<<n50;
cout << "\nbilletes de 20 : "<<n20;

}