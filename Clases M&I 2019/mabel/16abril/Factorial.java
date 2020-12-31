import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Factorial extends JFrame implements ActionListener
{
    
    JButton bt1,bt2,bt3;
    JLabel lb1,lb2;
    JTextField tf1,tf2;
    
   
    
    public Factorial()
    { 
      
        super("Interfaz grafica1");
        Container contenedor = getContentPane();
        contenedor.setLayout( new FlowLayout() );
        setSize( 500, 500 );
        setVisible( true );
        lb1=new JLabel("Ingrese un entero:");
        tf1=new JTextField(10);
        lb2=new JLabel("El factorial es:");
        tf2=new JTextField(10);
        bt1=new JButton("Calcular");
        bt2=new JButton("Borrar");
        bt3=new JButton("Finalizar");
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(bt1);add(bt2);add(bt3);
        bt1.addActionListener(this);
      //bt1.setToolTipText("Tooltip del botón");
      //bt1.setToolTipText("Soy el boton 1");
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        tf2.setEditable(false);
 
     } 
       
    
    public void actionPerformed(ActionEvent event)
    {
 
      if(event.getSource()==bt1)
      {
        int x=Integer.parseInt(tf1.getText());   
        int fac=factorial(x);
        //tf2.setText(Integer.toString(fac));
        tf2.setText(fac+"");
      }
  
    if(event.getSource()==bt2)
       
    { tf1.setText("");
      tf2.setText("");
    } 
    
    if(event.getSource()==bt3)
       
    { System.exit(0);
      dispose();
    } 
    }        
     
    
    public static void main(String[] args)
    {
      Factorial obj=new Factorial();
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
    }
    public static int factorial(int n)
    {
       if (n==0)
         return 1;
       else
         return factorial(n-1)*n;
    }
    
    
}
