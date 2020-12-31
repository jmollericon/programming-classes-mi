import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FacturaAgregar extends JFrame implements Serializable{
 /**
  * 
  */
 
 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 static String n1="factura3.bin";
 static private JTextField tf1;
 static private JTextField tf2;
 static private JTextField tf3;
 static private JTextField tf4;
 
 


 public FacturaAgregar() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 652, 442);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel lblNewLabel = new JLabel("Numero factura");
  lblNewLabel.setBounds(51, 65, 222, 20);
  contentPane.add(lblNewLabel);
  
  JLabel lblNewLabel_1 = new JLabel("NIT cliente");
  lblNewLabel_1.setBounds(51, 106, 232, 20);
  contentPane.add(lblNewLabel_1);
  
  JLabel lblNewLabel_2 = new JLabel("Nombre Cliente");
  lblNewLabel_2.setBounds(51, 147, 222, 20);
  contentPane.add(lblNewLabel_2);
  
  JLabel lblNewLabel_3 = new JLabel("Total facturado");
  lblNewLabel_3.setBounds(51, 188, 222, 20);
  contentPane.add(lblNewLabel_3);
  
  tf1 = new JTextField();
  tf1.setBounds(300, 65, 86, 20);
  contentPane.add(tf1);
  tf1.setColumns(10);
  
  tf2 = new JTextField();
  tf2.setBounds(300, 106, 232, 20);
  contentPane.add(tf2);
  tf2.setColumns(10);
  
  tf3 = new JTextField();
  tf3.setBounds(300, 147, 86, 20);
  contentPane.add(tf3);
  tf3.setColumns(10);
  
  tf4 = new JTextField();
  tf4.setBounds(300, 188, 86, 20);
  contentPane.add(tf4);
  tf4.setColumns(10);
  
  
  JLabel lblNewLabel_6 = new JLabel("AGREGAR CLIENTES");
  lblNewLabel_6.setBounds(165, 25, 134, 14);
  contentPane.add(lblNewLabel_6);
  
  JButton b1 = new JButton("ALMACENAR");
  b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    try 
    {
     write();
    }
    catch (IOException ex) 
    {
     Logger.getLogger(FacturaAgregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (ClassNotFoundException ex)
    {
     Logger.getLogger(FacturaAgregar.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
  });
  b1.setBounds(93, 344, 115, 23);
  contentPane.add(b1);
  
  JButton btnNewButton_1 = new JButton("SALIR");
  btnNewButton_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
    factura x = null;
    x = new factura();
    x.setLocationRelativeTo(null);
    x.setVisible(true);
    dispose();
    
   }
  });
  btnNewButton_1.setBounds(225, 344, 115, 23);
  contentPane.add(btnNewButton_1);
 }
 public void write() throws IOException,ClassNotFoundException
    { 
      try
      { 
      File arch = new File(n1);
      int nu=Integer.parseInt(tf1.getText());
      String nit=tf2.getText();
      String nombre=tf3.getText();
      int saldo=Integer.parseInt(tf4.getText());
      datos_factura o=new datos_factura(nu,nit,nombre,saldo);
   JOptionPane.showMessageDialog(null, "Datos almacenados");
      if(arch.exists())
      {
         AppendableObjectOutputStream fs = new AppendableObjectOutputStream(new FileOutputStream(arch,true));   
         fs.writeUnshared(o);
         fs.close();   
      } 
      else 
      {
         ObjectOutputStream fs = new ObjectOutputStream(new FileOutputStream(arch,true));         
         fs.writeUnshared(o);
         fs.close();             
      }
      } 
      catch(NumberFormatException ex)
      {
       JOptionPane.showMessageDialog(null,"debe ingresar datos numericos");
      }
   }


}

