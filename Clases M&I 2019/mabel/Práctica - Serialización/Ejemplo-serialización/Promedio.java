import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Promedio extends JFrame implements Serializable{

 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 static String nu1="factura3.bin";

 public Promedio () throws NumberFormatException, IOException, ClassNotFoundException {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 500, 200);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  double prmdio=prom();
        try
        {
          FileInputStream fs2=new FileInputStream(nu1);
          ObjectInputStream fs1=new ObjectInputStream(fs2);
          datos_factura obj;
          double total=0,i=0;

          while (fs2.available()!=0)
             {
           obj= (datos_factura) fs1.readObject();
           total++;
           if (obj.getTotal()>prmdio)
            i++;
            

          }
          fs2.close();
          //System.out.println(i);
          System.out.println(total);
          double tuu=Math.rint(i*100/total*100)/100;
          String cad="El porcentaje de montos facturados mayores al promedio es: "+tuu+"%";
          JTextArea textArea = new JTextArea(cad);
    textArea.setBounds(39, 65, 600, 50);
    contentPane.add(textArea);
        }
        catch(IOException e)
        {
          System.out.println("Error en el archivo"+e.getMessage());
        }  
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
 public double prom() throws  NumberFormatException, IOException, ClassNotFoundException
 {  
  double prom=0;
 try
    {
        FileInputStream fs2=new FileInputStream(nu1);
        ObjectInputStream fs1=new ObjectInputStream(fs2);
        datos_factura obj;
        double sum=0,total=0;
        while (fs2.available()!=0)
           {
         obj= (datos_factura) fs1.readObject();
         sum=sum+obj.getTotal();
         total++;
        }
     
        prom=sum/total;
        System.out.println(prom);
        return prom;
      }
      catch(IOException e)
      {
        System.out.println("Error en el archivo"+e.getMessage());
      }
 return prom;  
}

}
