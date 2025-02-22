package p2;

public class Movie implements Comparable<Movie>{

    private String idM;
    private String title;
    private int year; 
    private String langs; 

    //Constructor vacio
    public Movie(){

    }
    
    //Constructor con argumentos
    public Movie(String idM, String title, int year, String langs){
        this.idM = idM;
        this.title = title;
        this.year = year;
        this.langs = langs;
    }

    //GETTERS
    public String getIdM(){
        return idM;
    }
    public String getTitle(){
        return title;
    }
    public int getYear(){
        return year;
    }
    public String getLangs(){
        return langs;
    }

    //SETTERS
    public void setIdM(String idM){
        this.idM = idM;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setLangs(String langs){
        this.langs = langs;
    }

    @Override
    public String toString() {
        return ("idM: "+idM+" ,Title: "+title+" ,Year: "+year+" ,Langs: "+langs);
    }

    @Override
    public int compareTo(Movie other){
        return this.idM.compareTo(other.idM);
    }
    
}
