
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class principalUsuario_201700584 {
    public principalUsuario_201700584(){
        System.out.println("Hola");
    }
}

class marcoPrincipalUsuario extends JFrame{
    
    
    public marcoPrincipalUsuario(){
        
        setBounds(375,125,700,500);
        setResizable(false);
        setTitle("USUARIO");
        
        componentesUser componentes = new componentesUser();
        eventosPrincipalUsuario e = new eventosPrincipalUsuario();
        
        for(int n = 0; n < componentesUser.boton.length; n++){
            componentesUser.boton[n].addActionListener(e);
        }
         
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private class eventosPrincipalUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
           if(evento.getSource() == (componentesUser.boton[0])){
               setVisible(false);
               bibliotecaVirtual Virtual = new bibliotecaVirtual();
           }
           else if(evento.getSource() == (componentesUser.boton[1])){
               
           }
           else if(evento.getSource() == (componentesUser.boton[2])){
               setVisible(false);
               marcoPrincipal principal = new marcoPrincipal();
           }
        }
    }
}

class componentesUser extends JPanel{
    
    static JButton[] boton = new JButton[3];
    
    public componentesUser(){
        
        setLayout(null);
        
        boton[0] = new JButton("Biblioteca virtual");
        boton[0].setBounds(new Rectangle(75, 150, 200, 50));
        add(boton[0]);
        
        boton[1] = new JButton("Prestamo de Libro");
        boton[1].setBounds(new Rectangle(75, 225, 200, 50));
        add(boton[1]);
        
        boton[2] = new JButton("Logout");
        boton[2].setBounds(new Rectangle(75, 300, 200, 50));
        add(boton[2]);
    }
}

//BIBLIOTECA VIRTUAL
class bibliotecaVirtual extends JFrame{
    
    static JTable tabla;
    TableRowSorter trs;

    public bibliotecaVirtual(){
        setTitle("Usuario");
        setBounds(175,75,1000,600);
        setResizable(false);
        
        miTabla();
        
        componentesBiblioVirtual componentes = new componentesBiblioVirtual();
        eventosBiblioVirtualUsuario e = new eventosBiblioVirtualUsuario();
        
        for(int n = 0; n < componentesBiblioVirtual.boton.length; n++){
            componentesBiblioVirtual.boton[n].addActionListener(e);
        }
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class eventosBiblioVirtualUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
           if(evento.getSource() == (componentesBiblioVirtual.boton[0])){
               setVisible(false);
               marcoPrincipal principal = new marcoPrincipal();
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[1])){
               setVisible(false);
               marcoPrincipalUsuario usuario = new marcoPrincipalUsuario();
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[2])){
               
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[3])){
               
           }
        }
    }
    
    public void miTabla(){
             
        String[] nombreColumnas = {"No.","Tipo","Titulo","Autor","Año de Publicacion",
            "Descripcion", "Palabras clave","Edicion","Temas","Copias","ISBN","Ejemplares","Area","Agregar"};
        
        int tamaño = 0;
        
            for(int i = 0; i < 30; i++){
                if(matricesBiblio.Tipo[i] != null){
                    tamaño++;
                }
            }
        

        String[][] datos = new String[tamaño][14];
        
        for(int n = 0; n < tamaño; n++){
            if(matricesBiblio.Tipo[n].equals("Libro Virtual")){
                datos[n][0] = String.valueOf(n+1);
                datos[n][1] = matricesBiblio.Tipo[n];
                datos[n][2] = matricesBiblio.Titulo[n];
                datos[n][3] = matricesBiblio.Autor[n];
                datos[n][4] = matricesBiblio.Año[n];
                datos[n][5] = matricesBiblio.Descripcion[n];
                datos[n][6] = matricesBiblio.Palabras[n][0];
                datos[n][7] = String.valueOf(matricesBiblio.Edicion[n]);
                datos[n][8] = matricesBiblio.Temas[n][0];
                datos[n][9] = String.valueOf(matricesBiblio.Copias[n]);
                datos[n][10] = String.valueOf(matricesBiblio.ISBN[n]);
                datos[n][11] = matricesBiblio.Ejemplares[n];
                datos[n][12] = matricesBiblio.Area[n];
                datos[n][13] = "+";
            }
        }
        
        tabla = new JTable(datos, nombreColumnas);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(25,250,950,300);
        add(scroll);
        
        
    }
}
class componentesBiblioVirtual extends JPanel{
    
    static JButton[] boton = new JButton[4];
    
    public componentesBiblioVirtual(){
        
        setLayout(null);
        
        boton[0] = new JButton("Logout");
        boton[0].setBounds(new Rectangle(850, 25, 100, 50));
        add(boton[0]);
        
        boton[1] = new JButton("Regresar");
        boton[1].setBounds(new Rectangle(850, 90, 100, 50));
        add(boton[1]);
        
        boton[2] = new JButton("Ver biblioteca virtual");
        boton[2].setBounds(new Rectangle(750, 175, 200, 50));
        add(boton[2]);
        
        boton[3] = new JButton("Buscar");
        boton[3].setBounds(new Rectangle(75, 175, 200, 50));
        add(boton[3]);
        
    }
}
