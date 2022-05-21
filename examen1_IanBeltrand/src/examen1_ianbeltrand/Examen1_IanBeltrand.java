
package examen1_ianbeltrand;

import java.util.Date;
import javax.swing.JOptionPane;

public class Examen1_IanBeltrand {
    
    public static void Menu(){
        AdmiArchivos admi = new AdmiArchivos();
        int Opcion = 0;
        Carpeta CarpetaActual = admi.FileSystem;
        
        while(Opcion != 3){
            Opcion = Integer.parseInt(JOptionPane.showInputDialog("***** MENU *****" + 
                    "\n1 - Sistema Archivos" + 
                    "\n2 - Probar Recursiva" + 
                    "\n3 - Salir"));
            
            switch(Opcion){
                case 1:
                    while(Opcion != 7){
                        Opcion = Integer.parseInt(JOptionPane.showInputDialog("***** MENU ARCHIVOS *****" + 
                            "\n1 - Entrar en una SubCarpeta" + 
                            "\n2 - Regresar Carpeta Anterior" + 
                            "\n3 - Crear un Archivo" + 
                            "\n4 - Crear una Carpeta" + 
                            "\n5 - Listar Directorio Actual" + 
                            "\n6 - Listar todo el FileSystem" + 
                            "\n7 - Salir"));
                    
                        switch(Opcion){
                            case 1:
                                CarpetaActual = admi.EntrarSubCarpeta(admi.BuscarCarpeta(admi.FileSystem, CarpetaActual.getNombre()));
                                break;
                            case 2:
                                CarpetaActual = admi.Regresar(CarpetaActual);
                                break;
                            case 3:
                                admi.CrearArchivo(CarpetaActual);
                                break;
                            case 4:
                                admi.CrearCarpeta(CarpetaActual);
                                break;
                            case 5:
                                admi.ListarDirectorio(CarpetaActual);
                                break;
                            case 6:
                                break;
                        }
                    }
                    
                    break;
                case 2:
                    SumaParesColumna suma = new SumaParesColumna();
                    int [][] Matriz = new int[4][8];
                    int Contador = 0;

                    Matriz[0][0] = 2;
                    Matriz[1][2] = 3;
                    Matriz[2][1] = 8;
                    Matriz[0][1] = 3;
                    Matriz[0][2] = 2;
                    Matriz[2][6] = 9;
                    Matriz[1][3] = 4;
                    Matriz[3][3] = 5;
                    Matriz[0][4] = 6;
                    Matriz[0][7] = 1;
                    Matriz[1][5] = 4;
                    suma.ImprimirMatrizC(Matriz, 0, 0);
                    suma.SumaParesColumna(Matriz, 0, 0, Contador);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Menu();
    }
    
}
