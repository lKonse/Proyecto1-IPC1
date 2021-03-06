
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

public class OpcionesBiblio_201700584 {  
}

class matricesBiblio{
    static String[] Tipo = new String[30];
    static String[] Autor = new String[30]; 
    static String[] Titulo = new String[30];
    static String[] Año = new String[30]; 
    static String[] Descripcion = new String[30]; 
    static String[][] Palabras = new String[30][10];
    static int[] Edicion = new int[30];
    static String[][] Temas = new String[30][30];
    static int[] Copias = new int[30];
    static int[] Disponibles = new int[30];
    static int[] ISBN = new int[30];
    static String[] Ejemplares = new String[30];
    static String[] Area = new String[30];
}

class matricesLibrosVirtuales{
    static String[] Tipo = new String[30];
    static String[] Autor = new String[30]; 
    static String[] Titulo = new String[30];
    static String[] Año = new String[30]; 
    static String[] Descripcion = new String[30]; 
    static String[][] Palabras = new String[30][10];
    static int[] Edicion = new int[30];
    static String[][] Temas = new String[30][30];
    static int[] Copias = new int[30];
}

class limpiarCampos{
    public limpiarCampos(){
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
        int gEdicion,gCopias,gISBN, t = 0;
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
                
                try{
                gEdicion = Integer.parseInt(componentesBiblio.tEdicion.getText());
                t = 1;
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese el numero de la edicion", "ERROR", JOptionPane.WARNING_MESSAGE);
                    t = 0;
                }
                
                if(opcion == 1 || opcion == 2 || opcion == 3){
                    try{
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        t = 1;
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese el numero de copias", "ERROR", JOptionPane.WARNING_MESSAGE);
                        t = 0;
                    }
                }
                
                if(opcion == 1){
                    try{
                        gISBN = Integer.parseInt(componentesBiblio.tISBN.getText());
                        t = 1;
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Ingrese el numero de ISBN", "ERROR", JOptionPane.WARNING_MESSAGE);
                    t = 0;
                    }
                }
                
                
                if(t == 1){ 
                for(int n = 0; n < 30; n++){
                    
                    if(opcion == 1){
                        if(t == 1){
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = (String) gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.Disponibles[m] = gCopias;
                                        matricesBiblio.ISBN[m] = gISBN;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.ISBN[n] = gISBN;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Libro guardado con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                    }
                    if(opcion == 2){
                        
                        gEjemplares = componentesBiblio.tEjemplares.getText();
                        
                        if(t == 1){
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = (String)gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.Disponibles[n] = gCopias;
                                        matricesBiblio.Ejemplares[m] = gEjemplares;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.Ejemplares[n] = gEjemplares;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Revista guardada con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                    }
                    else if(opcion == 3){
                        
                        gArea = componentesBiblio.tArea.getText();
                        
                        if(t == 1){
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                matricesBiblio.Copias[n] += gCopias;
                                matricesBiblio.Disponibles[n] += gCopias;
                                break;
                            }
                            else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                for(int m = 0; m < 30; m++){
                                    if(matricesBiblio.Titulo[m] == null){

                                        matricesBiblio.Tipo[m] = (String)gTipo;
                                        matricesBiblio.Titulo[m] = gTitulo;
                                        matricesBiblio.Autor[m] = gAutor;
                                        matricesBiblio.Año[m] = gAño;
                                        matricesBiblio.Descripcion[m] = gDescripcion;
                                        matricesBiblio.Palabras[m][0] = gPalabras;
                                        matricesBiblio.Edicion[m] = gEdicion;
                                        matricesBiblio.Temas[m][0] = gTemas;
                                        matricesBiblio.Copias[m] = gCopias;
                                        matricesBiblio.Disponibles[n] = gCopias;
                                        matricesBiblio.Area[m] = gArea;
                                        break;
                                    }
                                }
                            }
                         break;   
                        }
                        else if(matricesBiblio.Titulo[n] == null){
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.Area[n] = gArea;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Tesis guardada con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                    }
                    else if(opcion == 4){
                        if(matricesLibrosVirtuales.Titulo[n] == null){
                            matricesLibrosVirtuales.Tipo[n] = (String)gTipo;
                            matricesLibrosVirtuales.Titulo[n] = gTitulo;
                            matricesLibrosVirtuales.Autor[n] = gAutor;
                            matricesLibrosVirtuales.Año[n] = gAño;
                            matricesLibrosVirtuales.Descripcion[n] = gDescripcion;
                            matricesLibrosVirtuales.Palabras[n][0] = gPalabras;
                            matricesLibrosVirtuales.Edicion[n] = gEdicion;
                            matricesLibrosVirtuales.Temas[n][0] = gTemas;
                            JOptionPane.showMessageDialog(marcoCrearBiblio.this, "Libro virtual guardado con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                }
                limpiarCampos limpiar = new limpiarCampos();
                }
                
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                limpiarCampos limpiar = new limpiarCampos();
                
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
        componentesBiblio.bBuscar.setBounds(new Rectangle(500,25,100,50));
        add(componentesBiblio.bBuscar);
        
        componentesBiblio.tTipo.setVisible(false);
        
        componentesBiblio.txtTipo = new JTextField();
        componentesBiblio.txtTipo.setBounds(new Rectangle(220,20,150,25));
        add(componentesBiblio.txtTipo);
        
        eventosModBiblio e = new eventosModBiblio();
        componentesBiblio.bBuscar.addActionListener(e);
        componentesBiblio.bOpcion.addActionListener(e);
        componentesBiblio.bCancelar.addActionListener(e);
        componentesBiblio.bRegresar.addActionListener(e);
        
        
        add(componentes);
    }
    
    private class eventosModBiblio implements ActionListener{
        
        String gAutor,gAño,gDescripcion,gPalabras,gTemas,gEjemplares,gArea,gTitulo;
        int gEdicion,gCopias,gISBN;
        Object gTipo;
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==componentesBiblio.bBuscar){    
                
                String verTitulo = componentesBiblio.tTitulo.getText();
    
                for(int n = 0; n < 30; n++){
                    if(verTitulo.equals(matricesBiblio.Titulo[n])){
                        if(matricesBiblio.Tipo[n].equals("Libro")){//Ver de que tipo es
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tEjemplares.setEditable(false);
                            componentesBiblio.tArea.setEditable(false);
                            componentesBiblio.tISBN.setEditable(true);
                            componentesBiblio.tCopias.setEditable(true);
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tISBN.setText(String.valueOf(matricesBiblio.ISBN[n]));
                            break;
                        }
                        else if(matricesBiblio.Tipo[n].equals("Revista")){
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            componentesBiblio.tEjemplares.setEditable(true);
                            componentesBiblio.tArea.setEditable(false);
                            componentesBiblio.tISBN.setEditable(false);
                            componentesBiblio.tCopias.setEditable(true);
                            
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tEjemplares.setText(matricesBiblio.Ejemplares[n]);
                            break;
                        }
                        else if(matricesBiblio.Tipo[n].equals("Tesis")){
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            componentesBiblio.tEjemplares.setEditable(false);
                            componentesBiblio.tArea.setEditable(true);
                            componentesBiblio.tISBN.setEditable(false);
                            componentesBiblio.tCopias.setEditable(true);
                            
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tArea.setText(matricesBiblio.Area[n]);
                            break;
                        }
                    }
                    else if(verTitulo.equals(matricesLibrosVirtuales.Titulo[n])){
                        limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesLibrosVirtuales.Titulo[n]);
                            componentesBiblio.tEjemplares.setEditable(false);
                            componentesBiblio.tArea.setEditable(false);
                            componentesBiblio.tISBN.setEditable(false);
                            componentesBiblio.tCopias.setEditable(false);
                            
                            componentesBiblio.txtTipo.setText(matricesLibrosVirtuales.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesLibrosVirtuales.Autor[n]);
                            componentesBiblio.tAño.setText(matricesLibrosVirtuales.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesLibrosVirtuales.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesLibrosVirtuales.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesLibrosVirtuales.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesLibrosVirtuales.Temas[n][0]);
                            break;
                    }
                }
            }
            else if(evento.getSource()==componentesBiblio.bOpcion){
                
                gTipo = componentesBiblio.txtTipo.getText();
                gTitulo = componentesBiblio.tTitulo.getText();
                gAutor = componentesBiblio.tAutor.getText();                         
                gAño = componentesBiblio.tAño.getText();
                gDescripcion = componentesBiblio.tDescripcion.getText();
                gPalabras = componentesBiblio.tPalabras.getText();
                gTemas = componentesBiblio.tTemas.getText();
                gEdicion = Integer.parseInt(componentesBiblio.tEdicion.getText());
                 
                
                for(int n = 0; n < 30; n++){
                    
                    if(gTipo.equals("Libro")){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gISBN = Integer.parseInt(componentesBiblio.tISBN.getText());

                        if(gTitulo.equals(matricesBiblio.Titulo[n])){
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.ISBN[n] = gISBN;
                            JOptionPane.showMessageDialog(marcoModBiblio.this, "Libro modificado con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                    else if(gTipo.equals("Revista")){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gEjemplares = componentesBiblio.tEjemplares.getText(); 
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe 
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.Ejemplares[n] = gEjemplares;
                            JOptionPane.showMessageDialog(marcoModBiblio.this, "Revista modificada con exito", "Carga exitosa", 1);
                            break;
                        } 
                    }
                    else if(gTipo.equals("Tesis")){
                        
                        gCopias = Integer.parseInt(componentesBiblio.tCopias.getText());
                        gArea = componentesBiblio.tArea.getText();
                        
                        if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                            
                            matricesBiblio.Tipo[n] = (String)gTipo;
                            matricesBiblio.Titulo[n] = gTitulo;
                            matricesBiblio.Autor[n] = gAutor;
                            matricesBiblio.Año[n] = gAño;
                            matricesBiblio.Descripcion[n] = gDescripcion;
                            matricesBiblio.Palabras[n][0] = gPalabras;
                            matricesBiblio.Edicion[n] = gEdicion;
                            matricesBiblio.Temas[n][0] = gTemas;
                            matricesBiblio.Copias[n] = gCopias;
                            matricesBiblio.Disponibles[n] = gCopias;
                            matricesBiblio.Area[n] = gArea;
                            JOptionPane.showMessageDialog(marcoModBiblio.this, "Tesis modificada con exito", "Carga exitosa", 1);
                            break;
                        }
                    }
                    else if(gTipo.equals("Libro Virtual")){
                        
                        
                        if(gTitulo.equals(matricesLibrosVirtuales.Titulo[n])){//Si es otra edicion, guardarlo como nuevo libro

                            matricesLibrosVirtuales.Tipo[n] = (String)gTipo;
                            matricesLibrosVirtuales.Titulo[n] = gTitulo;
                            matricesLibrosVirtuales.Autor[n] = gAutor;
                            matricesLibrosVirtuales.Año[n] = gAño;
                            matricesLibrosVirtuales.Descripcion[n] = gDescripcion;
                            matricesLibrosVirtuales.Palabras[n][0] = gPalabras;
                            matricesLibrosVirtuales.Edicion[n] = gEdicion;
                            matricesLibrosVirtuales.Temas[n][0] = gTemas;
                            JOptionPane.showMessageDialog(marcoModBiblio.this, "Libro virtual modificado con exito", "Carga exitosa", 1);
                            break;
                        
                        }
                    }
                limpiarCampos limpiar = new limpiarCampos();
                }
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                limpiarCampos limpiar = new limpiarCampos();
            }
            else if(evento.getSource()==componentesBiblio.bRegresar){
                setVisible(false);
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
        componentesBiblio.bBuscar.setBounds(new Rectangle(500,25,100,50));
        add(componentesBiblio.bBuscar);
        
        componentesBiblio.tTipo.setVisible(false);
        
        componentesBiblio.txtTipo = new JTextField();
        componentesBiblio.txtTipo.setBounds(new Rectangle(220,20,150,25));
        add(componentesBiblio.txtTipo);
        
        componentesBiblio.txtTipo.setEditable(false);
        componentesBiblio.tAutor.setEditable(false);
        componentesBiblio.tAño.setEditable(false);
        componentesBiblio.tDescripcion.setEditable(false);
        componentesBiblio.tPalabras.setEditable(false);
        componentesBiblio.tEdicion.setEditable(false);
        componentesBiblio.tTemas.setEditable(false);
        componentesBiblio.tCopias.setEditable(false);
        componentesBiblio.tISBN.setEditable(false);
        componentesBiblio.tEjemplares.setEditable(false);
        componentesBiblio.tArea.setEditable(false);
        
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
                String verTitulo = componentesBiblio.tTitulo.getText();
    
                for(int n = 0; n < 30; n++){
                    if(verTitulo.equals(matricesBiblio.Titulo[n])){
                        if(matricesBiblio.Tipo[n].equals("Libro")){//Ver de que tipo es
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tISBN.setText(String.valueOf(matricesBiblio.ISBN[n]));
                            break;
                        }
                        else if(matricesBiblio.Tipo[n].equals("Revista")){
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tEjemplares.setText(matricesBiblio.Ejemplares[n]);
                            break;
                        }
                        else if(matricesBiblio.Tipo[n].equals("Tesis")){
                            
                            limpiarCampos limpiar = new limpiarCampos();
                            
                            componentesBiblio.tTitulo.setText(matricesBiblio.Titulo[n]);
                            
                            componentesBiblio.txtTipo.setText(matricesBiblio.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesBiblio.Autor[n]);
                            componentesBiblio.tAño.setText(matricesBiblio.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesBiblio.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesBiblio.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesBiblio.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesBiblio.Temas[n][0]);
                            componentesBiblio.tCopias.setText(String.valueOf(matricesBiblio.Copias[n]));
                            componentesBiblio.tArea.setText(matricesBiblio.Area[n]);
                            break;
                        }
                    }
                    else if(verTitulo.equals(matricesLibrosVirtuales.Titulo[n])){
                            limpiarCampos limpiar = new limpiarCampos();
                             
                            componentesBiblio.tTitulo.setText(matricesLibrosVirtuales.Titulo[n]);
                            componentesBiblio.txtTipo.setText(matricesLibrosVirtuales.Tipo[n]);
                            componentesBiblio.tAutor.setText(matricesLibrosVirtuales.Autor[n]);
                            componentesBiblio.tAño.setText(matricesLibrosVirtuales.Año[n]);
                            componentesBiblio.tDescripcion.setText(matricesLibrosVirtuales.Descripcion[n]);
                            componentesBiblio.tPalabras.setText(matricesLibrosVirtuales.Palabras[n][0]);
                            componentesBiblio.tEdicion.setText(String.valueOf(matricesLibrosVirtuales.Edicion[n]));
                            componentesBiblio.tTemas.setText(matricesLibrosVirtuales.Temas[n][0]);
                            break;
                    }
                }
            }
            else if(evento.getSource()==componentesBiblio.bOpcion){
                
                String gTitulo = componentesBiblio.tTitulo.getText();
                System.out.println(gTitulo);
                
               for(int n = 0; n < 30; n++){

                    if(gTitulo.equals(matricesBiblio.Titulo[n])){
                        
                        matricesBiblio.Tipo[n] = null;
                        matricesBiblio.Titulo[n] = null;
                        matricesBiblio.Autor[n] = null;
                        matricesBiblio.Año[n] = null;
                        matricesBiblio.Descripcion[n] = null;
                        matricesBiblio.Palabras[n][0] = null;
                        matricesBiblio.Edicion[n] = 0;
                        matricesBiblio.Temas[n][0] = null;
                        matricesBiblio.Copias[n] = 0;
                        matricesBiblio.Disponibles[n] = 0;
                        matricesBiblio.ISBN[n] = 0;
                        matricesBiblio.Ejemplares[n] = null;
                        matricesBiblio.Area[n] = null;
                        
                        JOptionPane.showMessageDialog(marcoDeleteBiblio.this, "Bibliografia eliminada con exito", 
                                "eliminar Bibliografia", JOptionPane.INFORMATION_MESSAGE);
                        
                        limpiarCampos eliminar = new limpiarCampos();
                        componentesBiblio.txtTipo.setText(null);
                        
                        break;
                    }
                    else if(gTitulo.equals(matricesLibrosVirtuales.Titulo[n])){
                        matricesLibrosVirtuales.Tipo[n] = null;
                        matricesLibrosVirtuales.Titulo[n] = null;
                        matricesLibrosVirtuales.Autor[n] = null;
                        matricesLibrosVirtuales.Año[n] = null;
                        matricesLibrosVirtuales.Descripcion[n] = null;
                        matricesLibrosVirtuales.Palabras[n][0] = null;
                        matricesLibrosVirtuales.Edicion[n] = 0;
                        matricesLibrosVirtuales.Temas[n][0] = null;
                        matricesLibrosVirtuales.Copias[n] = 0;
                        matricesBiblio.Disponibles[n] = 0;
                        
                        JOptionPane.showMessageDialog(marcoDeleteBiblio.this, "Bibliografia eliminada con exito", 
                                "eliminar Bibliografia", JOptionPane.INFORMATION_MESSAGE);
                        
                        limpiarCampos eliminar = new limpiarCampos();
                        componentesBiblio.txtTipo.setText(null);
                    }
               }
            }
            else if(evento.getSource()==componentesBiblio.bCancelar){
                limpiarCampos limpiar = new limpiarCampos();
            }
            else if(evento.getSource()==componentesBiblio.bRegresar){
                setVisible(false);
            }
        }
    }
}

class marcoMostrarBiblio extends JFrame{//TABLA
    
    
    private String[] nombreColumnas = {"No.","Tipo","Titulo","Autor","Año de Publicacion",
        "Descripcion", "Palabras clave","Edicion","Temas","Copias","Disponibles","ISBN","Ejemplares","Area"};
    
    public marcoMostrarBiblio(){

        setLayout(new FlowLayout());
        setResizable(false);
        setSize(1200,475);
        setLocation(120,125);
        setTitle("ADMINISTRADOR");
        
        miTabla();
        
        componentesMostrarBiblio com = new componentesMostrarBiblio();
        eventosModBiblio e = new eventosModBiblio();
        componentesMostrarBiblio.bRegresar.addActionListener(e);
        add(componentesMostrarBiblio.bRegresar);
  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void miTabla(){
        
        int tamaño = 30;
        int tamañoVirtual = 30;
        int numBiblio = 0;
        
            for(int i = 29; i >= 0; i--){
                if(matricesBiblio.Titulo[i] == null){
                    tamaño--;
                }
                else{
                    break;
                }
            }
            
            for(int i = 29; i >= 0; i--){
                if(matricesLibrosVirtuales.Titulo[i] == null){
                    tamañoVirtual--;
                }
                else{
                    break;
                }
            }
        //matricesLibrosVirtuales

        String[][] datos = new String[tamaño+tamañoVirtual][14];
        
        for(int n = 0; n < tamaño; n++){
            
            datos[n][0] = String.valueOf(numBiblio+1);
            datos[n][1] = matricesBiblio.Tipo[n];
            datos[n][2] = matricesBiblio.Titulo[n];
            datos[n][3] = matricesBiblio.Autor[n];
            datos[n][4] = matricesBiblio.Año[n];
            datos[n][5] = matricesBiblio.Descripcion[n];
            datos[n][6] = matricesBiblio.Palabras[n][0];
            datos[n][7] = String.valueOf(matricesBiblio.Edicion[n]);
            datos[n][8] = matricesBiblio.Temas[n][0];
            datos[n][9] = String.valueOf(matricesBiblio.Copias[n]);
            datos[n][10] = String.valueOf(matricesBiblio.Disponibles[n]);
            datos[n][11] = String.valueOf(matricesBiblio.ISBN[n]);
            datos[n][12] = matricesBiblio.Ejemplares[n];
            datos[n][13] = matricesBiblio.Area[n];
            numBiblio++;
        }
        
        for(int n = 0; n < tamaño+tamañoVirtual; n++){
            for(int m = 0; m < tamaño+tamañoVirtual; m++){
                if(datos[m][2] == null){
                    datos[m][0] = String.valueOf(numBiblio+1);
                    datos[m][1] = matricesLibrosVirtuales.Tipo[n];
                    datos[m][2] = matricesLibrosVirtuales.Titulo[n];
                    datos[m][3] = matricesLibrosVirtuales.Autor[n];
                    datos[m][4] = matricesLibrosVirtuales.Año[n];
                    datos[m][5] = matricesLibrosVirtuales.Descripcion[n];
                    datos[m][6] = matricesLibrosVirtuales.Palabras[n][0];
                    datos[m][7] = String.valueOf(matricesLibrosVirtuales.Edicion[n]);
                    datos[m][8] = matricesLibrosVirtuales.Temas[n][0];
                    numBiblio++;
                    break;
                }
            }
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        
        JTable tabla;
        
        tabla = new JTable(modelo);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(1100,300));
        add(scroll);
    }
    private class eventosModBiblio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()== componentesMostrarBiblio.bRegresar){
                setVisible(false);
            }
        }
    }      
}
class componentesMostrarBiblio extends JPanel{
        
        static JButton bRegresar;
        
        public componentesMostrarBiblio(){
            setLayout(null);
            bRegresar = new JButton("Regresar");
            bRegresar.setPreferredSize(new Dimension(100,50));
        }
}

class marcoCargaMasiva extends marcoBiblio{
    public marcoCargaMasiva(){
        
        componentesCargaMasiva componentes = new componentesCargaMasiva();
        eventosCargaMasiva e = new eventosCargaMasiva();
        componentesCargaMasiva.boton[0].addActionListener(e);
        componentesCargaMasiva.boton[1].addActionListener(e);
        add(componentes);
        
    }
    private class eventosCargaMasiva implements ActionListener{
        
        String gAutor,gAño,gDescripcion,gPalabras,gTemas,gEjemplares,gArea,gTitulo;
        int gEdicion,gCopias,gISBN;
        Object gTipo;

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getSource() == componentesCargaMasiva.boton[0]){
                
                
                    String texto = componentesCargaMasiva.area.getText();
                    String[] lineas = texto.split("\n");
                    String[][] info = new String[lineas.length][];
                    
                    for(int n = 0; n < lineas.length; n++){//Guardar cada palabra en el arreglo 2D
                        info[n] = lineas[n].split(";");
                    }
                    
                matricesBiblio h = new matricesBiblio();//Llamar a las matrices
                
                for(int a = 0; a < lineas.length; a++){
                    
                    if(info[a][0].equals("0")){
                        gTipo = "Libro";
                    }
                    else if(info[a][0].equals("1")){
                        gTipo = "Revista";
                    }
                    else if(info[a][0].equals("2")){
                        gTipo = "Tesis";
                    }
                    else if(info[a][0].equals("3")){
                        gTipo = "Libro Virtual";
                    }
                    gTitulo = info[a][1];
                    gAutor = info[a][2];                         
                    gAño = info[a][3];
                    gDescripcion = info[a][4];
                    gPalabras = info[a][5];
                    gEdicion = Integer.parseInt(info[a][6]);
                    gTemas = info[a][7];
                    
                    for(int n = 0; n < 30; n++){

                        if(gTipo.equals("Libro")){

                            gCopias = Integer.parseInt(info[a][8]);
                            gISBN = Integer.parseInt(info[a][9]);

                            if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                                if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                    matricesBiblio.Copias[n] += gCopias;
                                    break;
                                }
                                else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                    for(int m = 0; m < 30; m++){
                                        if(matricesBiblio.Titulo[m] == null){

                                            matricesBiblio.Tipo[m] = (String) gTipo;
                                            matricesBiblio.Titulo[m] = gTitulo;
                                            matricesBiblio.Autor[m] = gAutor;
                                            matricesBiblio.Año[m] = gAño;
                                            matricesBiblio.Descripcion[m] = gDescripcion;
                                            matricesBiblio.Palabras[m][0] = gPalabras;
                                            matricesBiblio.Edicion[m] = gEdicion;
                                            matricesBiblio.Temas[m][0] = gTemas;
                                            matricesBiblio.Copias[m] = gCopias;
                                            matricesBiblio.Disponibles[m] = gCopias;
                                            matricesBiblio.ISBN[m] = gISBN;
                                            break;
                                        }
                                    }
                                }
                             break;   
                            }
                            else if(matricesBiblio.Titulo[n] == null){
                                matricesBiblio.Tipo[n] = (String)gTipo;
                                matricesBiblio.Titulo[n] = gTitulo;
                                matricesBiblio.Autor[n] = gAutor;
                                matricesBiblio.Año[n] = gAño;
                                matricesBiblio.Descripcion[n] = gDescripcion;
                                matricesBiblio.Palabras[n][0] = gPalabras;
                                matricesBiblio.Edicion[n] = gEdicion;
                                matricesBiblio.Temas[n][0] = gTemas;
                                matricesBiblio.Copias[n] = gCopias;
                                matricesBiblio.Disponibles[n] = gCopias;
                                matricesBiblio.ISBN[n] = gISBN;
                                break;
                            }
                        }
                        if(gTipo.equals("Revista")){

                            gCopias = Integer.parseInt(info[a][8]);
                            gEjemplares = info[a][9]; 

                            if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                                if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                    matricesBiblio.Copias[n] += gCopias;
                                    break;
                                }
                                else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                    for(int m = 0; m < 30; m++){
                                        if(matricesBiblio.Titulo[m] == null){

                                            matricesBiblio.Tipo[m] = (String)gTipo;
                                            matricesBiblio.Titulo[m] = gTitulo;
                                            matricesBiblio.Autor[m] = gAutor;
                                            matricesBiblio.Año[m] = gAño;
                                            matricesBiblio.Descripcion[m] = gDescripcion;
                                            matricesBiblio.Palabras[m][0] = gPalabras;
                                            matricesBiblio.Edicion[m] = gEdicion;
                                            matricesBiblio.Temas[m][0] = gTemas;
                                            matricesBiblio.Copias[m] = gCopias;
                                            matricesBiblio.Disponibles[m] = gCopias;
                                            matricesBiblio.Ejemplares[m] = gEjemplares;
                                            break;
                                        }
                                    }
                                }
                             break;   
                            }
                            else if(matricesBiblio.Titulo[n] == null){
                                matricesBiblio.Tipo[n] = (String)gTipo;
                                matricesBiblio.Titulo[n] = gTitulo;
                                matricesBiblio.Autor[n] = gAutor;
                                matricesBiblio.Año[n] = gAño;
                                matricesBiblio.Descripcion[n] = gDescripcion;
                                matricesBiblio.Palabras[n][0] = gPalabras;
                                matricesBiblio.Edicion[n] = gEdicion;
                                matricesBiblio.Temas[n][0] = gTemas;
                                matricesBiblio.Copias[n] = gCopias;
                                matricesBiblio.Disponibles[n] = gCopias;
                                matricesBiblio.Ejemplares[n] = gEjemplares;
                                break;
                            }
                        }
                        else if(gTipo.equals("Tesis")){

                            gCopias = Integer.parseInt(info[a][8]);
                            gArea = info[a][9];

                            if(gTitulo.equals(matricesBiblio.Titulo[n])){//Si el titulo ya existe
                                if(gEdicion == matricesBiblio.Edicion[n]){//Si es la misma edicion que solo sume el nuemro de copias
                                    matricesBiblio.Copias[n] += gCopias;
                                    break;
                                }
                                else if(gEdicion != matricesBiblio.Edicion[n]){//Si es otra edicion, guardarlo como nuevo libro
                                    for(int m = 0; m < 30; m++){
                                        if(matricesBiblio.Titulo[m] == null){

                                            matricesBiblio.Tipo[m] = (String)gTipo;
                                            matricesBiblio.Titulo[m] = gTitulo;
                                            matricesBiblio.Autor[m] = gAutor;
                                            matricesBiblio.Año[m] = gAño;
                                            matricesBiblio.Descripcion[m] = gDescripcion;
                                            matricesBiblio.Palabras[m][0] = gPalabras;
                                            matricesBiblio.Edicion[m] = gEdicion;
                                            matricesBiblio.Temas[m][0] = gTemas;
                                            matricesBiblio.Copias[m] = gCopias;
                                            matricesBiblio.Disponibles[m] = gCopias;
                                            matricesBiblio.Area[m] = gArea;
                                            break;
                                        }
                                    }
                                }
                             break;   
                            }
                            else if(matricesBiblio.Titulo[n] == null){
                                matricesBiblio.Tipo[n] = (String)gTipo;
                                matricesBiblio.Titulo[n] = gTitulo;
                                matricesBiblio.Autor[n] = gAutor;
                                matricesBiblio.Año[n] = gAño;
                                matricesBiblio.Descripcion[n] = gDescripcion;
                                matricesBiblio.Palabras[n][0] = gPalabras;
                                matricesBiblio.Edicion[n] = gEdicion;
                                matricesBiblio.Temas[n][0] = gTemas;
                                matricesBiblio.Copias[n] = gCopias;
                                matricesBiblio.Disponibles[n] = gCopias;
                                matricesBiblio.Area[n] = gArea;
                                break;
                            }
                        }
                        else if(gTipo.equals("Libro Virtual")){
                            if(matricesLibrosVirtuales.Titulo[n] == null){
                                matricesLibrosVirtuales.Tipo[n] = (String)gTipo;
                                matricesLibrosVirtuales.Titulo[n] = gTitulo;
                                matricesLibrosVirtuales.Autor[n] = gAutor;
                                matricesLibrosVirtuales.Año[n] = gAño;
                                matricesLibrosVirtuales.Descripcion[n] = gDescripcion;
                                matricesLibrosVirtuales.Palabras[n][0] = gPalabras;
                                matricesLibrosVirtuales.Edicion[n] = gEdicion;
                                matricesLibrosVirtuales.Temas[n][0] = gTemas;
                                break;
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(marcoCargaMasiva.this, "Carga masiva exitosa", "EXITO", 1);
            }
            else if(evento.getSource() == componentesCargaMasiva.boton[1]){
                setVisible(false);
            }
        }
    }
}
class componentesCargaMasiva extends JPanel{
    
    static JTextArea area;
    
    static JButton[] boton = new JButton[2];
    
    private Image[] imagen = new Image[2];
    
    public componentesCargaMasiva(){
        setLayout(null);
        
        area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(new Rectangle(25,150,645,300));
        add(scroll);
        
        boton[0] = new JButton("cargar");
        boton[0].setBounds(new Rectangle(125,50,100,50));
        add(boton[0]);
        
        boton[1] = new JButton("Regresar");
        boton[1].setBounds(new Rectangle(450,50,100,50));
        add(boton[1]);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[2];
        
        ubicacion[0] = new File("src/imagenes/fondoAqua.png");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        
        try{
            imagen[0] = ImageIO.read(ubicacion[0]);
            imagen[1] = ImageIO.read(ubicacion[1]);
        }catch(IOException e){
            JOptionPane.showMessageDialog(componentesCargaMasiva.this, "No se encontro la imagen", "ERROR", 0);
        }
        g.drawImage(imagen[0], 0, 0, 700, 535, null);
        g.drawImage(imagen[1], 280, 25, 125, 125, null);
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
    
    private Image imagen;
    
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
        
        File ubicacion = new File("src/imagenes/fondoAqua.png");
        
        try{
            imagen = ImageIO.read(ubicacion);
        }catch(IOException e){
            JOptionPane.showMessageDialog(componentesBiblio.this, 
                    "No se encontro la imagen", "ERROR", 0);
        }
        g.drawImage(imagen, 0, 0, 700, 500, null);
        
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
