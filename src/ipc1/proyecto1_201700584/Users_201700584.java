
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Users_201700584{
    
    static String[] ID = new String[20];
    static String[] Nombre = new String[20]; 
    static String[] Apellido = new String[20]; 
    static String[] User = new String[20]; 
    static String[] Contra = new String[20];
    static String[] Rol = new String[20];
    
    public Users_201700584(){
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
                Users_201700584 h = new Users_201700584();
                
                for(int n = 0; n < 20; n++){
                    
                    guardarID = componentesUsers.tID.getText();
                    guardarUser = componentesUsers.tUser.getText();
                    guardarContra = componentesUsers.tContra.getText();
                    confirmContra = componentesUsers.tConfirmContra.getText();
                    
                    if(guardarID.equals(Users_201700584.ID[n])){
                        JOptionPane.showMessageDialog(marcoCrearUsers.this, "Ya existe un usuario con este ID", 
                                "ERROR", 2);
                        break;
                    }
                    else if(guardarUser.equals(Users_201700584.User[n])){
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
                
                
                    if(Users_201700584.ID[n] == null){
                        
                        Users_201700584.ID[n]=guardarID;
                        Users_201700584.Nombre[n]=guardarNombre;
                        Users_201700584.Apellido[n]=guardarApellido;
                        Users_201700584.User[n]=guardarUser;
                        Users_201700584.Contra[n]=guardarContra;
                        Users_201700584.Rol[n]=guardarRol;
                        
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
                    if(verID.equals(Users_201700584.ID[n])){
                        componentesUsers.tNombre.setText(Users_201700584.Nombre[n]);
                        componentesUsers.tApellido.setText(Users_201700584.Apellido[n]);
                        componentesUsers.tUser.setText(Users_201700584.User[n]);
                        componentesUsers.tContra.setText(Users_201700584.Contra[n]);
                        componentesUsers.txtRol.setText(Users_201700584.Rol[n]);
                        break;
                    }
                }
            }
            else if(evento.getSource()==componentesUsers.bOpcion){
                
                    guardarUser = componentesUsers.tUser.getText();
                    guardarContra = componentesUsers.tContra.getText();
                    confirmContra = componentesUsers.tConfirmContra.getText();
                
               for(int n = 1; n < 20; n++){
                   if(guardarUser.equals(Users_201700584.User[n])){
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
                
                
                    if(Users_201700584.ID[n].equals(guardarID)){
                        
                        Users_201700584.ID[n]=guardarID;
                        Users_201700584.Nombre[n]=guardarNombre;
                        Users_201700584.Apellido[n]=guardarApellido;
                        Users_201700584.User[n]=guardarUser;
                        Users_201700584.Contra[n]=guardarContra;
                        Users_201700584.Rol[n]=guardarRol;
                        
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
    static JPasswordField tContra;
    static JPasswordField tConfirmContra;
    
    
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
        
        tContra = new JPasswordField();
        tContra.setBounds(new Rectangle(220,250,150,25));
        add(tContra);
        
        tConfirmContra = new JPasswordField();
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
