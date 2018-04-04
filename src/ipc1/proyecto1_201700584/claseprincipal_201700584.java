
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class claseprincipal_201700584 {
    
    public static void main(String[] args) {
        
//        marcoPrincipal marco = new marcoPrincipal();
        marcoPrincipalUsuario user = new marcoPrincipalUsuario();
//        bibliotecaVirtual vir = new bibliotecaVirtual();
//        marcoPrincipalAdmin admin = new marcoPrincipalAdmin();
//        marcoCrearUsers CrearUsers = new marcoCrearUsers();
//        mostrarLibroVirtual b = new mostrarLibroVirtual();
    
    }
    
}

class marcoPrincipal extends JFrame{
    public marcoPrincipal(){
        
        setBounds(275,125,800,500);
        setTitle("IPC PROYECTO 1");
        setResizable(false);       
        
        marcoPrincipalComponentes componentes = new marcoPrincipalComponentes(); 
        eventos e = new eventos();//Llamamos a la clase eventos
        componentes.BotonLogin.addActionListener(e);//Pedimos que el boton Login este a la escucha de la acción
        componentes.BotonLogout.addActionListener(e);
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //eventos de los botones, los creamos aqui para no tener que llamar al JFrame de nuevo
    private class eventos implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==marcoPrincipalComponentes.BotonLogin){
                ventanaLogin login = new ventanaLogin();
                setVisible(false);   
            }
            else if(evento.getSource()==marcoPrincipalComponentes.BotonLogout){
                System.exit(0);
            }
        }
    }
}

class marcoPrincipalComponentes extends JPanel{
    
    static JButton BotonLogin;
    static JButton BotonLogout;
    private Image imagen1;
    
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

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File ubicacion = new File("src/imagenes/usacLogo.png");
        
        try{
        imagen1 = ImageIO.read(ubicacion);
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(marcoPrincipalComponentes.this, 
                    "La imagen no se encuentra", "ERROR", 0);//JOptionPane.ERROR_MESSAGE
        }
        
        g.drawImage(imagen1, 50, 150, 650, 225, null);
    }
}

class ventanaLogin {
    
    marcoLogin login = new marcoLogin();
    
    
    static String contra[] = new String[20];

    public ventanaLogin() {
        
        matricesUsers.User[0] = "admin";
        matricesUsers.Contra[0] = "admin";
        
    }
}

class marcoLogin extends JFrame{
    
    static String usuarioDentro;
    
    public marcoLogin(){
        setBounds(500,175,350,400);
        setTitle("Login");
        setResizable(false);
        
        componentesLogin componentes = new componentesLogin();
        eventos e = new eventos();
        componentes.bIngresar.addActionListener(e);//Boton ingresar estar a la escucha de la accion
        componentes.bCancelar.addActionListener(e);//Boton cancelar estar a la escucha de la accion   
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //eventos de los botones
    private class eventos implements ActionListener{
        String comprobarUsuario;
        String comprobarContra;
        
            
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()== componentesLogin.bIngresar){
                
                comprobarUsuario = componentesLogin.tUser.getText();
                comprobarContra = componentesLogin.tContraseña.getText();
                
                for(int n = 0; n < 19; n++){
                    if(comprobarUsuario.equals(matricesUsers.User[n])){//Recorre la matriz en busca del usuario si existe
                        if(comprobarContra.equals(matricesUsers.Contra[n])){//Matriz usuarios
                            if(comprobarUsuario.equals("admin") && comprobarContra.equals("admin")){
                                marcoPrincipalAdmin admin = new marcoPrincipalAdmin();
                                setVisible(false);
                                break;//Salir del for
                            }
                               
                        }
                        else if(comprobarContra != matricesUsers.Contra[n]){
                            JOptionPane.showMessageDialog(marcoLogin.this, "El usuario y contraseña"
                                    + " no coinciden, por favor verifique su datos", "ERROR", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        break;
                    }
                    else if(comprobarUsuario != matricesUsers.User[n]){
                        int t=0;//Usado para verificar si no se existe el usuario
                        for(int m = 1; m < 20; m++){
                            if(comprobarUsuario.equals(matricesUsers.User[m])){
                                if(comprobarContra.equals(matricesUsers.Contra[m])){
                                    usuarioDentro = matricesUsers.User[m];
                                    marcoPrincipalUsuario usuario = new marcoPrincipalUsuario();
                                    setVisible(false);
                                    t = 1;
                                    break;
                                }
                                else{
                                    JOptionPane.showMessageDialog(marcoLogin.this, "El usuario y contraseña"
                                    + " no coinciden, por favor verifique su datos", "ERROR", JOptionPane.WARNING_MESSAGE);
                                    t = 1;
                                    break;
                                }
                            }  
                        }
                        if(t == 0){
                            JOptionPane.showMessageDialog(marcoLogin.this, "El usuario no existe, ponerse en"
                                + " contacto con el administrador para solicitar un registro", "USUARIO NO EXISTENTE", 2);
                        }
                        
                        break;
                    }
                }   
            }
            else if(evento.getSource()==componentesLogin.bCancelar){
                componentesLogin.tUser.setText(null);
                componentesLogin.tContraseña.setText(null);
            }
        }
    }
}

class componentesLogin extends JPanel{
    
    static JButton bIngresar;
    static JButton bCancelar;
    
    static JTextField tUser;
    static JPasswordField tContraseña;//Cuadro de texto de contraseñas
    
    public componentesLogin(){
        
        setLayout(null);
        
        tUser = new JTextField();
        tUser.setBounds(new Rectangle(80,60,150,25));
        add(tUser);
        
        tContraseña = new JPasswordField();
        tContraseña.setBounds(new Rectangle(80,135,150,25));
        add(tContraseña);
        
        bIngresar = new JButton("INGRESAR");
        bIngresar.setBounds(new Rectangle(45,200,100,50));
        add(bIngresar);
        
        bCancelar = new JButton("CANCELAR");
        bCancelar.setBounds(new Rectangle(170,200,100,50));
        add(bCancelar);
    }
    
    //Textos, imagenes, etc
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawString("Usuario:", 45, 45);
        g.drawString("Contraseña", 45, 120);
    }
}


