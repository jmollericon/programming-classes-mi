import java.util.Scanner; //SaraSalazar
public class basicoD {
   public static class doble{
	   int dato;
	   doble sgte,ant;
   }
    public static Scanner entrada;
	public static void main(String[] args) {
		entrada=new Scanner(System.in);
		doble cabd=null, cabi=null, nu=null;
		int op,p;
		do {
			menu();
			op=leer("su opcion es?");
			switch(op) {
			case 1:
				  nu=nuevo();
				  if(cabd==null) {
					  cabd=nu;
					  cabi=nu;
				  }
				  else {//soledad paredes
					  do {
						  p=leer("1. izd  2.der ");
					  }while(p<1 || p>2);
					  if(p==1)
					  {
						  cabi=add_iz(cabi,nu);
					  }
					  else
					  {
						  cabd=add_der(cabd,nu);
					  }
				  }
				break;
			case 2:
				//listado de iaquierda a derecha
				//Alexander Sosa
				listado_iz_der("Listado de Izd a der",cabi);
				break;
			case 3:
				listado_der_iz("Listado de der a izq",cabd);
				break;
			}
			
		}while(op!=10);
		

	}
	public static void listado_der_iz(String g, doble ca)
	{//Ronaldo Rojas
		System.out.println(g);
		while(ca!=null)
		{
			System.out.print(ca.dato+"\t");
			ca=ca.ant;
		}
	}
	public static void listado_iz_der(String g, doble ca)
	{
		System.out.println(g);
		while(ca!=null)
		{
			System.out.print(ca.dato+"\t");
			ca=ca.sgte;
		}
	}
	public static void menu()
	{
		System.out.println("\n*** listas dobles ***");
		System.out.println("1. lectura");
		System.out.println("2. listado D");
		System.out.println("3. listado I");	
		System.out.println("10.Salir");
	}
//valeria Aguirre
public static doble add_iz(doble c, doble nue)
{
	nue.sgte=c;
	c.ant=nue;
	c=nue;
	return(c);
}
//Ronaldo Rojas 
public static doble add_der(doble c, doble nue)
{
	c.sgte=nue;
	nue.ant=c;
	c=nue;
	return(c);
}
//vladinir Gutierrez
public static doble nuevo()
{
	doble n=new doble();
	n.dato=leer("dato para el nuevo nodo ");
	n.sgte=null;
	n.ant=null;
	return(n);
}
//Alexander Sosa
public static int leer(String f)
{
	int j;
	System.out.println(f);
	j=entrada.nextInt();
	return(j);
}
}
