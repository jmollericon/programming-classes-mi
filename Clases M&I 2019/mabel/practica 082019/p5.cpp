#include <iostream>
#include <math.h>
using namespace std;

int main(){
	int n = 26;
	cout <<n<<" ";
	while (n>1){
		if (n % 2 == 0){
			n=n/2;
		}
		else {
			n = n*3 +1;
		}
		cout <<n<<" ";	
	}
}