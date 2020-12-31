public class p8 {
    public static void main(String[] args) {
        int i=2,c=0;
        System.out.println("Suma de los cuadrados de los primero 100 numeros compuestos.");
        System.out.println("Numeros Compuestos.");
        double suma=0;
	while(c<=100)
	{
            if (numeroCompuesto(i))
            {
		suma = suma + i*i;
		System.out.print(i+" ");
                c++;
            }
            i++;
	}
	System.out.println("\nSuma de sus cuadrados = "+suma);	
    }    
    public static boolean numeroCompuesto(int num){
	int c=0;
	for(int i=1;i<=num;i++)
	{
            if(num % i == 0 ) c++;
	}
	if (c > 2) return true;
	else return false;	
    }
}