package examen1_ianbeltrand;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class AdmiArchivos {
    
    //Variables
    Date Ahora = new Date();
    Carpeta FileSystem = new Carpeta(Ahora, JOptionPane.showInputDialog("Ingrese su nombre: "), "FileSystem", "FileSystem");
    //Constrcutor
    public AdmiArchivos(){
        
    }
    
    //Funciones
    public Carpeta BuscarCarpeta(Carpeta carpeta, String Nombre){
        Carpeta carpetaB = FileSystem;
        
        if(Nombre.equals("FileSystem")){
            return FileSystem;
        }else{
            for (Fichero fichero : carpetaB.getFicheros()) {
                if(fichero.getNombre().equals(Nombre) && fichero instanceof Carpeta){
                    return (Carpeta)fichero;
                }else{
                    if(fichero instanceof Carpeta){
                        carpetaB = (Carpeta)fichero;
                        BuscarCarpeta(carpetaB, Nombre);
                    }
                }
            }
        }
        
        return null;
    }
    
    public String ImprimirCarpeta(ArrayList<Fichero> ficheros){
        String Salida = "*** FICHEROS ***";
        int Contador = 1;
        
        if(ficheros.isEmpty()){
            Salida = Salida + "\n\n*** LA CARPETA SE ENCUENTRA VACIA ***";
        }else{
            for (Fichero fichero : ficheros) {
                Salida = Salida + "\n" + Contador + " - " + fichero.getNombre();
                Contador = Contador + 1;
            }
            
        }
        
        return Salida;
    }
    
    public Carpeta EntrarSubCarpeta(Carpeta CarpetaActual){
        if(CarpetaActual.getFicheros().isEmpty()){
            JOptionPane.showMessageDialog(null, "*** LA CARPETA ESTA VACIA ***");
            return CarpetaActual;
        }else{
            int Ncarpeta = Integer.parseInt(JOptionPane.showInputDialog(ImprimirCarpeta(CarpetaActual.ArrayListCarpeta()) + 
                "\n\nSeleccione la Carpeta o Archivo al que desea ingresar: "));
                
            if(CarpetaActual.getFicheros().get(Ncarpeta - 1) instanceof Archivo){
                JOptionPane.showMessageDialog(null, CarpetaActual.ArrayListCarpeta().get(Ncarpeta - 1).toString());
                return CarpetaActual;
            }else{
                return (Carpeta)CarpetaActual.ArrayListCarpeta().get(Ncarpeta - 1);
            }
        } 
        
        
    }
        
    public Carpeta Regresar(Carpeta CarpetaActual){
        return BuscarCarpeta(FileSystem, CarpetaActual.getNombreCarpeta());
    }
    
    public void CrearArchivo(Carpeta CarpetaActual){
        Archivo archivo = new Archivo(new Date(), FileSystem.getUsuarioCreador(), JOptionPane.showInputDialog("Nombre del archivo: "), CarpetaActual.getNombre(), JOptionPane.showInputDialog("Texto del archivo: "));
        CarpetaActual.getFicheros().add(archivo);
    }
    
    public void CrearCarpeta(Carpeta CarpetaActual){
        Carpeta carpeta = new Carpeta(new Date(), FileSystem.getUsuarioCreador(), JOptionPane.showInputDialog("Nombre carpeta: "), CarpetaActual.getNombre());
        CarpetaActual.getFicheros().add(carpeta);
    }
    
    public void ListarDirectorio(Carpeta CarpetaActual){
        JOptionPane.showMessageDialog(null, ImprimirCarpeta(CarpetaActual.getFicheros()));
    }
}
