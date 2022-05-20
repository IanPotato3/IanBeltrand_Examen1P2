package ianbeltrand_examen1p2;

import java.util.ArrayList;
import java.util.Scanner;

public class AdmiPC {
    
    ArrayList<Pc> PCs = new ArrayList();
        
    public Pc BuscarPC(String HostName){
        for (Pc pc : PCs) {
            if(pc.getHostname().equals(HostName)){
                return pc;
            }
        }
        
        return null;
    }
    
    //CRUD
    public void AgregarPC(){
        boolean End = true;
        int TipoPC = 0;
        
        while(End){
            
            try{
                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                System.out.println("\nTipo de PC" + 
                "\n\t1 - Escritorio" + 
                "\n\t2 - Laptop" + 
                "\n\nIngresar el tipo de PC con el que cuenta: ");
        
                TipoPC = lea.nextInt();
                
                if(TipoPC == 1 || TipoPC == 2){
                    End = false;
                }
                
            }catch(Exception e){
                System.out.println("***LA ENTRADA ES INCORRECTA, INTENTAR DE NUEVO***");
            }
            
        }
        
        switch(TipoPC){
            case 1:
                boolean end = true;
                
                while(end){
                    try{
                        Scanner lea = new Scanner(System.in).useDelimiter("\n");
                        boolean fin = true;
                        
                        System.out.println("Ingresar Direccion IP: ");
                        String IP = lea.next();
                        
                        System.out.println("Ingresar MascaraRed: ");
                        String MR = lea.next();
                        
                        String HN = "";
                        fin = true;
                        while(fin){
                            System.out.println("Ingresar Hostname: ");
                            HN = lea.next();
                            
                            if(BuscarPC(HN) == null){
                                fin = false;
                            }else{
                                System.out.println("\nAlguien ya cuenta con este nombre, favor escoge otro...");
                            }
                        }
                        
                        System.out.println("Tiene Targeta Grafica: " + 
                                "\n\t1 - Si" + 
                                "\n\t2 - No" + 
                                "\nIngresar el Numero de su respuesta: ");
                        int TGO = lea.nextInt();
                        boolean TG;
                        if(TGO == 1){
                            TG = true;
                        }else{
                            TG = false;
                        }
                        
                        System.out.println("Ingrese el Almacenamiento de su PC(GB): ");
                        int Almacenamiento = lea.nextInt();
                        
                        System.out.println("Ingrese el RAM de su PC(GB): ");
                        int RAM = lea.nextInt();
                        
                        System.out.println("Tipo de Almacenamiento" + 
                                "\n\t1 - HDD" + 
                                "\n\t2 - SSD" + 
                                "\nIngresar la opcion que aplique: ");
                        int TA = lea.nextInt();
                        String Tipo = "";
                        if(TA == 1){
                            Tipo = "HDD";
                        }else{
                            Tipo = "SSD";
                        }
                        
                        PC_Escritorio escritorio = new PC_Escritorio(TG, IP, MR, HN, RAM, Almacenamiento, Tipo);
                        PCs.add(escritorio);
                        end = false;
                    }catch(Exception e){
                        System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO***");
                    }
                }
                
                break;
            case 2:
                
                end = true;
                while(end){
                    try{
                        Scanner lea = new Scanner(System.in).useDelimiter("\n");
                        boolean fin = true;
                        
                        System.out.println("Ingresar Direccion IP: ");
                        String IP = lea.next();
                        
                        System.out.println("Ingresar MascaraRed: ");
                        String MR = lea.next();
                        
                        String HN = "";
                        fin = true;
                        while(fin){
                            System.out.println("Ingresar Hostname: ");
                            HN = lea.next();
                            
                            if(BuscarPC(HN) == null){
                                fin = false;
                            }else{
                                System.out.println("\nAlguien ya cuenta con este nombre, favor escoge otro...");
                            }
                        }
                        
                        System.out.println("Tiene RGB: " + 
                                "\n\t1 - Si" + 
                                "\n\t2 - No" + 
                                "\nIngresar la opcion deseada: ");
                        int RGBO = lea.nextInt();
                        boolean RGB;
                        if(RGBO == 1){
                            RGB = true;
                        }else{
                            RGB = false;
                        }
                        
                        System.out.println("Ingresar la definicion se su pantalla(Ej: 1080, 720, 480, ...)");
                        int Definicion = lea.nextInt();
                        
                        System.out.println("Ingresar la Marca de su PC: ");
                        String Marca = lea.next();
                        
                        Laptop laptop = new Laptop(RGB, IP, MR, HN, Definicion, Marca);
                        PCs.add(laptop);
                        
                        end  = false;
                        
                    }catch(Exception e){
                        System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO***");
                    }
                }
                break;
        }
        
    }
    
    public void EliminarPC(){
        boolean End = true;
        
        while(End){
            String HN = "";
            try{
                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                System.out.println("\nIngrese el HostName de la PC a eliminar: ");
                HN = lea.next();
                
                Pc pc = BuscarPC(HN);
                PCs.remove(pc);
                
                End  = false;
                
            }catch(Exception e){
                System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO");
                End = false;
            }
        }
        
        System.out.println("\n***PC ELIMINADA EXITOSAMENTE***");
        
    }
    
    public void ListarPC(){
        boolean End = true;
        
        String HN = "";
        while(End){
            try{
                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                System.out.println("\nIngresar HostName de la PC a listar: ");
                HN = lea.next();
                
                if(BuscarPC(HN) != null){
                    Pc pc = BuscarPC(HN);
                
                    if(pc instanceof Laptop){
                        System.out.println("\nHostname: " + pc.getHostname() + 
                                "\nIP: " + pc.getDireccionIP() + 
                                "\nMascara Red: " + pc.getMascaraRed() + 
                                "\nDefinicion: " + ((Laptop) pc).getDefinicion() + 
                                "\nMarca: " + ((Laptop) pc).getMarca() + 
                                "\nRGB: " + ((Laptop) pc).isRGB());
                        End = false;
                    }else{
                        if(pc instanceof PC_Escritorio){
                            System.out.println("\nHostname: " + pc.getHostname() + 
                                "\nIP: " + pc.getDireccionIP() + 
                                "\nMascara Red: " + pc.getMascaraRed() + 
                                "\nAlmacenamiento: " + ((PC_Escritorio) pc).getAlmacenamiento() + 
                                "\nTipo de Almacenamiento: " + ((PC_Escritorio) pc).getTipoAlmacenamiento() + 
                                "\nRAM: " + ((PC_Escritorio) pc).getRAM() + 
                                "\nTargeta Grafica: " + ((PC_Escritorio) pc).isTG());
                            End = false;
                        }
                    }
                }else{
                    System.out.println("\n***LA PC INGRESADA NO EXISTE, INTENTAR DE NUEVO");
                }
                
            }catch(Exception e){
                System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO");
            }
        }
    }
    
    public void ModificarPC(){
        boolean End = true;
        int Opcion = 0;
        String HN = "";
        boolean fin = true;
        
        while(End){
            try{
                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                System.out.println("\nNombre de la PC a Modificar: ");
                HN = lea.next();
                
                if(BuscarPC(HN) != null){
                    Pc pc = BuscarPC(HN);
                    
                    if(pc instanceof Laptop){
                        System.out.println("\n\nEspecificacion a modificar: " + 
                                "\n\t1 - RGB" + 
                                "\n\t2 - Definicion" + 
                                "\n\t3 - Marca" + 
                                "\n\t4 - Hostname" + 
                                "\n\n Ingresar la Opcion que desee: ");
                        Opcion = lea.nextInt();
                        switch(Opcion){
                            case 1:
                                System.out.println("Tiene RGB: " + 
                                "\n\t1 - Si" + 
                                "\n\t2 - No" + 
                                "\nIngresar la opcion deseada: ");
                                int RGBO = lea.nextInt();
                                boolean RGB;
                                if(RGBO == 1){
                                    ((Laptop) pc).setRGB(true);
                                }else{
                                    ((Laptop) pc).setRGB(false);
                                }
                                break;
                            case 2:
                                System.out.println("Ingresar la definicion se su pantalla(Ej: 1080, 720, 480, ...)");
                                int Definicion = lea.nextInt();
                                
                                ((Laptop) pc).setDefinicion(Definicion);
                                break;
                            case 3:
                                System.out.println("Ingresar la Marca de su PC: ");
                                String Marca = lea.next();
                                
                                ((Laptop) pc).setMarca(Marca);
                                break;
                            case 4:
                                HN = "";
                                fin = true;
                                while(fin){
                                    System.out.println("Ingresar Hostname: ");
                                    HN = lea.next();

                                    if(BuscarPC(HN) == null){
                                        pc.setHostname(HN);
                                        fin = false;
                                    }else{
                                        System.out.println("\nAlguien ya cuenta con este nombre, favor escoge otro...");
                                    }
                                }
                                break;
                        }
                    }else{
                        if(pc instanceof PC_Escritorio){
                            System.out.println("\n\nEspecificacion a modificar: " + 
                                "\n\t1 - Almacenamiento" + 
                                "\n\t2 - RAM" + 
                                "\n\t3 - Tipo de Almacenamiento" + 
                                "\n\t4 - Targeta Grafica: " +
                                "\n\t5 - Hostname" + 
                                "\n\n Ingresar la Opcion que desee: ");
                            Opcion = lea.nextInt();
                            switch(Opcion){
                                case 1:
                                    System.out.println("Ingrese el Almacenamiento de su PC(GB): ");
                                    int Almacenamiento = lea.nextInt();
                                    
                                    ((PC_Escritorio) pc).setAlmacenamiento(Almacenamiento);
                                    break;
                                case 2:
                                    System.out.println("Ingrese el RAM de su PC(GB): ");
                                    int RAM = lea.nextInt();
                                    
                                    ((PC_Escritorio) pc).setRAM(RAM);
                                    break;
                                case 3:
                                    System.out.println("Tipo de Almacenamiento" + 
                                            "\n\t1 - HDD" + 
                                            "\n\t2 - SSD" + 
                                            "\nIngresar la opcion que aplique: ");
                                    int TA = lea.nextInt();
                                    String Tipo = "";
                                    if(TA == 1){
                                        Tipo = "HDD";
                                        ((PC_Escritorio) pc).setTipoAlmacenamiento(Tipo);
                                    }else{
                                        Tipo = "SSD";
                                        ((PC_Escritorio) pc).setTipoAlmacenamiento(Tipo);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Tiene Targeta Grafica: " + 
                                            "\n\t1 - Si" + 
                                            "\n\t2 - No" + 
                                            "\nIngresar el Numero de su respuesta: ");
                                    int TGO = lea.nextInt();
                                    boolean TG;
                                    if(TGO == 1){
                                        ((PC_Escritorio) pc).setTG(true);
                                    }else{
                                        ((PC_Escritorio) pc).setTG(false);
                                    }
                                    break;
                                case 5:
                                    HN = "";
                                    fin = true;
                                    while(fin){
                                        System.out.println("Ingresar Hostname: ");
                                        HN = lea.next();

                                        if(BuscarPC(HN) == null){
                                            pc.setHostname(HN);
                                            fin = false;
                                        }else{
                                            System.out.println("\nAlguien ya cuenta con este nombre, favor escoge otro...");
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }else{
                    System.out.println("\n***LA PC INGRESADA NO EXISTE***");
                }
                End = false;
            }catch(Exception e){
                System.out.println("\n***ENTRADA INVALIDA, INTENTAR DE NUEVO***");
            }
            
        }
        
        
    }
    
    public void Ingresar(){
        boolean End  = true;
        
        while(End){
            try{
                
            }catch(Exception e){
                System.out.println("\n***ENTRADA NO VALIDA, INTENTAR DE NUEVO***");
            }
        }
    }
    
}
