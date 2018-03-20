
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class claseprincipal_201700584 {
    
    public static void main(String[] args) {
        
        marcoPrincipal marco = new marcoPrincipal();
    
    }
    
}

class marcoPrincipal extends JFrame{
    
    marcoPrincipalComponentes componentes;
    
    public marcoPrincipal(){
        
        setBounds(275,125,800,500);
        setTitle("IPC PROYECTO 1");
        setResizable(false);       
        
        componentes = new marcoPrincipalComponentes(); 
        eventos e = new eventos();
        componentes.BotonLogin.addActionListener(e);
 
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class eventos implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentes.BotonLogin){
                ventanaLogin_201700584 login = new ventanaLogin_201700584();
                setVisible(false);
            }
        }
    }
}

class marcoPrincipalComponentes extends JPanel{
    
    static JButton BotonLogin;
    static JButton BotonLogout;
    
    public marcoPrincipalComponentes(){
        setLayout(null);
        
        setBackground(Color.LIGHT_GRAY);
        
        
        BotonLogin = new JButton("Login");
        BotonLogin.setBounds(new Rectangle(500,30, 100, 50));
        add(BotonLogin);
        
        BotonLogout = new JButton("Logout");
        BotonLogout.setBounds(new Rectangle(625,30,100,50));
        add(BotonLogout);
    }
    
}


