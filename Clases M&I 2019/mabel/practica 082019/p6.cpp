#include <iostream>
#include <math.h>
using namespace std;

int main(){
	int i,s=1;
	float serie=4.0;
	for (i=3;i<=100;i=i+2){
		serie = serie + pow(-1,i)*(4/i);
		cout<<" "<<pow(-1,s)<<"*4/"<<(i);
		s++;
	}
	cout<<"\npi = "<<serie;
}