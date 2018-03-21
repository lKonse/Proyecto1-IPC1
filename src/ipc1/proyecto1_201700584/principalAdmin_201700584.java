
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class principalAdmin_201700584 {
    
    marcoPrincipalAdmin admin = new marcoPrincipalAdmin();
    
    public principalAdmin_201700584(){
    
    }
     
}

class marcoPrincipalAdmin extends JFrame{
    public marcoPrincipalAdmin(){
        
        setBounds(325,125,700,500);
        setResizable(false);
        setTitle("ADMINISTRADOR");
        
        componentesAdmin componentes = new componentesAdmin();
        eventos e = new eventos();
        componentes.bCrearUsers.addActionListener(e);
        componentes.bModUsers.addActionListener(e);
        componentes.bDeleteUsers.addActionListener(e);
        componentes.bMostrarUsers.addActionListener(e);
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class eventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesAdmin.bCrearUsers){
                marcoCrearUsers crearUsers = new marcoCrearUsers();
            }
            else if(evento.getSource()==componentesAdmin.bModUsers){
                marcoModUsers modUsers = new marcoModUsers();               
            }
        }
    }
}

class componentesAdmin extends JPanel{
    
    static JButton bCrearUsers;
    static JButton bModUsers;
    static JButton bDeleteUsers;
    static JButton bMostrarUsers;
    
    static JButton bCrearBiblio;
    static JButton bModBiblio;
    static JButton bDeleteBiblio;
    static JButton bMostrarBiblio;
    
    static JButton bReporteUsers;
    static JButton bReporteBiblio;
    
    
    public componentesAdmin(){
        
        setLayout(null);
        
        bCrearUsers = new JButton("Crear");
        bCrearUsers.setBounds(new Rectangle(120,100,100,50));
        add(bCrearUsers);
        
        bModUsers = new JButton("Modificar");
        bModUsers.setBounds(new Rectangle(230,100,100,50));
        add(bModUsers);
        
        bDeleteUsers = new JButton("Eliminar");
        bDeleteUsers.setBounds(new Rectangle(340,100,100,50));
        add(bDeleteUsers);
        
        bMostrarUsers = new JButton("Mostrar");
        bMostrarUsers.setBounds(new Rectangle(450,100,100,50));
        add(bMostrarUsers);
        
        bCrearBiblio = new JButton("Crear");
        bCrearBiblio.setBounds(new Rectangle(120,235,100,50));
        add(bCrearBiblio);
        
        bModBiblio = new JButton("Modificar");
        bModBiblio.setBounds(new Rectangle(230,235,100,50));
        add(bModBiblio );
        
        bDeleteBiblio  = new JButton("Eliminar");
        bDeleteBiblio .setBounds(new Rectangle(340,235,100,50));
        add(bDeleteBiblio);
        
        bMostrarBiblio = new JButton("Mostrar");
        bMostrarBiblio.setBounds(new Rectangle(450,235,100,50));
        add(bMostrarBiblio);
        
        bReporteUsers = new JButton("Mostrar");
        bReporteUsers.setBounds(new Rectangle(120,375,100,50));
        add(bReporteUsers);
        
        bReporteBiblio = new JButton("Mostrar");
        bReporteBiblio.setBounds(new Rectangle(340,375,100,50));
        add(bReporteBiblio);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawString("USUARIOS", 100, 75);
        g.drawString("BIBLIOGRAFIA", 100, 220);
        g.drawString("REPORTES", 100, 350);
    }
}

