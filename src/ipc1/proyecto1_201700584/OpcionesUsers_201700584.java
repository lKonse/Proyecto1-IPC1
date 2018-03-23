
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OpcionesUsers_201700584{ 
}

class matricesUsers{
    static String[] ID = new String[20];
    static String[] Nombre = new String[20]; 
    static String[] Apellido = new String[20]; 
    static String[] User = new String[20]; 
    static String[] Contra = new String[20];
    static String[] Rol = new String[20];
    
    public matricesUsers(){
        ID[0] = "admin";
        Nombre[0] = "admin";
        Apellido[0] = "admin";
        User[0] = "admin";
        Contra[0] = "admin";
        Rol[0] = "admin";
    }
}
//CREACION DE USUARIOS
class marcoCrearUsers extends JFrame{
    public marcoCrearUsers(){
        
        setBounds(325,125,700,475);
        setResizable(false);
        setTitle("ADMINISTRADOR");
        
        componentesUsers componentes = new componentesUsers();
        
        componentesUsers.bOpcion = new JButton("Crear");
        componentesUsers.bOpcion.setBounds(new Rectangle(500,125,100,50));
        
        componentesUsers.tContra = new JPasswordField();
        componentesUsers.tContra.setBounds(new Rectangle(220,250,150,25));
        add(componentesUsers.tContra);
        
        componentesUsers.tConfirmContra = new JPasswordField();
        componentesUsers.tConfirmContra.setBounds(new Rectangle(220,300,150,25));
        add(componentesUsers.tConfirmContra); 
        add(componentesUsers.bOpcion);
        
        eventosCrearUsers e = new eventosCrearUsers();
        componentesUsers.bOpcion.addActionListener(e);
        componentesUsers.bCancelar.addActionListener(e);
        componentesUsers.bRegresar.addActionListener(e);
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class eventosCrearUsers implements ActionListener{
        
        String guardarID, guardarNombre, guardarApellido, guardarUser, guardarContra, confirmContra, guardarRol;
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesUsers.bOpcion){
                matricesUsers h = new matricesUsers();
                
                for(int n = 0; n < 20; n++){
                    
                    guardarID = componentesUsers.tID.getText();
                    guardarUser = componentesUsers.tUser.getText();
                    guardarContra = componentesUsers.tContra.getText();
                    confirmContra = componentesUsers.tConfirmContra.getText();
                    
                    if(guardarID.equals(matricesUsers.ID[n])){
                        JOptionPane.showMessageDialog(marcoCrearUsers.this, "Ya existe un usuario con este ID", 
                                "ERROR", 2);
                        break;
                    }
                    else if(guardarUser.equals(matricesUsers.User[n])){
                        JOptionPane.showMessageDialog(marcoCrearUsers.this, "Nombre de usuario no disponible", 
                                "ERROR", 2);
                        break;
                    }
                    else if(!confirmContra.equals(guardarContra)){
                        JOptionPane.showMessageDialog(marcoCrearUsers.this, "Las confirmacion de contraseña"
                                + " no coincide", "Contraseña", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    
                    guardarNombre = componentesUsers.tNombre.getText();
                    guardarApellido = componentesUsers.tApellido.getText();
                    guardarRol = componentesUsers.tRol.getSelectedItem();
                
                //HASTA QUI PERRO
                    if(matricesUsers.ID[n] == null){
                        
                        matricesUsers.ID[n]=guardarID;
                        matricesUsers.Nombre[n]=guardarNombre;
                        matricesUsers.Apellido[n]=guardarApellido;
                        matricesUsers.User[n]=guardarUser;
                        matricesUsers.Contra[n]=guardarContra;
                        matricesUsers.Rol[n]=guardarRol;
                        
                        JOptionPane.showMessageDialog(marcoCrearUsers.this, "Usuario creado con exito", 
                                "Creacion usuario", JOptionPane.INFORMATION_MESSAGE);
                        
                        componentesUsers.tID.setText(null);
                        componentesUsers.tNombre.setText(null);
                        componentesUsers.tApellido.setText(null);
                        componentesUsers.tUser.setText(null);
                        componentesUsers.tContra.setText(null);
                        componentesUsers.tConfirmContra.setText(null);
                        
                        break;
                    }
                }
            }
            else if(evento.getSource()==componentesUsers.bCancelar){
                componentesUsers.tID.setText(null);
                componentesUsers.tNombre.setText(null);
                componentesUsers.tApellido.setText(null);
                componentesUsers.tUser.setText(null);
                componentesUsers.tContra.setText(null);
                componentesUsers.tConfirmContra.setText(null);
            }
            else if(evento.getSource()==componentesUsers.bRegresar){
                setVisible(false);
            }
        }
    }
}
//MODIFICAR USUARIOS
class marcoModUsers extends JFrame{
    public marcoModUsers(){
        setBounds(325,125,700,475);
        setResizable(false);
        setTitle("ADMINISTRADOR");
        
        componentesUsers componentes = new componentesUsers();
        
        componentesUsers.bOpcion = new JButton("Modificar");
        componentesUsers.bOpcion.setBounds(new Rectangle(500,125,100,50));
        add(componentesUsers.bOpcion);
        
        componentesUsers.bBuscar = new JButton("Buscar");
        componentesUsers.bBuscar.setBounds(new Rectangle(500,25,100,50));
        add(componentesUsers.bBuscar);
                
        componentesUsers.txtRol = new JTextField();
        componentesUsers.txtRol.setBounds(new Rectangle(220,350,150,25));
        add(componentesUsers.txtRol);
        
        eventosModUsers e = new eventosModUsers();
        componentesUsers.bOpcion.addActionListener(e);
        componentesUsers.bCancelar.addActionListener(e);
        componentesUsers.bRegresar.addActionListener(e);
        componentesUsers.bBuscar.addActionListener(e);
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class eventosModUsers implements ActionListener{
        
        String guardarID, guardarNombre, guardarApellido, guardarUser, guardarContra, confirmContra, guardarRol;
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesUsers.bBuscar){
                
                String verID = componentesUsers.tID.getText();
                
                for(int n = 1; n < 20; n++){
                    if(verID.equals(matricesUsers.ID[n])){
                        componentesUsers.tNombre.setText(matricesUsers.Nombre[n]);
                        componentesUsers.tApellido.setText(matricesUsers.Apellido[n]);
                        componentesUsers.tUser.setText(matricesUsers.User[n]);
                        componentesUsers.tContra.setText(matricesUsers.Contra[n]);
                        componentesUsers.txtRol.setText(matricesUsers.Rol[n]);
                        break;
                    }
                }
            }
            else if(evento.getSource()==componentesUsers.bOpcion){
                
                    guardarUser = componentesUsers.tUser.getText();
                    guardarContra = componentesUsers.tContra.getText();
                    confirmContra = componentesUsers.tConfirmContra.getText();
                
               for(int n = 1; n < 20; n++){
                   if(!guardarUser.equals(guardarUser) && guardarUser.equals(matricesUsers.User[n])){
                        JOptionPane.showMessageDialog(marcoModUsers.this, "Nombre de usuario no disponible", 
                                "ERROR", 2);
                        break;
                    }
                    else if(!confirmContra.equals(guardarContra)){
                        JOptionPane.showMessageDialog(marcoModUsers.this, "Las confirmacion de contraseña"
                                + " no coincide", "Contraseña", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                   
                    guardarNombre = componentesUsers.tNombre.getText();
                    guardarApellido = componentesUsers.tApellido.getText();
                    guardarRol = componentesUsers.tRol.getSelectedItem();
                    guardarID = componentesUsers.tID.getText();
                
                
                    if(matricesUsers.ID[n].equals(guardarID)){
                        
                        matricesUsers.ID[n]=guardarID;
                        matricesUsers.Nombre[n]=guardarNombre;
                        matricesUsers.Apellido[n]=guardarApellido;
                        matricesUsers.User[n]=guardarUser;
                        matricesUsers.Contra[n]=guardarContra;
                        matricesUsers.Rol[n]=guardarRol;
                        
                        JOptionPane.showMessageDialog(marcoModUsers.this, "Usuario modificado con exito", 
                                "Creacion usuario", JOptionPane.INFORMATION_MESSAGE);
                        
                        componentesUsers.tID.setText(null);
                        componentesUsers.tNombre.setText(null);
                        componentesUsers.tApellido.setText(null);
                        componentesUsers.tUser.setText(null);
                        componentesUsers.tContra.setText(null);
                        componentesUsers.tConfirmContra.setText(null);
                        componentesUsers.txtRol.setText(null);
                        
                        break;
                    }
               } 
            }
            else if(evento.getSource()==componentesUsers.bCancelar){
                componentesUsers.tID.setText(null);
                componentesUsers.tNombre.setText(null);
                componentesUsers.tApellido.setText(null);
                componentesUsers.tUser.setText(null);
                componentesUsers.tContra.setText(null);
                componentesUsers.tConfirmContra.setText(null);
                componentesUsers.txtRol.setText(null);
            }
            else if(evento.getSource()==componentesUsers.bRegresar){                
                setVisible(false);
            }
        }
    }
}
//ELIMINAR USUARIOS
class marcoDeleteUsers extends JFrame{
    public marcoDeleteUsers(){
        setBounds(325,125,700,475);
        setResizable(false);
        setTitle("ADMINISTRADOR");
        
        componentesUsers componentes = new componentesUsers();
        
        componentesUsers.bOpcion = new JButton("Eliminar");
        componentesUsers.bOpcion.setBounds(new Rectangle(500,125,100,50));
        add(componentesUsers.bOpcion);
        
        componentesUsers.bBuscar = new JButton("Buscar");
        componentesUsers.bBuscar.setBounds(new Rectangle(500,25,100,50));
        add(componentesUsers.bBuscar);
        
        componentesUsers.txtRol = new JTextField();
        componentesUsers.txtRol.setBounds(new Rectangle(220,350,150,25));
        add(componentesUsers.txtRol);
        
        componentesUsers.tNombre.setEditable(false);
        componentesUsers.tApellido.setEditable(false);
        componentesUsers.tUser.setEditable(false);
        componentesUsers.tContra.setEditable(false);
        componentesUsers.tConfirmContra.setEditable(false);
        componentesUsers.txtRol.setEditable(false);
        
        eventosModUsers e = new eventosModUsers();
        componentesUsers.bOpcion.addActionListener(e);
        componentesUsers.bCancelar.addActionListener(e);
        componentesUsers.bRegresar.addActionListener(e);
        componentesUsers.bBuscar.addActionListener(e);
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class eventosModUsers implements ActionListener{
        
        String guardarID;
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesUsers.bBuscar){
                
                guardarID = componentesUsers.tID.getText();
                
                for(int n = 1; n < 20; n++){
                    if(guardarID.equals(matricesUsers.ID[n])){
                        componentesUsers.tNombre.setText(matricesUsers.Nombre[n]);
                        componentesUsers.tApellido.setText(matricesUsers.Apellido[n]);
                        componentesUsers.tUser.setText(matricesUsers.User[n]);
                        componentesUsers.tContra.setText(matricesUsers.Contra[n]);
                        componentesUsers.txtRol.setText(matricesUsers.Rol[n]);
                        break;
                    }
                }
            }
            else if(evento.getSource()==componentesUsers.bOpcion){
                
                    guardarID = componentesUsers.tID.getText();
                
               for(int n = 1; n < 20; n++){
                   if(matricesUsers.ID[n] == null){
                        JOptionPane.showMessageDialog(marcoDeleteUsers.this, "ID no existente", 
                                "ERROR", 2);
                        break;
                    }

                   else if(guardarID.equals(matricesUsers.ID[n])){
                        
                        matricesUsers.ID[n]=null;
                        matricesUsers.Nombre[n]=null;
                        matricesUsers.Apellido[n]=null;
                        matricesUsers.User[n]=null;
                        matricesUsers.Contra[n]=null;
                        matricesUsers.Rol[n]=null;
                        
                        JOptionPane.showMessageDialog(marcoDeleteUsers.this, "Usuario eliminado con exito", 
                                "eliminar usuario", JOptionPane.INFORMATION_MESSAGE);
                        
                        componentesUsers.tID.setText(null);
                        componentesUsers.tNombre.setText(null);
                        componentesUsers.tApellido.setText(null);
                        componentesUsers.tUser.setText(null);
                        componentesUsers.tContra.setText(null);
                        componentesUsers.tConfirmContra.setText(null);
                        componentesUsers.txtRol.setText(null);
                        
                        break;
                    }
               } 
            }
            else if(evento.getSource()==componentesUsers.bCancelar){
                componentesUsers.tID.setText(null);
                componentesUsers.tNombre.setText(null);
                componentesUsers.tApellido.setText(null);
                componentesUsers.tUser.setText(null);
                componentesUsers.tContra.setText(null);
                componentesUsers.tConfirmContra.setText(null);
                componentesUsers.txtRol.setText(null);
            }
            else if(evento.getSource()==componentesUsers.bRegresar){
                setVisible(false);
            }
        }
    }
}

class marcoMostrarUsers extends JFrame{//TABLA
    
    public JTable tabla;
    private String[] nombreColumnas = {"No.","ID","Nombre","Apellido","Usuario","Contraseña", "Rol"};
    
    public marcoMostrarUsers(){

        setLayout(new FlowLayout());
        setResizable(false);
        setSize(750,475);
        setLocation(275,125);
        setTitle("ADMINISTRADOR");
        
        miTabla();
        
        componentesMostrar com = new componentesMostrar();
        eventosModUsers e = new eventosModUsers();
        componentesMostrar.bRegresar.addActionListener(e);
        add(componentesMostrar.bRegresar);
  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void miTabla(){
        
        int tamaño = 0;
        
            for(int i = 1; i < 20; i++){
                if(matricesUsers.ID[i] != null){
                    tamaño++;
                }
            }
        

        String[][] datos = new String[tamaño][7];
        
        for(int n = 0; n < tamaño; n++){
            
            datos[n][0] = String.valueOf(n+1);
            datos[n][1] = matricesUsers.ID[n+1];
            datos[n][2] = matricesUsers.Nombre[n+1];
            datos[n][3] = matricesUsers.Apellido[n+1];
            datos[n][4] = matricesUsers.User[n+1];
            datos[n][5] = matricesUsers.Contra[n+1];
            datos[n][6] = matricesUsers.Rol[n+1];
        }
        
        tabla = new JTable(datos, nombreColumnas);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(550,400));
        add(scroll);
    }
    private class eventosModUsers implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()== componentesMostrar.bRegresar){
                setVisible(false);
            }
        }
    }      
}
class componentesMostrar extends JPanel{
        static JButton bRegresar;
        public componentesMostrar(){
            bRegresar = new JButton("Regresar");
            bRegresar.setPreferredSize(new Dimension(100,50));
            
        }
    }

//Componenetes
class componentesUsers extends JPanel{
    
    static JButton bBuscar;
    static JButton bOpcion;
    static JButton bCancelar;
    static JButton bRegresar;

    static JTextField tID;
    static JTextField tNombre;
    static JTextField tApellido;
    static JTextField tUser;
    static Choice tRol;
    static JTextField txtRol;
    static JTextField tContra;
    static JTextField tConfirmContra;
    
    
    public componentesUsers(){
        
        setLayout(null);
        
        tID = new JTextField();
        tID.setBounds(new Rectangle(220,55,150,25));
        add(tID);
        
        tNombre = new JTextField();
        tNombre.setBounds(new Rectangle(220,100,150,25));
        add(tNombre);
        
        tApellido = new JTextField();
        tApellido.setBounds(new Rectangle(220,150,150,25));
        add(tApellido);
        
        tUser = new JTextField();
        tUser.setBounds(new Rectangle(220,200,150,25));
        add(tUser);
        
        tContra = new JTextField();
        tContra.setBounds(new Rectangle(220,250,150,25));
        add(tContra);
        
        tConfirmContra = new JTextField();
        tConfirmContra.setBounds(new Rectangle(220,300,150,25));
        add(tConfirmContra);
        
        tRol = new Choice();
        tRol.add("Catedratico");
        tRol.add("Estudiante");
        tRol.setBounds(new Rectangle(220,350,150,25));
        add(tRol);
    
        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(new Rectangle(500,220,100,50));
        add(bCancelar);
        
        bRegresar = new JButton("Regresar");
        bRegresar.setBounds(new Rectangle(500,320,100,50));
        add(bRegresar);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawString("ID:", 60, 70);
        g.drawString("Nombre:", 60, 120);
        g.drawString("Apellido:", 60, 170);
        g.drawString("User:", 60, 220);
        g.drawString("Contraseña:", 60, 270);
        g.drawString("Confirmar Contraseña:", 60, 320);
        g.drawString("Rol:", 60, 370);
    }
}
