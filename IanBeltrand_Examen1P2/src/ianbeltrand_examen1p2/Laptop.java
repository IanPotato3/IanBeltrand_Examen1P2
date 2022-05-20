package ianbeltrand_examen1p2;

public class Laptop extends Pc{
    
    String Marca = "";
    int Definicion = 0;
    boolean RGB;

    public Laptop() {
        
    }

    public Laptop(boolean RGB, String DireccionIP, String MascaraRed, String Hostname, int Definicion, String Marca) {
        super(DireccionIP, MascaraRed, Hostname);
        this.RGB = RGB;
        this.Definicion = Definicion;
        this.Marca = Marca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getDefinicion() {
        return Definicion;
    }

    public void setDefinicion(int Definicion) {
        this.Definicion = Definicion;
    }

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }

    @Override
    public String toString() {
        return "Laptop{" + "Marca=" + Marca + ", Definicion=" + Definicion + ", RGB=" + RGB + '}';
    }
    
    
}
