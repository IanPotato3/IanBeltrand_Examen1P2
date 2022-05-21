package ianbeltrand_examen1p2;

import java.util.Scanner;

public class IanBeltrand_Examen1P2 {

    static AdmiPC admi = new AdmiPC();
    
    public static void Menu(){
        int Opcion = 0;
        
        while(Opcion != 3){
            boolean End = true;
            
            while(End){
                try{
                    Scanner lea = new Scanner(System.in).useDelimiter("\n");
                    
                    System.out.println("\n***MENU***" + 
                            "\n\t1 - CRUD PC" + 
                            "\n\t2 - Ingresar PC" + 
                            "\n\t3 - Salir" + 
                            "\n\nIngresar la opcion deseada: ");
                    Opcion = lea.nextInt();
                    
                    End = false;
                    
                }catch(Exception e){
                    System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO***");
                }
                
            }
            
            switch(Opcion){
                case 1:
                    while(Opcion != 5){
                        End = true;
                        
                        while(End){
                            try{
                                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                                System.out.println("\n\n***CRUD***" + 
                                        "\n\t1 - Agregar PC" + 
                                        "\n\t2 - Eliminar PC" + 
                                        "\n\t3 - Listar PC" + 
                                        "\n\t4 - Modificar PC" + 
                                        "\n\t5 - Salir" + 
                                        "\n\nIngrese la opcion deseada: ");
                                Opcion = lea.nextInt();
                                
                                End = false;
                            }catch(Exception e){
                                System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO***");
                            }
                        }
                        
                        switch(Opcion){
                            case 1:
                                admi.AgregarPC();
                                break;
                            case 2:
                                admi.EliminarPC();
                                break;
                            case 3:
                                admi.ListarPC();
                                break;
                            case 4:
                                admi.ModificarPC();
                                break;
                        }
                        
                    }
                    
                    break;
                case 2:
                    admi.Ingresar();
                    break;
            }
            
        }
    }
    
    public static void main(String[] args) {
        Menu();
    }
    
}

