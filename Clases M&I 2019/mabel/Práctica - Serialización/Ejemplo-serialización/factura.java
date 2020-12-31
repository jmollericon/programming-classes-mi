import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class factura extends JFrame{
 private JPanel contentPane;
 /**
  * Launch the application.
  */
  public factura(int num, String nit, String nombre, double total) 
     {
       this.num=num;
       this.nit=nit;
       this.nombre=nombre;
       this.total=total;
     }
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    
    try {
     factura frame = new factura();
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
 int num;
 String nit, nombre;
 double total;
 String n1="factura.bin";

  public factura() {
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setBounds(100, 100, 750, 400);
   contentPane = new JPanel();
   contentPane.setBackground(Color.green);
   contentPane.setForeground(Color.CYAN);
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   setContentPane(contentPane);
   contentPane.setLayout(null);
   
   JLabel lb1 = new JLabel("FACTURA");
   lb1.setFont(new Font("Tahoma", Font.PLAIN, 30));
   lb1.setBounds(231, 41, 166, 45);
   contentPane.add(lb1);
   
   JLabel lb2 = new JLabel("Fecha de proceso");
   lb2.setBounds(80, 100, 110, 14);
   contentPane.add(lb2);
   Calendar fecha = new GregorianCalendar();
      int anio = fecha.get(Calendar.YEAR);
      int mes = fecha.get(Calendar.MONTH);
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      String fechita=dia +"/" + (mes+1) + "/" + anio;
      JLabel lb3=new JLabel(fechita);
   lb3.setBounds(195, 100, 86, 14);
   contentPane.add(lb3);
   
   JButton b1 = new JButton("Agregar");
   b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     FacturaAgregar x=new FacturaAgregar();
     x.setLocationRelativeTo(null);
     x.setVisible(true);
     dispose();  

    }
   });
   b1.setBounds(55, 157, 166, 23);
   contentPane.add(b1);
   
   JButton b2 = new JButton("Reporte");
   b2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     FacturaReporte y = null;
     try {
      y = new FacturaReporte();
     } catch (NumberFormatException | IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     } catch (ClassNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }
     y.setLocationRelativeTo(null);
     y.setVisible(true);
     dispose();
     
    }
   });
   b2.setBounds(256, 157, 129, 23);
   contentPane.add(b2);
   
   JButton b3 = new JButton("Promedio");
   b3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     Promedio y = null;
     try {
      y = new Promedio();
     } catch (NumberFormatException | IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     } catch (ClassNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }
     y.setLocationRelativeTo(null);
     y.setVisible(true);
     dispose();
     
    }
   });
   b3.setBounds(423, 157, 116, 23);
   contentPane.add(b3);
   
   JButton b4 = new JButton("Salir");
   b4.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     System.exit(0);
    }
   });
   b4.setBounds(574, 157, 116, 23);
   contentPane.add(b4);
  }
  
  
 }
