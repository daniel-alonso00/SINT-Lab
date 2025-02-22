package p3;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BeanFase3 implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<Movie> movieList;
    private String pidC;
    private String plang;

    public BeanFase3(){

    }
    public BeanFase3(ArrayList<Movie> movieList, String pidC, String plang){
        this.movieList = movieList;
        this.pidC = pidC;
        this.plang = plang;
    }

    public ArrayList<Movie> getmovieList(){
        return movieList;
    }
    public String getPidC(){
        return pidC;
    }
    public String getPlang(){
        return plang;
    }

    
    public void setmovieList(ArrayList<Movie> movieList){
        this.movieList = movieList;
    }
    public void setPidC(String pidC){
        this.pidC = pidC;
    }
    public void setPlang(String plang){
        this.plang = plang;
    }


}