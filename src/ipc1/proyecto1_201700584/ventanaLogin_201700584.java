
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ventanaLogin_201700584 {
    
    marcoLogin login = new marcoLogin();
    
    
    static String contra[] = new String[20];

    public ventanaLogin_201700584() {
        
        Users_201700584.User[0] = "admin";
        Users_201700584.Contra[0] = "admin";
        
    }
}

class marcoLogin extends JFrame{

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
                
                for(int n = 0; n < 20; n++){
                    if(comprobarUsuario.equals(Users_201700584.User[n])){//Recorre la matriz en busca del usuario si existe
                        JOptionPane.showMessageDialog(marcoLogin.this,/*clase padre donde se aloja el mensaje*/ 
                                "Usuario correcto", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        
                        if(comprobarContra.equals(Users_201700584.Contra[n])){//Matriz usuarios
                            JOptionPane.showMessageDialog(marcoLogin.this, "contraseña correcta", "Mensaje", 
                                    JOptionPane.INFORMATION_MESSAGE);
                            
                            principalAdmin_201700584 admin = new principalAdmin_201700584();
                            setVisible(false);
                            break;//Salir del for
                        }
                        else if(comprobarContra != Users_201700584.Contra[n]){
                            JOptionPane.showMessageDialog(marcoLogin.this, "El usuario y contraseña"
                                    + " no coinciden, por favor verifique su datos", "ERROR", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        break;
                    }
                    
                    
                    else if(comprobarUsuario != Users_201700584.Contra[n]){
                        JOptionPane.showMessageDialog(marcoLogin.this, "El usuario no existe, ponerse en"
                                + " contacto con el administrador para solicitar un registro", "USUARIO NO EXISTENTE", 2);
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
