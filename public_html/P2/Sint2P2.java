package p2;
import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import p2.FrontEnd;
import jakarta.servlet.annotation.*;

import org.json.*;

public class Sint2P2 extends HttpServlet {

    private DataModel miDataModel;
    private FrontEnd miFrontEnd;
    private String URLxmlFile= "https://luis.sabucedo.webs.uvigo.es/24-25/p2/mml.xml";

    public void init(){
        try {

            miDataModel = new DataModel(URLxmlFile);
            miFrontEnd = new FrontEnd();

            
        } catch (Exception e) {
            System.out.println("Error en la inicializacion");
            e.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();      

        String fase = req.getParameter("pphase");
        String reqURL = req.getRequestURI();    //Sacamos los parametros de la URL

        if(reqURL.equals("/sint2/P2M")){    //Si tenemos P2M entramos en la consulta de peliculas

            if((fase == null)||(fase.equals("0"))) {           //CUANDO ES FASE0

                String[] segmentos = URLxmlFile.split("/");
                String nombreFichero = segmentos[segmentos.length - 1];

                FrontEnd.Fase0(req,res,nombreFichero);

            }else if(fase.equals("1")) {                       //CUANDO ES FASE1
                
                ArrayList<String> langs = miDataModel.getLangs();
                FrontEnd.Fase1(req,res,langs);

            }else if(fase.equals("2")) {                       //CUANDO ES FASE2
            

                String lang = req.getParameter("plang");
                ArrayList<Cast> castList = miDataModel.getCast(lang);
                FrontEnd.Fase2(req,res,castList);

            }else if(fase.equals("3")) {                       //CUANDO ES FASE3

                String idC = req.getParameter("pidC");
                ArrayList<Movie> movieList = miDataModel.getMovies(idC);
                FrontEnd.Fase3(req,res,movieList);

            }else{
                out.println("no hay fase seleccionada");
            }

        }else{  //ENTRAMOS EN LA API
            if(reqURL.equals("/sint2/P2M/v1/langs")){   //SOLICITAMOS UNA LISTA DE IDIOMAS
                
                ArrayList<String> langs = miDataModel.getLangs();
                FrontEnd.APIlangs(req,res,langs);


            }else if(reqURL.equals("/sint2/P2M/v1/cast")) {    //SOLICITAMOS UNA LISTA DE CAST SEGUN IDIOMA

                String lang = req.getParameter("lang");
                ArrayList<Cast> cast = miDataModel.getCast(lang);   //sacamos la lista del cast de ese idioma

                FrontEnd.APIcast(req,res,cast);
      
            }else if(reqURL.matches("/sint2/P2M/v1/cast/.*/movies")){     //SOLICITAMOS LAS PELICULAS DE UN ACTOR
                //en este caso unamos la funcion matches por que con equals tiene que ser la cadena exactamente igual peor con esta no hace falta

                String[] parts = reqURL.split("/");
                String idC = parts[parts.length - 2];   //sacamos el idC de la URL

                ArrayList<Movie> movies = miDataModel.getMovies(idC);   //sacamos la lista de peliculas de ese actor

                FrontEnd.APImovies(req,res,movies);
            }

        }


    }      
}
