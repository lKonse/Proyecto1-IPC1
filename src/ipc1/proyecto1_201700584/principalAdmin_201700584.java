
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
                reportesUsuarios();
            }
            else if(evento.getSource()==componentesAdmin.boton[10]){
                reportesBiblio();   
            }
        }
    }
    public void reportesUsuarios(){
                
        FileWriter Archivo = null;
        PrintWriter imprimir;

        try{
            Archivo = new FileWriter("ReporteUsuarios.html");//Crear el archivo
        }catch(IOException e){
            JOptionPane.showMessageDialog(marcoPrincipalAdmin.this, "No se logro crear el reporte","ERROR",0);
        }

        imprimir = new PrintWriter(Archivo);//Crear un impresor para el HTML

        imprimir.println("<HTML>");
        imprimir.println("<head><title>REPORTE USUARIOS</title></head>");
        imprimir.println("<body style=\"background-color:#ECA16D;\">");
        
        int tamaño = 20;
        
            for(int i = 19; i >= 0; i--){
                if(matricesUsers.ID[i] == null){
                    tamaño--;
                }
                else{
                    break;
                }
            }
        
        
        imprimir.println("<h1 align=\"center\">Usuarios existentes</h1>");
        
        imprimir.println("<div align=\"center\">");
	
	imprimir.println("<table border=\"2\" width=\"1000\" bordercolor=\"#EF1D21\" bgcolor=\"#86CED1\">");
	
	imprimir.println("<tr height=\"50\" bgcolor=\"#ECEAEA\">");

	imprimir.println("<th width=\"50\"> No. </th>");
        
        imprimir.println("<th width=\"100\"> ID </th>");
		
	imprimir.println("<th width=\"150\"> Usuario </th>");
		
	imprimir.println("<th width=\"125\"> Nombre </th>");
			
	imprimir.println("<th width=\"125\"> Apellido </th>");
        
	imprimir.println("</tr>");
		
	for(int n = 1; n < 20; n++){
            if(matricesUsers.User[n] != null){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");

                    imprimir.println("<td>" + n + "</td>");
                    
                    imprimir.println("<td>"+ matricesUsers.ID[n] + "</td>");

                    imprimir.println("<td>"+ matricesUsers.User[n] + "</td>");

                    imprimir.println("<td>"+ matricesUsers.Nombre[n] + "</td>");

                    imprimir.println("<td>"+ matricesUsers.Apellido[n] + "</td>");

                imprimir.println("</tr>");
            }
        }
	
	imprimir.println("</table>");

        
        imprimir.println("<h1 align=\"center\">Usuarios con libros prestados</h1>");
        
        imprimir.println("<div align=\"center\">");
	
        imprimir.println("<table border=\"2\" width=\"1000\" bordercolor=\"#EF1D21\" bgcolor=\"#86CED1\">");

        imprimir.println("<tr height=\"50\" bgcolor=\"#ECEAEA\">");

        imprimir.println("<th width=\"200\"> Usuario </th>");

        imprimir.println("<th width=\"800\"> Bibliografias apartadas </th>");

        imprimir.println("</tr>");
        
        for(int n = 0; n < 20; n++){
            if(prestamoBiblio.biblioApartarUser[n][0][0] != null){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                imprimir.println("<td>"+ prestamoBiblio.biblioApartarUser[n][0][0] + "</td>");
                
                imprimir.println("<td>");
                for(int m = 1; m < 20; m++){
                    if(prestamoBiblio.biblioApartarUser[n][m][1] != null){
                        
                        imprimir.print(prestamoBiblio.biblioApartarUser[n][m][2] + ", ");

                    }
                }
                imprimir.println("<td>");
                
                imprimir.println("</tr>");
            }
        }

        imprimir.println("</body>");
        imprimir.println("</HTML>");

        imprimir.close();//SIEMPRE CERRAR EL IMPRESOR
        
        Desktop des = Desktop.getDesktop();
        File html = new File("C:\\Users\\Pablo Roca\\Documents\\NetBeansProjects\\[IPC1]Proyecto1_201700584\\ReporteUsuarios.html");
        try{
            des.open(html);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se logro abrir el archivo", "ERROR", 0);
        }
    }
    
    public void reportesBiblio(){
        FileWriter archivo = null;
        PrintWriter imprimir;
        int numeroMayorBiblio, numeroMayorVirtual;
        
        try{
        archivo = new FileWriter("ReportesBibliografia.html");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se logro crear el reporte, intentelo de nuevo", "ERROR", 0);
        }
        imprimir = new PrintWriter(archivo);
        
        imprimir.println("<HTML>");
        imprimir.println("<head><title>REPORTE USUARIOS</title></head>");
        imprimir.println("<body style=\"background-color:#ECA16D;\">");
        
        numeroMayorBiblio = 0;
        numeroMayorVirtual = 0;

        
        
        imprimir.println("<h1 align=\"center\">Libros existentes</h1>");
        
        imprimir.println("<div align=\"center\">");
	
	imprimir.println("<table border=\"2\" width=\"1000\" bordercolor=\"#EF1D21\" bgcolor=\"#86CED1\">");
	
	imprimir.println("<tr height=\"50\" bgcolor=\"#ECEAEA\">");
        
        imprimir.println("<th width=\"200\"> Tipo </th>");
		
	imprimir.println("<th width=\"400\"> Titulo </th>");
		
	imprimir.println("<th width=\"400\"> Autor </th>");
        
	imprimir.println("</tr>");
		
	for(int n = 1; n < 20; n++){
            if(matricesBiblio.Titulo[n] != null){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                    
                    imprimir.println("<td>"+ matricesBiblio.Tipo[n] + "</td>");

                    imprimir.println("<td>"+ matricesBiblio.Titulo[n] + "</td>");

                    imprimir.println("<td>"+ matricesBiblio.Autor[n] + "</td>");


                imprimir.println("</tr>");
            }
            if(matricesLibrosVirtuales.Titulo[n] != null){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                    
                    imprimir.println("<td>"+ matricesLibrosVirtuales.Tipo[n] + "</td>");

                    imprimir.println("<td>"+ matricesLibrosVirtuales.Titulo[n] + "</td>");

                    imprimir.println("<td>"+ matricesLibrosVirtuales.Autor[n] + "</td>");


                imprimir.println("</tr>");
            }
        }
        
        for(int n = 0; n < prestamoBiblio.apartadaBiblio.length; n++){
            if(prestamoBiblio.apartadaBiblio[n]>numeroMayorBiblio){
                numeroMayorBiblio = prestamoBiblio.apartadaBiblio[n];
            }
        }
        
        for(int n = 0; n < bibliotecaVirtual.apartadoVirtual.length; n++){
            if(bibliotecaVirtual.apartadoVirtual[n]>numeroMayorVirtual){
                numeroMayorVirtual = bibliotecaVirtual.apartadoVirtual[n];
            }
        }
	
	imprimir.println("</table>");

        
        imprimir.println("<h1 align=\"center\">Bibliografia mas prestada actualmente</h1>");
        
        imprimir.println("<div align=\"center\">");
	
        imprimir.println("<table border=\"2\" width=\"1000\" bordercolor=\"#EF1D21\" bgcolor=\"#86CED1\">");

        imprimir.println("<tr height=\"50\" bgcolor=\"#ECEAEA\">");
        
        imprimir.println("<th width=\"200\"> Tipo </th>");

        imprimir.println("<th width=\"400\"> Titulo </th>");

        imprimir.println("<th width=\"400\"> Autor </th>");

        imprimir.println("</tr>");
        
        for(int n = 0; n < 20; n++){
            if(numeroMayorBiblio == prestamoBiblio.apartadaBiblio[n]){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                imprimir.println("<td>"+ matricesBiblio.Tipo[n] + "</td>");
                imprimir.println("<td>"+ matricesBiblio.Titulo[n] + "</td>");
                imprimir.println("<td>"+matricesBiblio.Autor[n]+"</td>");
                imprimir.println("</tr>");
            }
            if(numeroMayorVirtual == bibliotecaVirtual.apartadoVirtual[n]){
                imprimir.println("<tr height=\"30\" bgcolor=\"#86CED1\" align=\"center\">");
                imprimir.println("<td>"+ matricesLibrosVirtuales.Tipo[n] + "</td>");
                imprimir.println("<td>"+ matricesLibrosVirtuales.Titulo[n] + "</td>");
                imprimir.println("<td>"+matricesLibrosVirtuales.Autor[n]+"</td>");
                imprimir.println("</tr>");
            }
        }
        
        

        imprimir.println("</body>");
        imprimir.println("</HTML>");
        
        imprimir.close();
        
        Desktop des = Desktop.getDesktop();
        File html = new File("C:\\Users\\Pablo Roca\\Documents\\NetBeansProjects\\[IPC1]Proyecto1_201700584\\ReportesBibliografia.html");
        
        try{
            des.open(html);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se logro abrir el archivo", "ERROR", 0);
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

