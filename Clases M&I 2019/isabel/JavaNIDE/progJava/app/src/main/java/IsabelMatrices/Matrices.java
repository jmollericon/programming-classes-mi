package IsabelMatrices;
import java.util.*;
public class Matrices {

  public static void main(String[] args) {
    Scanner lee = new Scanner(System.in);
    int n;
    System.out.print("Ingrese n: ");
    n = lee.nextInt();
    int mat[][] = new int[n][n];
    int mat2[][] = new int[n][n];
    llenarMatriz(mat, n);
    System.out.println("Matriz generada: ");
    mostrarMatriz(mat, n);
    genNuevaMatriz(mat, mat2, n);
    System.out.println("\nNueva Matriz: ");
    mostrarMatriz(mat2, n);
  }
  public static void llenarMatriz(int[][] mat, int n){
    int val;
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        val = (int)(Math.random()*100);
        mat[i][j] = val;
      }
    }
  }
  public static void genNuevaMatriz(int[][] mat, int[][] mat2, int n){
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if((i==0)||(i==n-1)||(j==0)||(j==n-1)){
            mat2[i][j] = 0;
          }else{
            if(verificarPrimo(mat[i][j])){
            mat2[i][j] = mat[i-1][j-1]+mat[i-1][j]+mat[i-1][j+1]+mat[i][j-1]+mat[i][j+1]+mat[i+1][j-1]+mat[i+1][j]+mat[i+1][j+1];
            }
            else{
              mat2[i][j] = 0;
            }
          }
        }
      }
  }

  public static void mostrarMatriz(int[][] ma, int n){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        System.out.print(ma[i][j]+"  ");
      }
      System.out.println(" ");
    }
  }
  public static boolean verificarPrimo(int num){
    int c=0;
    for(int i=1;i<=num;i++){
      if(num%i == 0) c++;
    }
    if(c == 2) return true;
    else return false;
  }
}
