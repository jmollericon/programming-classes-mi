import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import javax.swing.*;

public class password1 extends JFrame implements ActionListener{
protected int i=1;
 JLabel userLabel = new JLabel("User");
 JTextField userText = new JTextField(20);
 JLabel passwordLabel = new JLabel("Password");
 JPasswordField passwordText = new JPasswordField(20);
 JButton b1 = new JButton("Login");
 JButton b2 = new JButton("Cancel");


 public password1()
 {
   super("ACCESO AL SISTEMA");
  setSize(300, 150);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLayout(null);
  JLabel userLabel = new JLabel("User");
  userLabel.setBounds(10, 10, 80, 25);
  add(userLabel);
  userText.setBounds(100, 10, 160, 25);
  add(userText);
  passwordLabel.setBounds(10, 40, 80, 25);
  add(passwordLabel);
  passwordText.setBounds(100, 40, 160, 25);
  add(passwordText);
  b1.setBounds(10, 80, 80, 25);
  add(b1);
  b2.setBounds(180, 80, 80, 25);
  add(b2);
  pack();
  b1.addActionListener(this);
  b2.addActionListener(this);
  }
 
 public void actionPerformed(ActionEvent e)
   {
  try {
 System.out.println(i);
   
 boolean flag=false;
     if (e.getSource()==b1)
     {
      
      if(i<=3) { 
      BufferedReader in=new BufferedReader(new FileReader("login.txt"));
       String nom;
   for(;(nom=in.readLine())!=null;){
    String fac[]= nom.split(";");
    if (fac[0].equals(userText.getText())) 
              {
                  
               String myPass=String.valueOf(passwordText.getPassword());
               if (fac[1].equals(myPass))
                  {
                   JOptionPane.showMessageDialog(null,"Acceso permitido");
                   Frame frame = new Frame();
                   flag=true;
                  }  
              }
   }
            if (!flag) {
             JOptionPane.showMessageDialog(null,"Error....quedan "+(4-i)+" intento(s)");
             i++;}
      in.close();
     }
      else {
       JOptionPane.showMessageDialog(null, "Acceso Bloqueado");
    System.exit(0); 
   }  
     }
     if (e.getSource()==b2)
     {
          
      System.exit(0);
     }
   
  }
  catch(Exception ev){
   JOptionPane.showMessageDialog(null, "error"+ev);
 }
   }
  public static void main(String[] args) throws IOException{
   
   password1 x=new password1();
   x.setBounds(10,10,300,175);
   x.setVisible(true);
   x.setLocationRelativeTo(null);
 }
   
 }

