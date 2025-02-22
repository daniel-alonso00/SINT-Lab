package p3;
import java.io.*;
import java.io.Serializable;

public class BeanFase0 implements Serializable{

    private static final long serialVersionUID = 1L;

    private String ipCliente;
    private String infoNavegador;
    private String nombreFichero;


    public BeanFase0(){

    }

    public BeanFase0(String ipCliente, String infoNavegador, String nombreFichero){
        this.ipCliente = ipCliente;
        this.infoNavegador = infoNavegador;
        this.nombreFichero = nombreFichero;

    }

    public String getIpCliente(){
        return ipCliente;
    }
    public String getInfoNavegador(){
        return infoNavegador;
    }
    public String getNombreFichero(){
        return nombreFichero;
    }

    public void setIpCliente(String ipCliente){
        this.ipCliente = ipCliente;
    }

    public void setInfoNavegador(String infoNavegador){
        this.infoNavegador = infoNavegador;
    }
    public void setNombreFichero(String nombreFichero){
        this.nombreFichero = nombreFichero;
    }
    



}