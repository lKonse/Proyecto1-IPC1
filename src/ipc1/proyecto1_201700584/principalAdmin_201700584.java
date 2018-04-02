
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class principalAdmin_201700584 {    
}

class marcoPrincipalAdmin extends JFrame{
    public marcoPrincipalAdmin(){
        
        setBounds(325,125,700,500);
        setResizable(false);
        setTitle("ADMINISTRADOR");
        
        componentesAdmin componentes = new componentesAdmin();
        eventos e = new eventos();
        for(int n = 0; n<componentesAdmin.boton.length; n++){
            componentes.boton[n].addActionListener(e);
        }
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class eventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesAdmin.boton[0]){
                marcoCrearUsers crearUsers = new marcoCrearUsers();
                
            }
            else if(evento.getSource()==componentesAdmin.boton[1]){
                marcoModUsers modUsers = new marcoModUsers();
                
            }
            else if(evento.getSource()==componentesAdmin.boton[2]){
                marcoDeleteUsers DeleteUsers = new marcoDeleteUsers();
                
            }
            else if(evento.getSource()==componentesAdmin.boton[3]){
                marcoMostrarUsers DeleteUsers = new marcoMostrarUsers();  
            }
            else if(evento.getSource()==componentesAdmin.boton[11]){
                marcoPrincipal principal = new marcoPrincipal();
                setVisible(false);
            }
            else if(evento.getSource()==componentesAdmin.boton[4]){
                marcoCrearBiblio crearBiblio = new marcoCrearBiblio();
            }
            else if(evento.getSource()==componentesAdmin.boton[5]){
                marcoCargaMasiva cargaMasiva = new marcoCargaMasiva();
            }
            else if(evento.getSource()==componentesAdmin.boton[6]){
                marcoModBiblio ModificarBiblio = new marcoModBiblio();
            }
            else if(evento.getSource()==componentesAdmin.boton[7]){
                marcoDeleteBiblio DeleteBiblio = new marcoDeleteBiblio();
            }
            else if(evento.getSource()==componentesAdmin.boton[8]){
                marcoMostrarBiblio DeleteBiblio = new marcoMostrarBiblio();  
            }
            else if(evento.getSource()==componentesAdmin.boton[9]){
                System.out.println("Reporte Usuarios");
                
                String texto = "YA LLEGUE";
                
                FileWriter Archivo = null;
                PrintWriter imprimir = null;
                
                try{
                    Archivo = new FileWriter("ReporteUsuarios.html");//Crear el archivo
                }catch(IOException e){
                    JOptionPane.showMessageDialog(marcoPrincipalAdmin.this, "No se logro crear el reporte","ERROR",0);
                }
                
                imprimir = new PrintWriter(Archivo);//Crear un impresor para el HTML
                
                imprimir.println("<HTML>");
                imprimir.println("<head><title>REPORTE USUARIOS</title></head>");
                imprimir.println("<body>");
                
                for(int n = 1; n < 10; n++){
                    imprimir.println("<center><h1>"+matricesUsers.Nombre[n]+"</h1></center>");
                }
                  
                imprimir.println("</body>");
                imprimir.println("</HTML>");
                
                imprimir.close();//SIEMPRE CERRAR EL IMPRESOR
                
            }
            else if(evento.getSource()==componentesAdmin.boton[10]){
                System.out.println("Reporte Biblio");    
            }
        }
    }
}

class componentesAdmin extends JPanel{
    
    static JButton[] boton = new JButton[12];
    
    private Image[] imagen = new Image[2];
       
    public componentesAdmin(){
        
        setLayout(null);
        
        boton[0] = new JButton("Crear");
        boton[0].setBounds(new Rectangle(80,100,100,50));
        add(boton[0]);
        
        boton[1] = new JButton("Modificar");
        boton[1].setBounds(new Rectangle(190,100,100,50));
        add(boton[1]);
        
        boton[2] = new JButton("Eliminar");
        boton[2].setBounds(new Rectangle(300,100,100,50));
        add(boton[2]);
        
        boton[3] = new JButton("Mostrar");
        boton[3].setBounds(new Rectangle(410,100,100,50));
        add(boton[3]);
        
        boton[4] = new JButton("Carga individual");
        boton[4].setBounds(new Rectangle(80,235,125,25));
        add(boton[4]);
        
        boton[5] = new JButton("Carga masiva");
        boton[5].setBounds(new Rectangle(80,260,125,25));
        add(boton[5]);
        
        boton[6] = new JButton("Modificar");
        boton[6].setBounds(new Rectangle(215,235,100,50));
        add(boton[6]);
        
        boton[7] = new JButton("Eliminar");
        boton[7].setBounds(new Rectangle(325,235,100,50));
        add(boton[7]);
        
        boton[8] = new JButton("Mostrar");
        boton[8].setBounds(new Rectangle(435,235,100,50));
        add(boton[8]);
        
        boton[9] = new JButton("Reporte Usuarios");
        boton[9].setBounds(new Rectangle(80,375,135,50));
        add(boton[9]);
        
        boton[10] = new JButton("Reporte Bibliografias");
        boton[10].setBounds(new Rectangle(230,375,160,50));
        add(boton[10]);
        
        boton[11] = new JButton("Logout");
        boton[11].setBounds(new Rectangle(560,25,100,50));
        add(boton[11]);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File ubicacion[] = new File[2];
        ubicacion[0] = new File("src/imagenes/usacLogo2.png");
        ubicacion[1] = new File("src/imagenes/fondoAqua.png");
        
        try{
            imagen[1] = ImageIO.read(ubicacion[1]);
            imagen[0] = ImageIO.read(ubicacion[0]);
        }catch(IOException e){
            JOptionPane.showMessageDialog(componentesAdmin.this, 
                    "No se encontro la imagen", "ERROR", 0);
        }
        
        g.drawImage(imagen[1], 0, 0, 700, 500, null);
        g.drawImage(imagen[0], 500, 300, 150, 150, null);
        
        g.drawString("USUARIOS", 60, 75);
        g.drawString("BIBLIOGRAFIA", 60, 220);
        g.drawString("REPORTES", 60, 350);
        
        
        
    }
}

