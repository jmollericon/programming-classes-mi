#include<iostream>
using namespace std;
int main()
{
	cout << "hola mundo";
	int x[25], y[25], s[25], i;
    for (i=0; i < 25; i++)  y[i] = 0;
	s[0] = -30;
	s[1] = 30;
	s[2] = -30;
	s[3] = 30;
	for (i=0; i < 25; i++){
		cout << y[i] << " ";
	}
}