package examen;
import javax.swing.JOptionPane;
public class p2 {
    public static void main(String[] args){
        int n = Integer.parseInt(JOptionPane.showInputDialog("ingrese n"));
        int m[][] = new int[n][n];
        int val=1;
        generarMatriz(n,m,val);
        mostrarMatriz(m,n);
    }
    public static void generarMatriz(int n, int m[][], int val){
        for(int k=1;k<=n;k++){
            if(k%2 == 0){
                for(int i=0; i<k; i++){
                    for(int j=0; j<k; j++){
                        if((i+j) == (k-1)){
                            m[i][j]=val;
                            val++;
                        }
                    }
                }
            }else{
                for(int i=k; i>=0; i--){
                    for(int j=k; j>=0; j--){
                        if((i+j) == (k-1)){
                            m[i][j]=val;
                            val++;
                        }
                    }
                }
            }
        }
    }
    public static void mostrarMatriz(int m[][], int n){
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }    
}
