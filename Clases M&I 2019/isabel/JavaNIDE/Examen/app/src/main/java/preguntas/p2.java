package preguntas;

public class p2 {

  public static void main(String[] args) {
  
    System.out.println("ingrese n");
    int n = 5;
    int m[][] = new int[n][n];
    for(int i=0;i<n; i++){
      for(int j=0; j<n; j++){
        m[i][j]=0;
      }
    }
    int aux1, v;
    for(int i=0;i<n; i++){
      v =1;
      aux1 = 0;
      for(int j=0; j<n-i; j++){
      if(j%2 == 0){
        m[i][j]=v + aux1;
        v++;
        aux1 = aux1 + 2;
      }else{
           m[i][j]=2*aux1;
      }
     
      }
    }
   
    for(int i=0;i<n; i++){
      for(int j=0; j<n; j++){
        System.out.print(m[i][j]+" ");
      }
      System.out.println();
    }
    
  }
}
