package practice;
public class N40 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		char m[][] = new char[n][n];
		int ruta[][] = new int[n][n];
		m[0][0]='z'; m[0][1]='x'; m[0][2]='c'; m[0][3]='d';
		m[1][0]='h'; m[1][1]='n'; m[1][2]='z'; m[1][3]='x';
		m[2][0]='w'; m[2][1]='o'; m[2][2]='i'; m[2][3]='o';
		m[3][0]='r'; m[3][1]='n'; m[3][2]='r'; m[3][3]='n';
		mostrarMatriz(n, m);
		String palabra = "horizon";
		int tam = palabra.length();
		int lp[] = new int[tam];
		for (int k = 0; k < tam; k++) {
			int c=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(m[i][j] == palabra.charAt(k)) {
						c++;						
					}
				}
			}
			lp[k]=c;
			System.out.println("lp: "+lp[k]);
		}
		
		
		buscarCaracteres(palabra, tam, 0, n, m, ruta, 0, 0, 1, lp);
		mostrarMatrizRuta(n, ruta);
		
	}
	public static void buscarCaracteres(String palabra,int tam, int k, int n, char m[][], int ruta[][], int ia, int ja, int c, int lp[]) {
		System.out.println("k = "+k);
		if(k<tam) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(m[i][j] == palabra.charAt(k)) {
						System.out.println(m[i][j]+" i= "+i+" j= "+j);
						if(k==0){
							ruta[i][j]=c;
							ia=i; ja=j;
							c++;
							k++;
							mostrarMatrizRuta(n, ruta);
						}else if(((Math.abs(i-ia)==1)&&(Math.abs(j-ja)==1))||((Math.abs(i-ia)==1)&&(j==ja))||((Math.abs(j-ja)==1)&&(i==ia))) {
							ruta[i][j]=c;
							ia=i;
							ja=j;
							c++;
							lp[k]--;
							k++;
							System.out.println("sig pala: "+palabra.charAt(k));
							mostrarMatrizRuta(n, ruta);
						}else {
							ruta[ia][ja]=0;
							System.out.println("restantes: "+lp[k-1]);
							if(lp[k-1] > 0){
								k--;
								if(ja == n-1) {
									j=0;
									i=ia+1;
								}else {
									i=ia;
									j=ja+1;	
								}
							}
						}
					}
				}
			}
			buscarCaracteres(palabra, tam, k, n, m, ruta, ia, ja, c, lp);
		}		
	}
	public static void mostrarMatriz(int n, char m[][]){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void mostrarMatrizRuta(int n, int ruta[][]){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ruta[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
