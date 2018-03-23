
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class principalAdmin_201700584 {    
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
        componentes.bLogout.addActionListener(e);
        componentes.bCrearBiblio.addActionListener(e);
        componentes.bModBiblio.addActionListener(e);
        componentes.bDeleteBiblio.addActionListener(e);
        componentes.bMostrarBiblio.addActionListener(e);
        
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
            else if(evento.getSource()==componentesAdmin.bDeleteUsers){
                marcoDeleteUsers DeleteUsers = new marcoDeleteUsers();
                
            }
            else if(evento.getSource()==componentesAdmin.bMostrarUsers){
                marcoMostrarUsers DeleteUsers = new marcoMostrarUsers();  
            }
            else if(evento.getSource()==componentesAdmin.bLogout){
                marcoPrincipal principal = new marcoPrincipal();
                setVisible(false);
            }
            else if(evento.getSource()==componentesAdmin.bCrearBiblio){
                marcoCrearBiblio crearBiblio = new marcoCrearBiblio();
            }
            else if(evento.getSource()==componentesAdmin.bModBiblio){
                marcoModBiblio ModificarBiblio = new marcoModBiblio();
            }
            else if(evento.getSource()==componentesAdmin.bDeleteBiblio){
                marcoDeleteBiblio DeleteBiblio = new marcoDeleteBiblio();
            }
            else if(evento.getSource()==componentesAdmin.bMostrarBiblio){
                marcoMostrarBiblio DeleteBiblio = new marcoMostrarBiblio();  
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
    
    static JButton bLogout;
       
    public componentesAdmin(){
        
        setLayout(null);
        
        bCrearUsers = new JButton("Crear");
        bCrearUsers.setBounds(new Rectangle(80,100,100,50));
        add(bCrearUsers);
        
        bModUsers = new JButton("Modificar");
        bModUsers.setBounds(new Rectangle(190,100,100,50));
        add(bModUsers);
        
        bDeleteUsers = new JButton("Eliminar");
        bDeleteUsers.setBounds(new Rectangle(300,100,100,50));
        add(bDeleteUsers);
        
        bMostrarUsers = new JButton("Mostrar");
        bMostrarUsers.setBounds(new Rectangle(410,100,100,50));
        add(bMostrarUsers);
        
        bCrearBiblio = new JButton("Crear");
        bCrearBiblio.setBounds(new Rectangle(80,235,100,50));
        add(bCrearBiblio);
        
        bModBiblio = new JButton("Modificar");
        bModBiblio.setBounds(new Rectangle(190,235,100,50));
        add(bModBiblio );
        
        bDeleteBiblio  = new JButton("Eliminar");
        bDeleteBiblio .setBounds(new Rectangle(300,235,100,50));
        add(bDeleteBiblio);
        
        bMostrarBiblio = new JButton("Mostrar");
        bMostrarBiblio.setBounds(new Rectangle(410,235,100,50));
        add(bMostrarBiblio);
        
        bReporteUsers = new JButton("Reporte Usuarios");
        bReporteUsers.setBounds(new Rectangle(80,375,135,50));
        add(bReporteUsers);
        
        bReporteBiblio = new JButton("Reporte Bibliografias");
        bReporteBiblio.setBounds(new Rectangle(230,375,160,50));
        add(bReporteBiblio);
        
        bLogout = new JButton("Logout");
        bLogout.setBounds(new Rectangle(560,25,100,50));
        add(bLogout);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawString("USUARIOS", 60, 75);
        g.drawString("BIBLIOGRAFIA", 60, 220);
        g.drawString("REPORTES", 60, 350);
    }
}

