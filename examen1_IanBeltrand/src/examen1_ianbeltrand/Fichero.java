package examen1_ianbeltrand;

import java.util.ArrayList;
import java.util.Date;

public class Fichero {
    
    //Variables
    int Size = 0;
    Date Creation;
    String UsuarioCreador;
    String Nombre;
    String NombreCarpeta;
    
    //Constructor
    public Fichero() {
    }

    public Fichero(Date Creation, String UsuarioCreador, String Nombre, String NombreCarpeta) {
        this.Creation = Creation;
        this.UsuarioCreador = UsuarioCreador;
        this.Nombre = Nombre;
        this.NombreCarpeta = NombreCarpeta;
    }
    
    //CRUD

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public Date getCreation() {
        return Creation;
    }

    public void setCreation(Date Creation) {
        this.Creation = Creation;
    }

    public String getUsuarioCreador() {
        return UsuarioCreador;
    }

    public void setUsuarioCreador(String UsuarioCreador) {
        this.UsuarioCreador = UsuarioCreador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreCarpeta() {
        return NombreCarpeta;
    }

    public void setNombreCarpeta(String NombreCarpeta) {
        this.NombreCarpeta = NombreCarpeta;
    }

    @Override
    public String toString() {
        return "Fichero{" + "Size=" + Size + ", Creation=" + Creation + ", UsuarioCreador=" + UsuarioCreador + ", Nombre=" + Nombre + ", NombreCarpeta=" + NombreCarpeta + '}';
    }
    
    public ArrayList<Fichero> ArrayListCarpeta(){
        return null;
    }
}
