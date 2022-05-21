package examen1_ianbeltrand;

import java.util.ArrayList;
import java.util.Date;

public class Carpeta extends Fichero{
    
    //Variables
    ArrayList<Fichero> ficheros = new ArrayList();
    
    //Constructor

    public Carpeta() {
    }

    public Carpeta(Date Creation, String UsuarioCreador, String Nombre, String NombreCarpeta) {
        super(Creation, UsuarioCreador, Nombre, NombreCarpeta);
    }
    
    //CRUD

    public ArrayList<Fichero> getFicheros() {
        return ficheros;
    }

    public void setFicheros(ArrayList<Fichero> ficheros) {
        this.ficheros = ficheros;
    }
    
    //Funciones
    public ArrayList<Fichero> ArrayListCarpeta(){
        return getFicheros();
    }
}
