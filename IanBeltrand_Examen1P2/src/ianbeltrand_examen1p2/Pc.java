package ianbeltrand_examen1p2;

public class Pc {
    
    String DireccionIP = "";
    String MascaraRed = "";
    String Hostname = "";

    public Pc() {
        
    }

    public Pc(String DireccionIP, String MascaraRed, String Hostname){
        this.DireccionIP = DireccionIP;
        this.Hostname = Hostname;
        this.MascaraRed = MascaraRed;
    }
    
    public String getDireccionIP() {
        return DireccionIP;
    }

    public void setDireccionIP(String DireccionIP) {
        this.DireccionIP = DireccionIP;
    }

    public String getMascaraRed() {
        return MascaraRed;
    }

    public void setMascaraRed(String MascaraRed) {
        this.MascaraRed = MascaraRed;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String Hostname) {
        this.Hostname = Hostname;
    }

    @Override
    public String toString() {
        return "Pc{" + "DireccionIP=" + DireccionIP + ", MascaraRed=" + MascaraRed + ", Hostname=" + Hostname + '}';
    }
    
    
}
