package examen1_ianbeltrand;

import java.util.Date;

public class Archivo extends Fichero{
    
    //Variables
    String Texto = "";
    
    //Constrcutores

    public Archivo() {
    }

    public Archivo(Date Creation, String UsuarioCreador, String Nombre, String NombreCarpeta, String Texto) {
        super(Creation, UsuarioCreador, Nombre, NombreCarpeta);
        this.Texto = Texto;
    }
    
    //CRUD
    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    @Override
    public String toString() {
        return "Archivo{" + "Texto=" + Texto + '}';
    }
    
    
}
