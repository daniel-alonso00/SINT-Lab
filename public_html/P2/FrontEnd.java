package p2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.*;

public class FrontEnd {

    public FrontEnd(){

    }

    static void Fase0(HttpServletRequest req, HttpServletResponse res, String nombreFichero ) throws IOException{
        
        //Obtenemos los datos de los parametros para mostrar por pantalla
        String ipCliente = req.getRemoteAddr();
        String infoNavegador = req.getHeader("User-Agent");

        //Agregamos la ruta donde esta la hoja de estilos
        String path = req.getContextPath();
        String cssPath = path + "/p2/styles.css";


        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head>");
        out.println("<title>P2</title>");
        out.println("<link rel=\"stylesheet\" href=\""+cssPath+"\">");  //Agregamos la hoja de estilos
        out.println("</head><body>");
        out.println("<h1>Servicio de información sobre peliculas</h1>");
        out.println("<h1>Bienvenido a este servicio</h1>");

        //mostramos los datos que nos piden por pantalla
        out.println("<p><b>Nombre de fichero procesado: </b>"+nombreFichero+"</p>");
        out.println("<p><b>IP del cliente: </b>"+ipCliente+"</p>");
        out.println("<p><b>Informacion del navegador: </b>"+infoNavegador+"</p>");

        out.println("<h3>Selecciona una consulta:</h3>");
        out.println("<ul type='square'>");
        out.println("<li><a href='P2M?pphase=1'>Consulta 1: Peliculas de actor/actriz con peliculas en un idioma</a></li>");
        out.println("</ul>");

        out.println("<hr>");
        out.println("<footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>");
        out.println("</body></html>");
    }

    static void Fase1(HttpServletRequest req, HttpServletResponse res, ArrayList<String> langs) throws IOException{
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        //Agregamos la ruta donde esta la hoja de estilos
        String path = req.getContextPath();
        String cssPath = path + "/p2/styles.css";

        out.println("<html><head>");
        out.println("<title>P2</title>");
        out.println("<link rel=\"stylesheet\" href=\""+cssPath+"\">");  //Agregamos la hoja de estilos
        out.println("</head><body>");
        out.println("<h1>Servicio de información sobre peliculas</h1>");
        out.println("<h3>Consulta 1: Fase1</h3>");
        out.println("<h3>Selecciona un idioma:</h3>");

        //IMPRIMIMOS LA LISTA DE LANGS
        for(int i = 0; i<langs.size(); i++){    
            String langInst = langs.get(i);
            out.println(i+1+". ");
            out.println("<a href='P2M?pphase=2&plang="+langInst.toString()+"'>"+langInst.toString()+"</a>");
            out.println("<br>");
        }
        out.println("<br>");

        //AGREGAMOS EL BOTON PARA VOLVER AL INICIO
        out.println("<form action=\"/sint/P2M\" method=\"get\" class=\"botones\">");
        out.println("<input type=\"submit\" value=\"Inicio\" id=\"boton_Inicio\">");
        out.println("</form>");


        out.println("<hr>");
        out.println("<footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>");
        out.println("</body></html>");
        
    }

    static void Fase2(HttpServletRequest req, HttpServletResponse res, ArrayList<Cast> castList) throws IOException{
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String lang = req.getParameter("plang");

        //Agregamos la ruta donde esta la hoja de estilos
        String path = req.getContextPath();
        String cssPath = path + "/p2/styles.css";

        out.println("<html><head>");
        out.println("<title>P2</title>");
        out.println("<link rel=\"stylesheet\" href=\""+cssPath+"\">");  //Agregamos la hoja de estilos
        out.println("</head><body>");
        out.println("<h1>Servicio de información sobre peliculas</h1>");
        out.println("<h3>Consulta 1: Fase2 (Idioma = "+lang+")</h3>");
        out.println("<h3>Selecciona un actor/actriz:</h3>");

        
        //IMPRIMIMOS LA LISTA DE CAST SEGUN LANG
        for(int i = 0; i<castList.size(); i++){    
            Cast castInst = castList.get(i);
            out.println(i+1+". ");
            out.println("<a href='P2M?pphase=3&plang="+lang+"&pidC="+castInst.getIdC()+"'>Nombre = "+castInst.getName()+" --- idC = "+castInst.getIdC()+"</a><br>");           
        }
        out.println("<br>");

        //AGREGAMOS EL BOTON PARA VOLVER AL INICIO
        out.println("<form action=\"/sint/P2M\" method=\"get\" class=\"botones\">");
        out.println("<input type=\"submit\" value=\"Inicio\" id=\"boton_Inicio\">");
        out.println("</form>");

        //AGREGAMOS EL BOTON DE VOLVER A LA FASE ANTERIOR
        out.println("<form action=\"/sint/P2M\" method=\"get\" class=\"botones\">");
        out.println("<input type=\"hidden\" name=\"pphase\" value=\"1\">");
        out.println("<input type=\"submit\" value=\"Anterior\" id=\"boton_Anterior\">");
        out.println("</form>");

        out.println("<hr>");
        out.println("<footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>");
        out.println("</body></html>");
        
    }

    static void Fase3(HttpServletRequest req, HttpServletResponse res, ArrayList<Movie> movieList) throws IOException{
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String lang = req.getParameter("plang");
        String pidC = req.getParameter("pidC");

        //Agregamos la ruta donde esta la hoja de estilos
        String path = req.getContextPath();
        String cssPath = path + "/p2/styles.css";

        out.println("<html><head>");
        out.println("<title>P2</title>");
        out.println("<link rel=\"stylesheet\" href=\""+cssPath+"\">");  //Agregamos la hoja de estilos
        out.println("</head><body>");
        out.println("<h1>Servicio de información sobre peliculas</h1>");
        out.println("<h3>Consulta 1: Fase3 (Cast = "+pidC+")</h3>");
        out.println("<h3>Este es el resultado de la consulta:</h3>");

        
        //IMPRIMIMOS LA LISTA DE CAST SEGUN LANG
        for(int i = 0; i<movieList.size(); i++){    
            Movie movieInst = movieList.get(i);
            out.println(i+1+". ");
            out.println("<b>Titulo = </b>"+movieInst.getTitle()+" <b>---Año = </b>"+movieInst.getYear()+"<b> --- idM = </b>"+movieInst.getIdM()+"<br>");            
        }
        out.println("<br>");

        //AGREGAMOS EL BOTON PARA VOLVER AL INICIO
        out.println("<form action=\"/sint/P2M\" method=\"get\" class=\"botones\">");
        out.println("<input type=\"submit\" value=\"Inicio\" id=\"boton_Inicio\">");
        out.println("</form>");

        //AGREGAMOS EL BOTON DE VOLVER A LA FASE ANTERIOR
        out.println("<form action=\"/sint/P2M\" method=\"get\" class=\"botones\">");
        out.println("<input type=\"hidden\" name=\"pphase\" value=\"2\">");
        out.println("<input type=\"hidden\" name=\"plang\" value=\""+lang+"\">");
        out.println("<input type=\"submit\" value=\"Anterior\" id=\"boton_Anterior\">");
        out.println("</form>");

        out.println("<hr>");
        out.println("<footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>");
        out.println("</body></html>");
    }

    static void APIlangs (HttpServletRequest req, HttpServletResponse res, ArrayList<String> langs)throws IOException{
        
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        
        JSONArray JA = new JSONArray();

        for(int i = 0; i<langs.size();i++){

            JSONObject langInst = new JSONObject();
            langInst.put("lang",langs.get(i));
            JA.put(langInst);
        }                
        out.println(JA.toString());
    }
    static void APIcast (HttpServletRequest req, HttpServletResponse res, ArrayList<Cast> cast)throws IOException{

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
                
        JSONArray JA = new JSONArray();

        if(cast.size() == 0){  //comprobamos que hay una lista de cast en ese idioma

            res.setStatus(404); //si no hay una lista enviamos el error 404

        }else{
            for (int i = 0;i<cast.size();i++){

                JSONObject castInst = new JSONObject(); //Creamos el objeto vacio para añadir cosas

                castInst.put("name",cast.get(i).getName());
                castInst.put("idC",cast.get(i).getIdC());

                JA.put(castInst);
            }    
            out.println(JA.toString()); 
        }
    }    
    static void APImovies (HttpServletRequest req, HttpServletResponse res, ArrayList<Movie> movies)throws IOException{

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        JSONArray JA = new JSONArray();

        if(movies.size() == 0){     //si el ArrayList esta vacio es que no hay datos de ese actor

            res.setStatus(404); //enviamos el error 404

        }else{
            for(int i = 0; i<movies.size();i++){

                JSONObject movieInst = new JSONObject();    //Creamos el objeto vacio para meter los datos al momento

                movieInst.put("title",movies.get(i).getTitle());
                movieInst.put("idM",movies.get(i).getIdM());
                movieInst.put("year",movies.get(i).getYear());

                JA.put(movieInst);
            }
            out.println(JA.toString());                    
        }

    }

}
