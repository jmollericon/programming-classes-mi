#include<stdio.h>
int fibonacci(int n){
	int a=1,b=1,aux;
	while(n>0){
		printf("%d ",a);
		aux=a;
		a=b;
		b=aux+b;
		n--;
	}
	return 0;
}
int main(){
	fibonacci(5);
}