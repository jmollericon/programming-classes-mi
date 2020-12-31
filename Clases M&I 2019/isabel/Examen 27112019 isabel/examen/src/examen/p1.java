package examen;
import javax.swing.JOptionPane;
public class p1 {
    public static void main(String[] args) {
        int nf = Integer.parseInt(JOptionPane.showInputDialog("ingrese nf"));
        int nc = Integer.parseInt(JOptionPane.showInputDialog("ingrese nc"));
        int k = Integer.parseInt(JOptionPane.showInputDialog("ingrese k"));
        int w = Integer.parseInt(JOptionPane.showInputDialog("ingrese w"));
        int m[][] = new int[nf][nc];
        // inciso a)
        generarMatrizAleatoria(m,nf,nc,k,w);
        System.out.println("INCISO A)");
        mostrarMatriz(m,nf,nc);
        // inciso b)
        // inciso c)
        System.out.println("INCISO C)");
        obtenerPrimoMasBajo(m,nf,nc,w);
        // inciso d)
        System.out.println("INCISO D)");
        int may = obtenerMayorRecursivamente(m,nf,nc,0,0,0);
        System.out.println("El mayor es: " + may);
        // inciso e)
        System.out.println("INCISO E)");
        generarMatrizOrdenada(m,nf,nc);
    }
    public static void generarMatrizAleatoria(int m[][], int nf, int nc, int k, int w){
        for (int i=0; i < nf; i++) {
            for (int j=0; j < nc; j++) {
                m[i][j] = (k + (int)(Math.random()*(w+1-k)));
            }
        }
    }
    public static void obtenerPrimoMasBajo(int m[][], int nf, int nc, int w){
        int primo = 1;
        boolean sw = true, sw2=true;
        while(primo <= w && sw2==true){
            primo = generarPrimo(primo);
            //System.out.println(primo);
            mainLoop:
                for (int i=0; i < nf; i++) {
                    for (int j=0; j < nc; j++) {
                        if(primo == m[i][j]){
                            System.out.println("primo mas bajo: "+primo);
                            sw=false;
                            sw2=false;
                            break mainLoop; // rompe todo el 'mainLoop'
                        }
                    }
                }
        }

        if(sw){
            System.out.println("error");
        }
    }
    public static int generarPrimo(int p){
        int c=0;
        do{
            p++;
            c=0;
            for(int i=1; i<=p;i++){
                if(p%i == 0){
                    c++;
                }
            }
        }while(c<2 || c>2);
        return p;
    }
    public static int obtenerMayorRecursivamente(int m[][], int nf, int nc, int f, int c, int mayor){
        if(f==nf-1 && c==nc-1){
           return mayor;
        }else{
            if(mayor < m[f][c]){
                mayor = m[f][c];
            }
            if(c==nc-1){
                f++;
                c=0;
            }else{
                c++;
            }
            return obtenerMayorRecursivamente(m,nf,nc,f,c,mayor);
        }
    }
    public static void generarMatrizOrdenada(int m[][], int nf, int nc){
        int m2[][] = new int[nf][nc];
        int k=0;
        int l=0;
        // buscamos los impares
        for (int i=0; i < nf; i++) {
            for (int j=0; j < nc; j++) {
                if(m[i][j]%2 == 1){
                    m2[k][l]=m[i][j];
                    if(l==nc-1){
                        k++;
                        l=0;
                    }else{
                        l++;
                    }
                }
            }
        }
                        // buscamos los pares
        for (int i=0; i < nf; i++) {
            for (int j=0; j < nc; j++) {
                if(m[i][j]%2 == 0){
                    m2[k][l]=m[i][j];
                    if(l==nc-1){
                        k++;
                        l=0;
                    }else{
                        l++;
                    }
                }
            }
        }
        mostrarMatriz(m2,nf,nc);

    }

    public static void mostrarMatriz(int m[][], int nf, int nc){
        for (int i=0; i < nf; i++) {
            for (int j=0; j < nc; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
