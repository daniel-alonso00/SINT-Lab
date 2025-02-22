package p3;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

public class BeanFase1 implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<String> langs;

    public BeanFase1(){

    }
    public BeanFase1(ArrayList<String> langs){
        this.langs = langs;
    }

    public ArrayList<String> getLangs(){
        return langs;
    }
    
    public void setLangs(ArrayList<String> langs){
        this.langs = langs;
    }

}