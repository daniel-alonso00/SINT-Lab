package p3;
import java.io.*;
import java.util.ArrayList;

import org.w3c.dom.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class sintP3 extends HttpServlet {

    private DataModel miDataModel;
    private String URLxmlFile= "https://luis.sabucedo.webs.uvigo.es/24-25/p2/mml.xml";

    public void init(){
        try {
            miDataModel = new DataModel(URLxmlFile);
            
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

        if(reqURL.equals("/sint/P3M")){    //Si tenemos P3M entramos en la consulta de peliculas

            if((fase == null)||(fase.equals("0"))) {           //CUANDO ES FASE0

                String[] segmentos = URLxmlFile.split("/");
                String nombreFichero = segmentos[segmentos.length - 1];
                String ipCliente = req.getRemoteAddr();
                String infoNavegador = req.getHeader("User-Agent");

                BeanFase0 bean = new BeanFase0(ipCliente,infoNavegador,nombreFichero);

                req.setAttribute("bean",bean);
    
                //despachamos la solicitud a Fase0.jsp
                RequestDispatcher dispatcher = req.getRequestDispatcher("/p3/Fase0.jsp");
                dispatcher.forward(req,res);

            }else if(fase.equals("1")) {                       //CUANDO ES FASE1
                
                ArrayList<String> langs = miDataModel.getLangs();

                BeanFase1 bean = new BeanFase1(langs);

                req.setAttribute("bean",bean);

                //Pasamos el control a Fase1.jsp
                RequestDispatcher dispatcher = req.getRequestDispatcher("/p3/Fase1.jsp");
                dispatcher.forward(req,res);

            }else if(fase.equals("2")) {                       //CUANDO ES FASE2

                String lang = req.getParameter("plang");
                ArrayList<Cast> castList = miDataModel.getCast(lang);

                BeanFase2 bean = new BeanFase2(castList,lang);

                req.setAttribute("bean",bean);

                //pasamos el control a Fase2.jsp
                RequestDispatcher dispacher = req.getRequestDispatcher("/p3/Fase2.jsp");
                dispacher.forward(req,res);

            }else if(fase.equals("3")) {                       //CUANDO ES FASE3

                String idC = req.getParameter("pidC");
                String lang = req.getParameter("plang");
                ArrayList<Movie> movieList = miDataModel.getMovies(idC);

                BeanFase3 bean = new BeanFase3(movieList,idC,lang);

                req.setAttribute("bean",bean);

                //Pasamos el control a Fase3.jsp
                RequestDispatcher dispatcher = req.getRequestDispatcher("/p3/Fase3.jsp");
                dispatcher.forward(req,res);

            }else{
                out.println("no hay fase seleccionada");
            }

        }
    }      
}
