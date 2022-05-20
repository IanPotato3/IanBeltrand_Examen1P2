package ianbeltrand_examen1p2;

public class PC_Escritorio extends Pc{
    
    int RAM = 0;
    int Almacenamiento = 0;
    String TipoAlmacenamiento = "";
    boolean TG;

    public PC_Escritorio() {
        
    }

    public PC_Escritorio(boolean TG, String DireccionIP, String MascaraRed, String Hostname, int RAM, int Almacenamiento, String Tipo) {
        super(DireccionIP, MascaraRed, Hostname);
        this.TG = TG;
        this.Almacenamiento = Almacenamiento;
        this.RAM = RAM;
        this.TipoAlmacenamiento = Tipo;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getAlmacenamiento() {
        return Almacenamiento;
    }

    public void setAlmacenamiento(int Almacenamiento) {
        this.Almacenamiento = Almacenamiento;
    }

    public String getTipoAlmacenamiento() {
        return TipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(String TipoAlmacenamiento) {
        this.TipoAlmacenamiento = TipoAlmacenamiento;
    }

    public boolean isTG() {
        return TG;
    }

    public void setTG(boolean TG) {
        this.TG = TG;
    }

    @Override
    public String toString() {
        return "PC_Escritorio{" + "RAM=" + RAM + ", Almacenamiento=" + Almacenamiento + ", TipoAlmacenamiento=" + TipoAlmacenamiento + ", TG=" + TG + '}';
    }
    
    
    
}
