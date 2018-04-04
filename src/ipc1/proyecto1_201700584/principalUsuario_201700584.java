
package ipc1.proyecto1_201700584;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.table.*;

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
        
        componentesPrincipalUser componentes = new componentesPrincipalUser();
        eventosPrincipalUsuario e = new eventosPrincipalUsuario();
        
        for(int n = 0; n < componentesPrincipalUser.boton.length; n++){
            componentesPrincipalUser.boton[n].addActionListener(e);
        }
         
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private class eventosPrincipalUsuario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
           if(evento.getSource() == (componentesPrincipalUser.boton[0])){
               setVisible(false);
               bibliotecaVirtual Virtual = new bibliotecaVirtual();
           }
           else if(evento.getSource() == (componentesPrincipalUser.boton[1])){
               setVisible(false);
               prestamoBiblio prestamo = new prestamoBiblio();
           }
           else if(evento.getSource() == (componentesPrincipalUser.boton[2])){
               setVisible(false);
               marcoPrincipal principal = new marcoPrincipal();
           }
        }
    }
}

class componentesPrincipalUser extends JPanel{
    
    static JButton[] boton = new JButton[3];
    private Image[] imagen = new Image[5];
    
    public componentesPrincipalUser(){
        
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
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[5];
        
        ubicacion[0] = new File("src/imagenes/fondoUsers.jpg");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        ubicacion[2] = new File("src/imagenes/UsuarioHombre.png");
        ubicacion[3] = new File("src/imagenes/UsuarioMujer.png");
        ubicacion[4] = new File("src/imagenes/Bienvenido.png");
        
        try{
            for(int n = 0; n < imagen.length; n++){
                imagen[n] = ImageIO.read(ubicacion[n]);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(componentesPrincipalUser.this, "No se encontro la imagen", "ERROR", JOptionPane.ERROR);
        }
        g.drawImage(imagen[0], 0, 0, 700,500, null);
        g.drawImage(imagen[1], 350, 125, 250,250, null);
        g.drawImage(imagen[2], 75, 25, 100,100, null);
        g.drawImage(imagen[3], 175, 25, 100,100, null);
        g.drawImage(imagen[4], 325, 25, 300,100, null);
      
    }
}

//BIBLIOTECA VIRTUAL
class bibliotecaVirtual extends JFrame{
    
    static JTable tabla;
    TableRowSorter trs;
    static String[][] librosVirtualesUser = new String[20][20];
    static int[] apartadoVirtual = new int[20];

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
               
               try{
                    int seleccion = tabla.getSelectedRow();
                    
                    String titulo = String.valueOf(tabla.getValueAt(seleccion, 2));
                    
                    for(int n = 0; n < 20; n++){
                        if(marcoLogin.usuarioDentro.equals(librosVirtualesUser[n][0])){
                        for(int m = 1; m < 20; m++){
                                if(titulo.equals(librosVirtualesUser[n][m])){
                                    JOptionPane.showMessageDialog(bibliotecaVirtual.this, "Ya tiene almacenado este libro", 
                                            "ERROR", JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                                else if(librosVirtualesUser[n][m] == null){
                                        librosVirtualesUser[n][m] = titulo;
                                        apartadoVirtual[m]++;
                                        JOptionPane.showMessageDialog(bibliotecaVirtual.this, "Libro agregado a su biblioteca virtual", 
                                                titulo, JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }
                        }
                    }
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(bibliotecaVirtual.this, "No se logro completar la accion, "
                            + "intentelo de nuevo", "ERROR", 0);
                }
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[3])){
               
//               try{
               verBibliotecaVirtual verVirtual = new verBibliotecaVirtual();
//               }catch(Exception e){
//                   JOptionPane.showMessageDialog(null, "No existe libro virtual agregado", "ERRIR", 0);
//               }
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[4])){
               
               
            }
        }
    }
    
    public void miTabla(){
             
        String[] nombreColumnas = {"No.","Tipo","Titulo","Autor","Año de Publicacion",
            "Descripcion", "Palabras clave","Edicion","Temas"};
        
        int tamaño = 30;
        
            for(int i = 29; i >= 0; i--){
                if(matricesLibrosVirtuales.Tipo[i] == null){
                    tamaño--;
                }
                else{
                    break;
                }
            }
        

        String[][] datos = new String[tamaño][13];
        
        for(int n = 0; n < tamaño; n++){
                    datos[n][0] = String.valueOf(n+1);
                    datos[n][1] = matricesLibrosVirtuales.Tipo[n];
                    datos[n][2] = matricesLibrosVirtuales.Titulo[n];
                    datos[n][3] = matricesLibrosVirtuales.Autor[n];
                    datos[n][4] = matricesLibrosVirtuales.Año[n];
                    datos[n][5] = matricesLibrosVirtuales.Descripcion[n];
                    datos[n][6] = matricesLibrosVirtuales.Palabras[n][0];
                    datos[n][7] = String.valueOf(matricesLibrosVirtuales.Edicion[n]);
                    datos[n][8] = matricesLibrosVirtuales.Temas[n][0];
                }
            
       
        
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        tabla = new JTable(modelo);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(25,275,950,275);
        add(scroll);
        
        
    }
}
class componentesBiblioVirtual extends JPanel{
    
    static JButton[] boton = new JButton[5];
    private Image imagen[] = new Image[3];
    
    public componentesBiblioVirtual(){
        
        setLayout(null);
        
        boton[0] = new JButton("Logout");
        boton[0].setBounds(new Rectangle(850, 25, 100, 50));
        add(boton[0]);
        
        boton[1] = new JButton("Regresar");
        boton[1].setBounds(new Rectangle(850, 90, 100, 50));
        add(boton[1]);
        
        boton[2] = new JButton("Agregar");
        boton[2].setBounds(new Rectangle(750, 200, 200, 50));
        add(boton[2]);
        
        boton[3] = new JButton("Ver biblioteca virtual");
        boton[3].setBounds(new Rectangle(75, 200, 200, 50));
        add(boton[3]);
        
        boton[4] = new JButton("Buscar");
        boton[4].setBounds(new Rectangle(400, 200, 200, 50));
        add(boton[4]);
 
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[3];
        
        ubicacion[0] = new File("src/imagenes/fondoUsers.jpg");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        
        try{
            imagen[0] = ImageIO.read(ubicacion[0]);
            imagen[1] = ImageIO.read(ubicacion[1]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(componentesBiblioVirtual.this, "No se encontro la imagen", "ERROR", JOptionPane.ERROR);
        }
        g.drawImage(imagen[0], 0, 0, 1000,600, null);
        g.drawImage(imagen[1], 100, 25, 150,150, null);
        
//        Graphics2D g2 = (Graphics2D) g;
//        Font[] palabra = new Font[3];
//        
//        for(int n = 0; n < palabra.length; n++){
//            palabra[n] = new Font("Arial",Font.BOLD,16);
//            g2.setFont(palabra[n]);
//        }
//        
//        g2.setColor(Color.WHITE);
//        g2.drawString("Titulo", 300, 70);
//        g2.drawString("Autor", 300, 120);
//        g2.drawString("Edicion", 300, 170);
      
    }
}

class verBibliotecaVirtual extends JFrame{
    
    static String libro;
    
    public verBibliotecaVirtual(){
        setTitle("Usuario");
        setBounds(175,75,800,600);
        setResizable(false);
        
        componentesVerBiblioVirtual componentes = new componentesVerBiblioVirtual();
        eventosVerBiblioVirtual e = new eventosVerBiblioVirtual();
        
        add(componentes);
        
        for(int n = 1; n < componentesVerBiblioVirtual.numBotones; n++){
            componentesVerBiblioVirtual.boton[n].addActionListener(e);
        }
        
        componentesVerBiblioVirtual.boton[1].addActionListener(e);
    
        setVisible(true);
    }
    private class eventosVerBiblioVirtual implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            for(int n = 1; n < 20; n++){
                if(evento.getSource().equals(componentesVerBiblioVirtual.boton[n])){
                    
                    libro = componentesVerBiblioVirtual.boton[n].getText();
                    mostrarLibroVirtual mostrar = new mostrarLibroVirtual();
                
                }
            }
            if(evento.getSource() == componentesVerBiblioVirtual.opciones[1]){
                setVisible(false);
            }
        }
    }
}

class mostrarLibroVirtual extends JFrame{
    public mostrarLibroVirtual(){
        setBounds(425,200,425,425);
        setResizable(false);
        
        componentesMostrarLibroVirtual componentes = new componentesMostrarLibroVirtual();
        eventosMostrarBiblioVirtual e = new eventosMostrarBiblioVirtual();
        componentesMostrarLibroVirtual.delete.addActionListener(e);
        add(componentes);
        
        setVisible(true);
    }  
    private class eventosMostrarBiblioVirtual implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            for(int n = 1; n < 20; n++){
                if(marcoLogin.usuarioDentro.equals(bibliotecaVirtual.librosVirtualesUser[n][0])){
                    for(int m = 1; m < 20; m++){
                        if(verBibliotecaVirtual.libro.equals(bibliotecaVirtual.librosVirtualesUser[n][m])){
                            bibliotecaVirtual.librosVirtualesUser[n][m] = null;
                            JOptionPane.showMessageDialog(null, "Libro eliminado de la cuenta", verBibliotecaVirtual.libro, 2);
                            bibliotecaVirtual.apartadoVirtual[m]--;
                            setVisible(false);
                            for(int j = 1; j < componentesVerBiblioVirtual.numBotones; j++){
                                if(verBibliotecaVirtual.libro.equals(componentesVerBiblioVirtual.boton[j].getText())){
                                    componentesVerBiblioVirtual.boton[j].setEnabled(false);
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
class componentesMostrarLibroVirtual extends JPanel{
    
    static JButton delete;
    
    public componentesMostrarLibroVirtual(){
        setLayout(null);
        
        delete = new JButton("Eliminar");
        delete.setBounds(new Rectangle(160,325,100,50));
        add(delete);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int n = 0; n < 20; n++){
            if(marcoLogin.usuarioDentro.equals(bibliotecaVirtual.librosVirtualesUser[n][0])){
                for(int m = 1; m < 20; m++){
                    if(verBibliotecaVirtual.libro.equals(bibliotecaVirtual.librosVirtualesUser[n][m])){
                        for(int i = 0; i < 30; i++){
                            if(verBibliotecaVirtual.libro.equals(matricesLibrosVirtuales.Titulo[i])){
                                g.drawString("Titulo: "+verBibliotecaVirtual.libro, 50, 50);
                                g.drawString("Autor: "+matricesLibrosVirtuales.Autor[i], 50, 75);
                                g.drawString("Año: "+matricesLibrosVirtuales.Año[i], 50, 100);
                                g.drawString("Descripcion: "+matricesLibrosVirtuales.Descripcion[i], 50, 125);
                                g.drawString("Palabras: "+matricesLibrosVirtuales.Palabras[i][0], 50, 150);
                                g.drawString("Temas: "+matricesLibrosVirtuales.Temas[i][0], 50, 175);
                            }
                        }
                    }
                }
            }
        }
    }
}

class componentesVerBiblioVirtual extends JPanel{
    
    private Image imagen[] = new Image[3];
    static JButton[] boton = new JButton[20];
    static JButton[] opciones = new JButton[5];
    static int posicionXBoton = 0, posicionYBoton = 50, numBotones = 1;
    
    public componentesVerBiblioVirtual(){
        
        posicionXBoton = 0;
        posicionYBoton = 50;
        numBotones = 1;
        
        setLayout(null);
        
        for(int n = 0; n < 20; n++){
            if(marcoLogin.usuarioDentro.equals(bibliotecaVirtual.librosVirtualesUser[n][0])){
                for(int m = 1; m < 20; m++){
                    if(bibliotecaVirtual.librosVirtualesUser[n][m] != null){
                        
                        if(posicionXBoton < 300){
                           posicionXBoton = posicionXBoton + 125; 
                        }
                        else if(posicionXBoton >= 300){
                            posicionXBoton = 125;
                            posicionYBoton = posicionYBoton + 50;
                        }

                        boton[m] = new JButton(bibliotecaVirtual.librosVirtualesUser[n][m]);
                        boton[m].setBounds(new Rectangle(posicionXBoton,posicionYBoton,125,50));
                        add(boton[m]);
                        
                        numBotones++;
                    }
                }
            }
        }
        
        opciones[1] = new JButton("Regresar");
        opciones[1].setBounds(new Rectangle(600,200,100,50));
        add(opciones[1]);
        
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[3];
        
        ubicacion[0] = new File("src/imagenes/fondoUsers.jpg");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        
        try{
            imagen[0] = ImageIO.read(ubicacion[0]);
            imagen[1] = ImageIO.read(ubicacion[1]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", JOptionPane.ERROR);
        }
        g.drawImage(imagen[0], 0, 0, 1000,600, null);
        g.drawImage(imagen[1], 600, 425, 100,100, null);
      
    }
}

//PRESTAMOS DE LIBROS
class prestamoBiblio extends JFrame{
    
    static JTable tabla;
    TableRowSorter trs;
    static String[][][] biblioApartarUser = new String[20][20][14];
    static int[] apartadaBiblio = new int[20];
    
    public prestamoBiblio(){
        setTitle("Usuario");
        setBounds(175,75,1000,600);
        setResizable(false);
        
        miTablaApartada();
        
        componentesPrestamoBiblio componentes = new componentesPrestamoBiblio();
        eventosPrestamoBiblio e = new eventosPrestamoBiblio();
        
        for(int n = 0; n < componentesPrestamoBiblio.boton.length; n++){
            componentesPrestamoBiblio.boton[n].addActionListener(e);
        }
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private class eventosPrestamoBiblio implements ActionListener{
        
        String gAutor,gAño,gDescripcion,gPalabras,gTemas,gEjemplares,gArea,gTitulo,gISBN,gEdicion;
        int gCopias;
        Object gTipo;

        @Override
        public void actionPerformed(ActionEvent evento) {
            
           if(evento.getSource() == (componentesPrestamoBiblio.boton[0])){
               setVisible(false);
               marcoPrincipal principal = new marcoPrincipal();
           }
           else if(evento.getSource() == (componentesPrestamoBiblio.boton[1])){
               setVisible(false);
               marcoPrincipalUsuario usuario = new marcoPrincipalUsuario();
           }
           else if(evento.getSource() == (componentesPrestamoBiblio.boton[2])){
               
               
               
               try{
                    int seleccion = tabla.getSelectedRow();
                    
                    gTipo = String.valueOf(tabla.getValueAt(seleccion, 1));
                    gTitulo = String.valueOf(tabla.getValueAt(seleccion, 2));
                    gAutor = String.valueOf(tabla.getValueAt(seleccion, 3));                         
                    gAño = String.valueOf(tabla.getValueAt(seleccion, 4));
                    gDescripcion = String.valueOf(tabla.getValueAt(seleccion, 5));
                    gPalabras = String.valueOf(tabla.getValueAt(seleccion, 6));
                    gEdicion = String.valueOf(tabla.getValueAt(seleccion, 7));
                    gTemas = String.valueOf(tabla.getValueAt(seleccion, 8));
                    gCopias = Integer.parseInt(String.valueOf(tabla.getValueAt(seleccion, 9)));
                    gISBN = String.valueOf(tabla.getValueAt(seleccion, 10));
                    gEjemplares = String.valueOf(tabla.getValueAt(seleccion, 11));
                    gArea = String.valueOf(tabla.getValueAt(seleccion, 12));
                    
                    if(gCopias > 0){
                    for(int n = 0; n < 20; n++){
                        if(marcoLogin.usuarioDentro.equals(biblioApartarUser[n][0][0])){
                        for(int m = 1; m < 20; m++){
                                if(gTitulo.equals(biblioApartarUser[n][m][2])){
                                    JOptionPane.showMessageDialog(prestamoBiblio.this, "Ya tiene almacenado esta "+ gTipo, 
                                            "ERROR", JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
                                else if(biblioApartarUser[n][m][2] == null){
                                    biblioApartarUser[n][m][1] = (String)gTipo;
                                    biblioApartarUser[n][m][2] = gTitulo;
                                    biblioApartarUser[n][m][3] = gAutor;
                                    biblioApartarUser[n][m][4] = gAño;
                                    biblioApartarUser[n][m][5] = gDescripcion;
                                    biblioApartarUser[n][m][6] = gPalabras;
                                    biblioApartarUser[n][m][7] = gEdicion;
                                    biblioApartarUser[n][m][8] = gTemas;
                                    biblioApartarUser[n][m][9] = String.valueOf(gCopias);//COPIAS
                                    biblioApartarUser[n][m][10] = "1";
                                    biblioApartarUser[n][m][11] = gISBN;
                                    biblioApartarUser[n][m][12] = gEjemplares;
                                    biblioApartarUser[n][m][13] = gArea;
                                    
                                    for(int i = 0; i < 30; i++){
                                        if(gTitulo.equals(matricesBiblio.Titulo[i])){
                                            
                                                matricesBiblio.Disponibles[i]--;
                                                apartadaBiblio[i]++;
                                        }
                                    }
                                    
                                    JOptionPane.showMessageDialog(prestamoBiblio.this, gTipo + " Apartada", 
                                            gTitulo, JOptionPane.INFORMATION_MESSAGE);
                                    
                                    setVisible(false);
                                    prestamoBiblio prestamo = new prestamoBiblio();
                                    
                                    break;
                                }
                            }
                        }
                    }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ya no hay mas libros dosponibles", gTitulo, JOptionPane.WARNING_MESSAGE);
                    }
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(prestamoBiblio.this, "No se logro completar la accion, "
                            + "intentelo de nuevo", "ERROR", 0);
                }
               
               
               
           }
           else if(evento.getSource() == (componentesPrestamoBiblio.boton[3])){
               
               setVisible(false);
               verPrestamos ver = new verPrestamos();
               
           }
           else if(evento.getSource() == (componentesPrestamoBiblio.boton[4])){
               
               reporteExistencias();
               
            }
        }  
    }
    
    private void reporteExistencias(){
        FileWriter archivo = null;
        PrintWriter imprimir;
        
        try{
        archivo = new FileWriter("ReporteExistencias.html");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se logro crear el reporte, intentelo de nuevo", "ERROR", 0);
        }
        imprimir = new PrintWriter(archivo);
        
        imprimir.println("<HTML>");
        imprimir.println("<head><title>REPORTE USUARIOS</title></head>");
        imprimir.println("<body style=\"background-color:#ECA16D;\">");

        
        imprimir.println("<h1 align=\"center\">Bibliografia existente</h1>");
        
        imprimir.println("<div align=\"center\">");
	
	imprimir.println("<table border=\"2\" width=\"1000\" bordercolor=\"#EF1D21\" bgcolor=\"#86CED1\">");
	
	imprimir.println("<tr height=\"50\" bgcolor=\"#ECEAEA\">");
        
        imprimir.println("<th width=\"100\"> Tipo </th>");
		
	imprimir.println("<th width=\"400\"> Titulo </th>");
		
	imprimir.println("<th width=\"400\"> Autor </th>");
        
        imprimir.println("<th width=\"100\"> Disponibles </th>");
        
	imprimir.println("</tr>");
		
	for(int n = 0; n < 30; n++){
            if(matricesBiblio.Titulo[n] != null){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                    
                    imprimir.println("<td>"+ matricesBiblio.Tipo[n] + "</td>");

                    imprimir.println("<td>"+ matricesBiblio.Titulo[n] + "</td>");

                    imprimir.println("<td>"+ matricesBiblio.Autor[n] + "</td>");
                    
                    imprimir.println("<td>"+ matricesBiblio.Disponibles[n] + "</td>");


                imprimir.println("</tr>");
            }
        }

        imprimir.println("</body>");
        imprimir.println("</HTML>");
        
        imprimir.close();
        
        Desktop des = Desktop.getDesktop();
        File html = new File("C:\\Users\\Pablo Roca\\Documents\\NetBeansProjects\\[IPC1]Proyecto1_201700584\\ReporteExistencias.html");
        
        try{
            des.open(html);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se logro abrir el archivo", "ERROR", 0);
        }
    }
    
    public void miTablaApartada(){
             
        String[] nombreColumnas = {"No.","Tipo","Titulo","Autor","Año de Publicacion",
            "Descripcion", "Palabras clave","Edicion","Temas","Copias","Disponibles","ISBN","Ejemplares","Area"};
        
        int tamaño = 30;
        
            for(int i = 29; i >= 0; i--){
                if(matricesBiblio.Tipo[i] == null){
                    tamaño--;
                }
                else{
                    break;
                }
            }
        

        String[][] datos = new String[tamaño][14];
        
        for(int n = 0; n < tamaño; n++){
            if(!matricesBiblio.Tipo[n].equals("Libro Virtual")){
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
                datos[n][10] = String.valueOf(matricesBiblio.Disponibles[n]);
                datos[n][11] = String.valueOf(matricesBiblio.ISBN[n]);
                datos[n][12] = matricesBiblio.Ejemplares[n];
                datos[n][13] = matricesBiblio.Area[n];
            }
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        tabla = new JTable(modelo);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(25,275,950,275);
        add(scroll);
        
    }
}
class componentesPrestamoBiblio extends JPanel{
    
    static JButton[] boton = new JButton[5];
    private Image imagen[] = new Image[3];
    
    public componentesPrestamoBiblio(){
        setLayout(null);
        
        boton[0] = new JButton("Logout");
        boton[0].setBounds(new Rectangle(850, 25, 100, 50));
        add(boton[0]);
        
        boton[1] = new JButton("Regresar");
        boton[1].setBounds(new Rectangle(850, 90, 100, 50));
        add(boton[1]);
        
        boton[2] = new JButton("Apartar");
        boton[2].setBounds(new Rectangle(750, 200, 200, 50));
        add(boton[2]);
        
        boton[3] = new JButton("Ver prestamos");
        boton[3].setBounds(new Rectangle(75, 200, 200, 50));
        add(boton[3]);
        
        boton[4] = new JButton("Reporte de existencias");
        boton[4].setBounds(new Rectangle(400, 200, 200, 50));
        add(boton[4]);
        
        
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[3];
        
        ubicacion[0] = new File("src/imagenes/fondoUsers.jpg");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        
        try{
            imagen[0] = ImageIO.read(ubicacion[0]);
            imagen[1] = ImageIO.read(ubicacion[1]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(componentesPrestamoBiblio.this, "No se encontro la imagen", "ERROR", JOptionPane.ERROR);
        }
        g.drawImage(imagen[0], 0, 0, 1000,600, null);
        g.drawImage(imagen[1], 100, 25, 150,150, null);
    }
}
//Ver libros apartados de un usuario
class verPrestamos extends JFrame{
    
    static JTable tabla;
    
//    static String[] Tipo = new String[20];
//    static String[] Autor = new String[20]; 
//    static String[] Titulo = new String[20];
//    static String[] Año = new String[20]; 
//    static String[] Descripcion = new String[20]; 
//    static String[][] Palabras = new String[20][10];
//    static int[] Edicion = new int[20];
//    static String[][] Temas = new String[20][30];
//    static int[] Copias = new int[20];
//    static int[] ISBN = new int[20];
//    static String[] Ejemplares = new String[20];
//    static String[] Area = new String[20];

    public verPrestamos(){
        setTitle("Usuario");
        setBounds(175,75,1000,600);
        setResizable(false);
        
        miTabla();
        
        componentesVerPrestamos componentes = new componentesVerPrestamos();
        eventosVerPrestamos e = new eventosVerPrestamos();
        
        for(int n = 0; n < componentesVerPrestamos.boton.length; n++){
            componentesVerPrestamos.boton[n].addActionListener(e);
        }
        
        add(componentes);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class eventosVerPrestamos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            
           if(evento.getSource() == (componentesVerPrestamos.boton[0])){
               setVisible(false);
               marcoPrincipal principal = new marcoPrincipal();
           }
           else if(evento.getSource() == (componentesVerPrestamos.boton[1])){
               setVisible(false);
               prestamoBiblio prestamos = new prestamoBiblio();
           }
           else if(evento.getSource() == (componentesVerPrestamos.boton[2])){
               
               try{
                    int seleccion = tabla.getSelectedRow();
                    String titulo = String.valueOf(tabla.getValueAt(seleccion, 2));
                    
                    for(int n = 0; n < 20; n++){
                        if(marcoLogin.usuarioDentro.equals(prestamoBiblio.biblioApartarUser[n][0][0])){
                            for(int m = 1; m < 20; m++){
                                if(titulo.equals(prestamoBiblio.biblioApartarUser[n][m][2])){
                                    
                                    for(int j = 0; j < 30; j++){
                                        if(titulo.equals(matricesBiblio.Titulo[j])){
                                            matricesBiblio.Disponibles[j]++;
                                            prestamoBiblio.apartadaBiblio[j]--;
                                        }
                                    }
                                    
                                    for(int i = 1; i < 13; i++){
                                        prestamoBiblio.biblioApartarUser[n][m][i] = null;
                                    }
                                    prestamoBiblio.biblioApartarUser[n][m][9]="";
                                }
                            }
                        }
                    }
                    
                    JOptionPane.showMessageDialog(verPrestamos.this, "Libro devuelto", "Devolver", JOptionPane.INFORMATION_MESSAGE);
                    
                    setVisible(false);
                    verPrestamos ver = new verPrestamos();
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(verPrestamos.this, "No se logro completar la accion, "
                            + "intentelo de nuevo", "ERROR", 0);
                }
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[3])){
               
               
               
           }
           else if(evento.getSource() == (componentesBiblioVirtual.boton[4])){
               
               
            }
        }
    }
    
    public void miTabla(){
             
        String[] nombreColumnas = {"No.","Tipo","Titulo","Autor","Año de Publicacion",
            "Descripcion", "Palabras clave","Edicion","Temas","Copias","ISBN","Ejemplares","Area"};
        
        int tamaño = 20;
        
        try{
        for(int n = 0; n < 20; n++){
            if(marcoLogin.usuarioDentro.equals(prestamoBiblio.biblioApartarUser[n][0][0])){
                for(int m = 19; m > 0; m--){
                    if(prestamoBiblio.biblioApartarUser[n][m][2] == null){
                        tamaño--;
                    }else{
                        break;
                    }
                }
            }
        }
        
        String[][] datos = new String[tamaño][13];
        
        for(int n = 0; n < 20; n++){
            if(marcoLogin.usuarioDentro.equals(prestamoBiblio.biblioApartarUser[n][0][0])){
                for(int m = 0; m < tamaño; m++){
                        datos[m][0] = String.valueOf(m+1);
                        datos[m][1] = prestamoBiblio.biblioApartarUser[n][m+1][1];
                        datos[m][2] = prestamoBiblio.biblioApartarUser[n][m+1][2];
                        datos[m][3] = prestamoBiblio.biblioApartarUser[n][m+1][3];
                        datos[m][4] = prestamoBiblio.biblioApartarUser[n][m+1][4];
                        datos[m][5] = prestamoBiblio.biblioApartarUser[n][m+1][5];
                        datos[m][6] = prestamoBiblio.biblioApartarUser[n][m+1][6];
                        datos[m][7] = prestamoBiblio.biblioApartarUser[n][m+1][7];
                        datos[m][8] = prestamoBiblio.biblioApartarUser[n][m+1][8];
                        datos[m][9] = String.valueOf(prestamoBiblio.biblioApartarUser[n][m+1][9]);
                        datos[m][10] = prestamoBiblio.biblioApartarUser[n][m+1][10];
                        datos[m][11] = prestamoBiblio.biblioApartarUser[n][m+1][11];
                        datos[m][12] = prestamoBiblio.biblioApartarUser[n][m+1][12];
                }
            }
        }
        
        
        tabla = new JTable(datos, nombreColumnas);
        tabla.setBounds(40,40,200,300);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(25,275,950,275);
        add(scroll);
        
        }catch(Exception e){
            
        }
    }
}
class componentesVerPrestamos extends JPanel{
    
    static JButton[] boton = new JButton[3];
    private Image imagen[] = new Image[3];
    
    public componentesVerPrestamos(){
        
        setLayout(null);
        
        boton[0] = new JButton("Logout");
        boton[0].setBounds(new Rectangle(850, 25, 100, 50));
        add(boton[0]);
        
        boton[1] = new JButton("Regresar");
        boton[1].setBounds(new Rectangle(850, 90, 100, 50));
        add(boton[1]);
        
        boton[2] = new JButton("Devolver Libro");
        boton[2].setBounds(new Rectangle(750, 200, 200, 50));
        add(boton[2]);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        File[] ubicacion = new File[3];
        
        ubicacion[0] = new File("src/imagenes/fondoUsers.jpg");
        ubicacion[1] = new File("src/imagenes/usacLogo2.png");
        
        try{
            imagen[0] = ImageIO.read(ubicacion[0]);
            imagen[1] = ImageIO.read(ubicacion[1]);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(componentesVerPrestamos.this, "No se encontro la imagen", "ERROR", JOptionPane.ERROR);
        }
        g.drawImage(imagen[0], 0, 0, 1000,600, null);
        g.drawImage(imagen[1], 100, 25, 150,150, null);
        
      
    }
}
