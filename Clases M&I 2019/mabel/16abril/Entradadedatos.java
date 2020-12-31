import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Entradadedatos extends JFrame {

 private JPanel contentPane;
 static private JTextField tf1;
 static private JTextField tf2;
 static private JTextField tf3;
 static private JTextField tf4;

 public Entradadedatos() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 552, 342);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  JLabel lblNewLabel = new JLabel("CEDULA");
  lblNewLabel.setBounds(51, 68, 46, 14);
  contentPane.add(lblNewLabel);
  
  JLabel lblNewLabel_1 = new JLabel("NOMBRE");
  lblNewLabel_1.setBounds(51, 109, 46, 14);
  contentPane.add(lblNewLabel_1);
  
  JLabel lblNewLabel_2 = new JLabel("HORA DE ENTRADA (hh:mm)");
  lblNewLabel_2.setBounds(51, 150, 176, 14);
  contentPane.add(lblNewLabel_2);
  
  JLabel lblNewLabel_3 = new JLabel("HORA DE SALIDA(hh:mm)");
  lblNewLabel_3.setBounds(51, 195, 139, 14);
  contentPane.add(lblNewLabel_3);
  
  tf1 = new JTextField();
  tf1.setBounds(264, 65, 86, 20);
  contentPane.add(tf1);
  tf1.setColumns(10);
  
  tf2 = new JTextField();
  tf2.setBounds(263, 106, 232, 20);
  contentPane.add(tf2);
  tf2.setColumns(10);
  
  tf3 = new JTextField();
  tf3.setBounds(264, 147, 86, 20);
  contentPane.add(tf3);
  tf3.setColumns(10);
  
  tf4 = new JTextField();
  tf4.setBounds(264, 192, 86, 20);
  contentPane.add(tf4);
  tf4.setColumns(10);
  
  JLabel lblNewLabel_4 = new JLabel("ENTRADA DE DATOS");
  lblNewLabel_4.setBounds(165, 25, 134, 14);
  contentPane.add(lblNewLabel_4);
  
  JButton b1 = new JButton("ALMACENAR");
  b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    try {
     write();
    } catch (IOException e1) {
     // TODO Auto-generated catch block
     e1.printStackTrace();
    }
   }
  });
  b1.setBounds(93, 245, 115, 23);
  contentPane.add(b1);
  
  JButton btnNewButton_1 = new JButton("SALIR");
  btnNewButton_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
    ControlEmpleados x = null;
    x = new ControlEmpleados();
    x.setLocationRelativeTo(null);
    x.setVisible(true);
    dispose();
    
   }
  });
  btnNewButton_1.setBounds(225, 245, 115, 23);
  contentPane.add(btnNewButton_1);
 }
 public static void write() throws IOException
 {
   String filename="personal.bin";
   DataOutputStream fileout=new DataOutputStream(new FileOutputStream(filename,true));
   String ci=tf1.getText();
   fileout.writeUTF(ci);
   String name=tf2.getText();
   fileout.writeUTF(name);
   String he=tf3.getText();
   fileout.writeUTF(he);
   String hs=tf4.getText();
   fileout.writeUTF(hs);
   fileout.close();
   JOptionPane.showMessageDialog(null, "Datos almacenados");
 }
 
 
  public static void main(String[] args)
    {
        Entradadedatos obj=new Entradadedatos();
        obj.setBounds(0,0,450,450);
        obj.setVisible(true);
    }
    
}

