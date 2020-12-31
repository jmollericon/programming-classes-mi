import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FacturaReporte extends JFrame implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  static String nu1="factura3.bin";

  public FacturaReporte () throws NumberFormatException, IOException, ClassNotFoundException {
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(100, 100, 700, 600);
   contentPane = new JPanel();
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   setContentPane(contentPane);
   contentPane.setLayout(null);

         try
         {
           FileInputStream fs2=new FileInputStream(nu1);
           ObjectInputStream fs1=new ObjectInputStream(fs2);
           String cad="Numero de faltura\tTotal Fcaturado\tTotal Facturado Literal\n";  
           cad+="============================================================\n";
           datos_factura obj;
           int n1,n2,n3,n4,n5,numero;
           String numli="";
           while (fs2.available()!=0)
              {
            obj= (datos_factura) fs1.readObject();
            
            numero=(int) obj.getTotal();
            n1 = numero / 10000;
            n2 = (numero / 1000) % 10;
            n3 = (numero / 100) % 10;
            n4 = (numero / 10) % 10;
            n5 = (numero % 10);
            numli="";
             if(numero > 10000){
                JOptionPane.showMessageDialog(null,"El numero ingresado excede el rango de valores");
            }else{
          if(n1 == 1){
          numli=numli+"Diez mil";
          }
          //Sentencia para determinar los miles
          if(n2 == 1){
           numli=numli+"MIL ";
          }else if(n2 == 2){
           numli=numli+"DOS MIL ";
          }else if(n2 == 3){
           numli=numli+"TRES MIL";
          }else if(n2 == 4){
           numli=numli+"CUATRO MIL ";
          }else if(n2 == 5){
           numli=numli+"CINCO MIL ";
          }else if(n2 == 6){
           numli=numli+"SEIS MIL ";
          }else if(n2 == 7){
           numli=numli+"SIETE MIL ";
          }else if(n2 == 8){
           numli=numli+"OCHO MIL ";
          }else if(n2 == 9){
           numli=numli+"NUEVE MIL ";
          }
          //Setencia para determinar los cientos
          if(n3 == 1 && n4 == 0 && n5 == 0){
           numli=numli+"CIEN ";
          }else if(n3 == 1){
           numli=numli+"CIENTO ";
          }else if(n3 == 2){
           numli=numli+"DOSCIENTOS ";
          }else if(n3 == 3){
           numli=numli+"TRESCIENTOS ";
          }else if(n3 == 4){
           numli=numli+"CUATROCIENTOS ";
          }else if(n3 == 5){
           numli=numli+"QUINIENTOS ";
          }else if(n3 == 6){
           numli=numli+"SEISCIENTOS ";
          }else if(n3 == 7){
           numli=numli+"SETECIENTOS ";
          }else if(n3 == 8){
           numli=numli+"OCHOCIENTOS ";
          }else if(n3 == 9){
           numli=numli+"NOVECIENTOS ";
          }
          //Setencia para determinar las decenas
          if(n4 == 1 && n5 == 0){
           numli=numli+"DIEZ";
          }else if(n4 == 1 && n5 == 1){
           numli=numli+"ONCE";
          }else if(n4 == 1 && n5 == 2){
           numli=numli+"DOCE";
          }else if(n4 == 1 && n5 == 3){
           numli=numli+"TRECE";
          }else if(n4 == 1 && n5 == 4){
           numli=numli+"CATORCE";
          }else if(n4 == 1 && n5 == 5){
           numli=numli+"QUINCE";
          }else if(n4 == 1){
           numli=numli+"DIECI";
          }
          if(n4 == 2 && n5 == 0){
           numli=numli+"VEINTE";
          }else if(n4 == 2){
           numli=numli+"VEINTI";
          }else if(n4 == 3 && n5 == 0){
           numli=numli+"TREINTA";
          }else if(n4 == 3){
           numli=numli+"TREINTA Y ";
          }else if(n4 == 4 && n5 == 0){
           numli=numli+"CUARENTA";
          }else if(n4 == 4){
           numli=numli+"CUARENTA Y ";
          }else if(n4 == 5 && n5 == 0){
           numli=numli+"CINCUENTA";
          }else if(n4 == 5){
           numli=numli+"CINCUENTA Y ";
          }else if(n4 == 6 && n5 == 0){
           numli=numli+"SESENTA";
          }else if(n4 == 6){
           numli=numli+"SESENTA Y ";
          }else if(n4 == 7 && n5 == 0){
           numli=numli+"SETENTA";
          }else if(n4 == 7){
           numli=numli+"SETENTA Y ";
          }else if(n4 == 8 && n5 == 0){
           numli=numli+"OCHENTA";
          }else if(n4 == 8){
           numli=numli+"OCHENTA Y ";
          }else if(n4 == 9 && n5 == 0){
           numli=numli+"NOVENTA";
          }
          else if(n4 == 9){
           numli=numli+"NOVENTA Y ";
          }
          //Sentencia para determinar las unidades
          if(n5 == 1 && n4 > 1){
           numli=numli+"UNO";
          }else if(n5 == 1 && n4 == 0){
           numli=numli+"UNO";
          }else if(n5 == 2 && n4 > 1){
           numli=numli+"DOS";
          }else if(n5 == 2 && n4 == 0){
           numli=numli+"DOS";
          }else if(n5 == 3 && n4 > 1){
           numli=numli+"TRES";
          }else if(n5 == 3 && n4 == 0){
           numli=numli+"TRES";
          }else if(n5 == 4 && n4 > 1){
           numli=numli+"CUATRO";
          }else if(n5 == 4 && n4 == 0){
           numli=numli+"CUATRO";
          }else if(n5 == 5 && n4 > 1){
           numli=numli+"CINCO";
          }else if(n5 == 5 && n4 == 0){
           numli=numli+"CINCO";
          }else if(n5 == 6){
           numli=numli+"SEIS";
          }else if(n5 == 7){
           numli=numli+"SIETE";
          }else if(n5 == 8){
           numli=numli+"OCHO";
          }else if(n5 == 9){
           numli=numli+"NUEVE";
            }
            }
             cad+=obj.getNum()+"\t"+obj.getTotal()+"\t"+numli+"\n";
        }
           JTextArea textArea = new JTextArea(cad);
     textArea.setBounds(39, 41, 600, 197);
     contentPane.add(textArea);
           fs2.close();
           
          JButton btnNewButton_1 = new JButton("VOLVER");
      btnNewButton_1.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        
        factura x = null;
        x = new factura();
        x.setLocationRelativeTo(null);
        x.setVisible(true);
        dispose();
        
       }
      });
      btnNewButton_1.setBounds(175, 20, 150, 15);
      contentPane.add(btnNewButton_1);
           
         }
         catch(IOException e)
         {
           System.out.println("Error en el archivo"+e.getMessage());
         }  
       
  }
}
