//verificar numeros compuesto
int main(){
	int suma=0;
	for(int i=1;i<=100;i++)
	{
		if (numeroCompuesto(i)==1)
		{
			suma = suma + i*i;
			printf("num perfecto = %d ",i);
		}
	}
	printf("\nsuma=%d",suma);	
}
numeroCompuesto(int num){
	int s=0;
	for(int i=1;i<=num/2;i++)
	{
		s=s+i;
	}
	if (s==num) return 1;
	else return 0;	
}