package p3;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BeanFase2 implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<Cast> castList;
    private String plang;

    public BeanFase2(){

    }
    public BeanFase2(ArrayList<Cast> castList, String plang){
        this.castList = castList;
        this.plang = plang;
    }

    public ArrayList<Cast> getCastList(){
        return castList;
    }
    public String getPlang(){
        return plang;
    }

    
    public void setCastList(ArrayList<Cast> castList){
        this.castList = castList;
    }
    public void setPlang(String plang){
        this.plang = plang;
    }

}