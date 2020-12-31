package IsabelMatrices;
import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner lee = new Scanner(System.in);
int n, m;
System.out.print("Ingrese el numero de filas: ");
n = lee.nextInt();
System.out.print("Ingrese el numero de columnas: ");
m = lee.nextInt();
int mat[][] = new int[n][m]; // declaracion de la matriz[n][m]
llenarMatriz(mat, n, m);    // metodo para generar la matriz
    System.out.println("Matriz generada: ");
    mostrarMatriz(mat, n, m);   // metodo para mostrar la matriz
  }
  public static void llenarMatriz(int[][] mat, int n, int m){
    boolean sw; // switch para verificar si el numero generado no es repetido
    int val, ce = 0; // val (valor generardo 'random'), ce(contador de elementos de la matriz)
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        do{
          val = (int)(Math.random()*n*m);
          sw = verificarRepetido(mat, n, m, ce, val);
        } while(sw == true);
        mat[i][j] = val;
        ce++;
      }
    }
  }
  public static boolean verificarRepetido(int[][] ma, int nn, int mm, int c, int v){
    if(c>0){
      for(int i=0;i<nn;i++){
        for(int j=0;j<mm;j++){
          if((c>0) && (ma[i][j]==v)){
            return true;
          }
          c--;
        }
      }
      return false;
    }
    return false;
  }

  public static void mostrarMatriz(int[][] ma, int nn, int mm){
 for(int i=0;i<nn;i++){
      for(int j=0;j<mm;j++){
        System.out.print(ma[i][j]+"  ");
      }
      System.out.println(" ");
    }
  }
}