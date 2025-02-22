package p2;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class DataModel{
    private Document xmlFile;

    //Constructor vacio
    public DataModel(){

    }

    //Constructor con argumentos
    public DataModel(String URLxmlFile){

        try{
            // Crear el DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Parsear el archivo XML
            Document xmlFile = db.parse(URLxmlFile);
            this.xmlFile = xmlFile;

        }catch (Exception e){
            System.out.println("Error en la inicializacion");
            e.printStackTrace();
        }

    }

    //Funcion que devuelve un array de los idiomas
    public ArrayList<String> getLangs(){
        NodeList listaPeliculas = xmlFile.getElementsByTagName("movie");
        ArrayList<String> listLangs = new ArrayList<>();

        for(int i = 0; i<listaPeliculas.getLength(); i++){
            Element movie = (Element)listaPeliculas.item(i);
            String idiomas = movie.getAttribute("langs");

            String[] words = idiomas.split(" ");    //langs tiene varios divididos por un espacio ="es en it"

            for(int j = 0; j<words.length; j++){

                if (!listLangs.contains(words[j])){     //Comprobamos que el idioma no este repetido
                    listLangs.add(words[j]);
                }
            }
        }
        Collections.sort(listLangs);
        return listLangs;
    }

    //Funcion que devuelve un array de cast segun un idioma
    public ArrayList<Cast> getCast(String lang){

        NodeList movies = xmlFile.getElementsByTagName("movie");

        ArrayList<Cast> castList = new ArrayList<>();   //Creamos el ArrayLis del cast

        //comprobamos que la pelicula tenga el idioma que recibimos como argumento
        for(int i = 0; i<movies.getLength(); i++){

            Element movieInstant = (Element)movies.item(i);
            String idiomas = movieInstant.getAttribute("langs");

            String[] idiomasInstant = idiomas.split(" ");  //dividimos los 3 idiomas en cadenas separadas

            for (int j = 0; j<idiomasInstant.length; j++){

                if(idiomasInstant[j].equals(lang)){  //si la pelicula tiene el idioma que queremos entonces entramos a buscar su cast

                    //Buscamos los nodos que sean CAST
                    NodeList cast = movieInstant.getElementsByTagName("cast");

                    for(int k = 0; k<cast.getLength(); k++){

                        //Declaramos las variables a null para que en cada iteraccion se reinicien
                        String name = null;
                        String role = null;
                        String idC = null;

                        Element castInstant = (Element)cast.item(k);    //cada nodo tipo cast hijo de movie

                        idC = castInstant.getAttribute("idC");
                        name = castInstant.getElementsByTagName("name").item(0).getTextContent();
                        role = castInstant.getElementsByTagName("role").item(0).getTextContent();

                        Cast objetoCast = new Cast(idC, name, role);    //creamos el objeto tipo Cast

                        if(!castList.contains(objetoCast)){     //Comprobamos que el objeto no este ya en la lista
                            castList.add(objetoCast);
                        }               
                    }
                }
            }
        }
        Collections.sort(castList);
        return castList;
    }

    //Funcion que devuelve un array de peliculas segun un cast
    public ArrayList<Movie> getMovies(String idC){

        ArrayList<Movie> listMovies = new ArrayList<>();    //Creamos la lista donde vamos a meter las peliculas que cuadren

        NodeList movies = xmlFile.getElementsByTagName("movie");    //Sacamos un Nodelist de las peliculas

        for (int i = 0; i<movies.getLength(); i++){
            Element movieInstant = (Element)movies.item(i);
            
            NodeList cast = movieInstant.getElementsByTagName("cast");

            for (int j = 0; j<cast.getLength(); j++){
                Element castInstant  = (Element)cast.item(j);

                String idcInstant = castInstant.getAttribute("idC");    //Sacamos el idC del cast en el que estamos
                
                if(idC.equals(idcInstant)){  //entonces la pelicula corresponde al actor que buscamos

                    //Sacamos los datos de la pelicula por si coincide que tiene un cast que buscamos
                    String idM = movieInstant.getAttribute("idM");
                    String langs = movieInstant.getAttribute("langs");
                    String title = movieInstant.getElementsByTagName("title").item(0).getTextContent();
                    String yearText = movieInstant.getElementsByTagName("year").item(0).getTextContent();
                    int year = Integer.parseInt(yearText);

                    Movie objectMovie = new Movie(idM, title, year, langs);
                    listMovies.add(objectMovie);
                }
            }
        }
        Collections.sort(listMovies);
        return listMovies;
    }
}
