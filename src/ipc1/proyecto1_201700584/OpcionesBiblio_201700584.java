
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpcionesBiblio_201700584 {  
}

class matricesBiblio{
    static Object[] Tipo = new Object[30];
    static String[] Autor = new String[30]; 
    static String[] Titulo = new String[30];
    static String[] Año = new String[30]; 
    static String[] Descripcion = new String[30]; 
    static String[][] Palabras = new String[30][10];
    static int[] Edicion = new int[30];
    static String[][] Temas = new String[30][30];
    static int[] Copias = new int[30];
    static int[] ISBN = new int[30];
    static String[] Ejemplares = new String[30];
    static String[] Area = new String[30];
    
    public matricesBiblio(){
        for(int n = 0; n < 30; n++){
            Copias[n] = 0;
            Edicion[n]=0;
            ISBN[n]=0;
        }
    }
}

class marcoCrearBiblio extends marcoBiblio{
    public marcoCrearBiblio(){        
        
        componentesBiblio componentes = new componentesBiblio();
        
        componentesBiblio.bOpcion = new JButton("Cargar");
        componentesBiblio.bOpcion.setBounds(new Rectangle(500,125,100,50));
        add(componentesBiblio.bOpcion);
        
        eventosCrearBiblio e = new eventosCrearBiblio();
        componentesBiblio.tTipo.addActionListener(e);
        componentesBiblio.bOpcion.addActionListener(e);
        componentesBiblio.bCancelar.addActionListener(e);
        componentesBiblio.bRegresar.addActionListener(e);
        
        add(componentes);
    }
    
    private class eventosCrearBiblio implements ActionListener{
        
        String gAutor,gAño,gDescripcion,gPalabras,gTemas,gEjemplares,gArea,gTitulo;
        int gEdicion,gCopias,gISBN;
        Object gTipo;
        
        
        @Override
        public void actionPerformed(ActionEvent evento){
            //COMBO BOX
            int opcion = componentesBiblio.tTipo.getSelectedIndex();//Tomar la posicon que se selecciono
            
            switch (opcion){
                case 1:
                    componentesBiblio.tISBN.setEditable(true);
                    componentesBiblio.tCopias.setEditable(true);
                    componentesBiblio.tEjemplares.setEditable(false);
                    componentesBiblio.tArea.setEditable(false);
                    break;
                case 2:
                    componentesBiblio.tISBN.setEditable(false);
                    componentesBiblio.tCopias.setEditable(true);
                    componentesBiblio.tEjemplares.setEditable(true);
                    componentesBiblio.tArea.setEditable(false);
                    break;
                case 3:
                    componentesBiblio.tISBN.setEditable(false);
                    componentesBiblio.tCopias.setEditable(true);
                    componentesBiblio.tEjemplares.setEditable(false);
                    componentesBiblio.tArea.setEditable(true);
                    break;
                case 4:
                    componentesBiblio.tEjemplares.setEditable(false);
                    componentesBiblio.tArea.setEditable(false);
                    componentesBiblio.tISBN.setEditable(false);
                    componentesBiblio.tCopias.setEditable(false);
                    break;
                default:
                    break;
            }
            
            //BOTONES
            if(evento.getSource()==componentesBiblio.bOpcion){
                matricesBiblio h = new matricesBiblio();//Llamar a las matrices
                
                gTipo = componentesBiblio.tTipo.getSelectedItem();
                gTitulo = componentesBiblio.tTitulo.getText();
                gAutor = componentesBiblio.tAutor.getText();                         
                gAño = componentesBiblio.tAño.getText();
                gDescripcion = componentesBiblio.tDescripcion.getText();
                gPalabras = componentesBiblio.tPalabras.getText();
                gTemas = componentesBiblio.tTemas.getText();
                gEdicion = Integer.parseInt(componentesBiblio.tEdicion.getText());
                 
                
                for(int n = 0; n < 30; n++){
                    
                    if(opcion == 1){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gISBN = Integer.parseInt(componentesBiblio.tISBN.getText());
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.ISBN[m] = gISBN;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.ISBN[n] = gISBN;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Libro guardado con exito", "Carga exitosa", 1);
//                            System.out.println(matricesBiblio.Tipo[n]);
//                            System.out.println("Titulo "+matricesBiblio.Titulo[n]);
//                            System.out.println("Autor: "+matricesBiblio.Autor[n]);
//                            System.out.println("Año: "+matricesBiblio.Año[n]);
//                            System.out.println("Descripcion: "+matricesBiblio.Descripcion[n]);
//                            System.out.println("Palabras clave: "+matricesBiblio.Palabras[n][0]);
//                            System.out.println("Edicion: "+matricesBiblio.Edicion[n]);
//                            System.out.println("Temas: "+matricesBiblio.Temas[n][0]);
//                            System.out.println("Copias: "+matricesBiblio.Copias[n]);
//                            System.out.println("ISBN: "+matricesBiblio.ISBN[n]);
//                            System.out.println();
                            break;
                        }
                    }
                    if(opcion == 2){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gEjemplares = componentesBiblio.tEjemplares.getText(); 
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.Ejemplares[m] = gEjemplares;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Ejemplares[n] = gEjemplares;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Revista guardada con exito", "Carga exitosa", 1);
//                            System.out.println(matricesBiblio.Tipo[n]);
//                            System.out.println("Titulo "+matricesBiblio.Titulo[n]);
//                            System.out.println("Autor: "+matricesBiblio.Autor[n]);
//                            System.out.println("Año: "+matricesBiblio.Año[n]);
//                            System.out.println("Descripcion: "+matricesBiblio.Descripcion[n]);
//                            System.out.println("Palabras clave: "+matricesBiblio.Palabras[n][0]);
//                            System.out.println("Edicion: "+matricesBiblio.Edicion[n]);
//                            System.out.println("Temas: "+matricesBiblio.Temas[n][0]);
//                            System.out.println("Copias: "+matricesBiblio.Copias[n]);
//                            System.out.println("ISBN: "+matricesBiblio.ISBN[n]);
//                            System.out.println();
                            break;
                        }
                    }
                    else if(opcion == 3){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gArea = componentesBiblio.tArea.getText();
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.Area[m] = gArea;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Area[n] = gArea;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Tesis guardada con exito", "Carga exitosa", 1);
//                            System.out.println(matricesBiblio.Tipo[n]);
//                            System.out.println("Titulo "+matricesBiblio.Titulo[n]);
//                            System.out.println("Autor: "+matricesBiblio.Autor[n]);
//                            System.out.println("Año: "+matricesBiblio.Año[n]);
//                            System.out.println("Descripcion: "+matricesBiblio.Descripcion[n]);
//                            System.out.println("Palabras clave: "+matricesBiblio.Palabras[n][0]);
//                            System.out.println("Edicion: "+matricesBiblio.Edicion[n]);
//                            System.out.println("Temas: "+matricesBiblio.Temas[n][0]);
//                            System.out.println("Copias: "+matricesBiblio.Copias[n]);
//                            System.out.println("ISBN: "+matricesBiblio.ISBN[n]);
//                            System.out.println();
                            break;
                        }
                    }
                    else if(opcion == 4){
                        if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Libro virtual guardado con exito", "Carga exitosa", 1);
//                            System.out.println(matricesBiblio.Tipo[n]);
//                            System.out.println("Titulo "+matricesBiblio.Titulo[n]);
//                            System.out.println("Autor: "+matricesBiblio.Autor[n]);
//                            System.out.println("Año: "+matricesBiblio.Año[n]);
//                            System.out.println("Descripcion: "+matricesBiblio.Descripcion[n]);
//                            System.out.println("Palabras clave: "+matricesBiblio.Palabras[n][0]);
//                            System.out.println("Edicion: "+matricesBiblio.Edicion[n]);
//                            System.out.println("Temas: "+matricesBiblio.Temas[n][0]);
//                            System.out.println("Copias: "+matricesBiblio.Copias[n]);
//                            System.out.println("ISBN: "+matricesBiblio.ISBN[n]);
//                            System.out.println();
                            break;
                        }
                    }
                }
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                componentesBiblio.tTitulo.setText(null);
                componentesBiblio.tAutor.setText(null);
                componentesBiblio.tAño.setText(null);
                componentesBiblio.tDescripcion.setText(null);
                componentesBiblio.tPalabras.setText(null);
                componentesBiblio.tEdicion.setText(null);
                componentesBiblio.tTemas.setText(null);
                componentesBiblio.tCopias.setText(null);
                componentesBiblio.tISBN.setText(null);
                componentesBiblio.tEjemplares.setText(null);
                componentesBiblio.tArea.setText(null);
                
            }
            else if(evento.getSource()==componentesBiblio.bRegresar){
                setVisible(false);
            }
        }
    }
}

class marcoModBiblio extends marcoBiblio{
    public marcoModBiblio(){        
        
        componentesBiblio componentes = new componentesBiblio();
        
        componentesBiblio.bOpcion = new JButton("Modificar");
        componentesBiblio.bOpcion.setBounds(new Rectangle(500,125,100,50));
        add(componentesBiblio.bOpcion);
        
        componentesBiblio.bBuscar = new JButton("Buscar");
        componentesBiblio.bBuscar.setBounds(new Rectangle(500,125,100,50));
        add(componentesBiblio.bBuscar);
        
        eventosModBiblio e = new eventosModBiblio();
        componentesBiblio.bBuscar.addActionListener(e);
        componentesBiblio.bOpcion.addActionListener(e);
        componentesBiblio.bCancelar.addActionListener(e);
        componentesBiblio.bRegresar.addActionListener(e);
        
        
        add(componentes);
    }
    
    private class eventosModBiblio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesBiblio.bBuscar){
                
                String verTitulo = componentesBiblio.tTitulo.getText();
                
                for(int n = 0; n < 30; n++){
                    if(verTitulo.equals(matricesBiblio.Titulo[n])){
                        componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                        componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                        break;
                    }
                }
            }
            else if(evento.getSource()==componentesBiblio.bOpcion){
                
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                
            }
            else if(evento.getSource()==componentesBiblio.bRegresar){
                
            }
        }
    }
}

class marcoDeleteBiblio extends marcoBiblio{
    public marcoDeleteBiblio(){        
        
        componentesBiblio componentes = new componentesBiblio();
        
        componentesBiblio.bOpcion = new JButton("Eliminar");
        componentesBiblio.bOpcion.setBounds(new Rectangle(500,125,100,50));
        add(componentesBiblio.bOpcion);
        
        componentesBiblio.bBuscar = new JButton("Buscar");
        componentesBiblio.bBuscar.setBounds(new Rectangle(500,125,100,50));
        add(componentesBiblio.bBuscar);
        
        eventosDeleteBiblio e = new eventosDeleteBiblio();
        componentesBiblio.bBuscar.addActionListener(e);
        componentesBiblio.bOpcion.addActionListener(e);
        componentesBiblio.bCancelar.addActionListener(e);
        componentesBiblio.bRegresar.addActionListener(e);
        
        add(componentes);
    }
    
    private class eventosDeleteBiblio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesBiblio.bBuscar){
                
            }
            else if(evento.getSource()==componentesBiblio.bOpcion){
                
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                
            }
            else if(evento.getSource()==componentesBiblio.bRegresar){
                
            }
        }
    }
}

class marcoBiblio extends JFrame{
    public marcoBiblio(){
        setBounds(350,125,700,535);
        setResizable(false);
        setTitle("ADMINISTRADOR");
           
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class componentesBiblio extends JPanel{
    
    static JButton bBuscar;
    static JButton bOpcion;
    static JButton bCancelar;
    static JButton bRegresar;

    static JComboBox tTipo;
    static JTextField txtTipo;
    static JTextField tAutor;
    static JTextField tTitulo;
    static JTextField tAño;
    static JTextField tDescripcion;
    static JTextField tPalabras;
    static JTextField tEdicion;
    static JTextField tTemas;
    static JTextField tCopias;
    static JTextField tISBN;
    static JTextField tEjemplares;
    static JTextField tArea;
    
    public componentesBiblio(){
        
        setLayout(null);
        
        tTipo = new JComboBox();
        tTipo.addItem("Seleccione tipo");
        tTipo.addItem("Libro");
        tTipo.addItem("Revista");
        tTipo.addItem("Tesis");
        tTipo.addItem("Libro Virtual");
        tTipo.setBounds(new Rectangle(220,20,150,25));
        add(tTipo);
        
        tTitulo = new JTextField();
        tTitulo.setBounds(new Rectangle(220,60,150,25));
        add(tTitulo);
        
        tAutor = new JTextField();
        tAutor.setBounds(new Rectangle(220,100,150,25));
        add(tAutor);
        
        tAño = new JTextField();
        tAño.setBounds(new Rectangle(220,140,150,25));
        add(tAño);
        
        tDescripcion = new JTextField();
        tDescripcion.setBounds(new Rectangle(220,180,150,25));
        add(tDescripcion);
        
        tPalabras = new JTextField();
        tPalabras.setBounds(new Rectangle(220,220,150,25));
        add(tPalabras);
        
        tEdicion = new JTextField();
        tEdicion.setBounds(new Rectangle(220,260,150,25));
        add(tEdicion);
        
        tTemas = new JTextField();
        tTemas.setBounds(new Rectangle(220,300,150,25));
        add(tTemas);
        
        tCopias = new JTextField();
        tCopias.setBounds(new Rectangle(220,340,150,25));
        add(tCopias);
        
        tISBN = new JTextField();
        tISBN.setBounds(new Rectangle(220,380,150,25));
        add(tISBN);
        
        tEjemplares = new JTextField();
        tEjemplares.setBounds(new Rectangle(220,420,150,25));
        add(tEjemplares);
        
        tArea = new JTextField();
        tArea.setBounds(new Rectangle(220,460,150,25));
        add(tArea);
        
        
    
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
        
        g.drawString("TIPO:", 60, 35);
        g.drawString("Titulo:", 60, 75);
        g.drawString("Autor:", 60, 115);
        g.drawString("Año de publicacion:", 60, 155);
        g.drawString("Descripcion:", 60, 195);
        g.drawString("Palabras clave:", 60, 235);
        g.drawString("Edicion:", 60, 275);
        g.drawString("Temas:", 60, 315);
        g.drawString("Copias:", 60, 355);
        g.drawString("ISBN:", 60, 395);
        g.drawString("Ejemplares:", 60, 435);
        g.drawString("Area:", 60, 475);
        
    }
}
