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
    
    public Pc BuscarIP(String IP){
        for (Pc PC : PCs) {
            if(PC.getDireccionIP().equals(IP)){
                return PC;
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
                        Scanner lea = new Scanner(System.in);
                        boolean fin = true;
                        
                        String IP = "";
                        fin = true;
                        while(fin){
                            System.out.println("Ingresar Direccion IP: ");
                            IP = lea.next();
                            
                            if(Validar(IP)){
                                fin = false;
                            }else{
                                System.out.println("\n***IP NO VALIDA INTENTAR DE NUEVO***");
                            }
                        }
                        
                        String MR = "";
                        fin = true;
                        while(fin){
                            System.out.println("Ingresar Mascara de Red: ");
                            MR = lea.next();
                            
                            if(Validar(MR)){
                                fin = false;
                            }else{
                                System.out.println("\n***IP NO VALIDA INTENTAR DE NUEVO***");
                            }
                        }
                        
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
        String Hostname = "";
        
        while(End){
            try{
                Scanner lea = new Scanner(System.in).useDelimiter("\n");
                System.out.println("\n\nHostname de la computadora a ingresar: ");
                Hostname = lea.next();
                
                if(BuscarPC(Hostname) != null){
                    boolean fin = true;
                    
                    while(fin){
                        System.out.print("\n\n" + Hostname + "#");
                        String Comando = lea.next();
                        String CasoPing = "";
                        
                        if(Comando.equals("show") || Comando.equals("exit")){
                            CasoPing = Comando;
                        }else{
                            Scanner sc = new Scanner(Comando);
                            sc.useDelimiter("_");
                        
                            CasoPing = sc.next();
                        }
                        
                        switch(CasoPing){
                            case "show":
                                show(BuscarPC(Hostname));
                                break;
                            case "ping":
                                ArrayList<String> partesComando = new ArrayList();
                                
                                Scanner sc = new Scanner(Comando);
                                sc.useDelimiter("_");
                                
                                while(sc.hasNext()){
                                    String next = sc.next();
                                    partesComando.add(next);
                                }
                                
                                if(Validar(partesComando.get(1))){
                                    ping(Hostname, partesComando.get(1));
                                }else{
                                    System.out.println("\nComando Incorrecto");
                                }
                                                                
                                Validar(BuscarPC(Hostname).getDireccionIP());
                                break;
                            case "exit":
                                fin = false;
                                break;
                        }
                    }
                                        
                    End = false;
                }else{
                    System.out.println("\n***HOSTNAME INGRESADO NO EXISTE, INTENTAR DE NUEVO***");
                    End = false;
                }
            }catch(Exception e){
                System.out.println("\n***ENTRADA NO VALIDA, INTENTAR DE NUEVO***");
            }
        }
    }
    
    public void ping(String Hostname, String Entrada){
        ArrayList<String> partes = new ArrayList();
        ArrayList<String> partesHost = new ArrayList();
        ArrayList<Integer> partesInt = new ArrayList();
        ArrayList<Integer> partesIntHost = new ArrayList();
        ArrayList<String> partesBi = new ArrayList();
        ArrayList<String> partesBiHost = new ArrayList();
        
        //Entrada
        Scanner Codigo = new Scanner(Entrada);
        Codigo.useDelimiter("\\.");
        while(Codigo.hasNext()){
            String next = Codigo.next();
            partes.add(next);
        }
        
        for (int i = 0; i < 4; i++) {
            partesInt.add(Integer.parseInt(partes.get(i))); 
        }   
        
        for (Integer integer : partesInt) {
            partesBi.add(Integer.toBinaryString(integer));
        }
        
        //Host
        Scanner CodigoHost = new Scanner(BuscarPC(Hostname).getDireccionIP());
        Codigo.useDelimiter("\\.");
        while(CodigoHost.hasNext()){
            String next = CodigoHost.next();
            partesHost.add(next);
        }
        
        for (int i = 0; i < 4; i++) {
            partesIntHost.add(Integer.parseInt(partesHost.get(i))); 
        }   
        
        for (Integer integer : partesIntHost) {
            partesBiHost.add(Integer.toBinaryString(integer));
        }
        
        if(BuscarIP(Entrada) == null){
            System.out.println("\nPinging to " + Entrada + " with 32 bytes of data: " + 
                    "\nRequest timed out." + 
                    "\nRequest timed out." + 
                    "\nRequest timed out." + 
                    "\nRequest timed out." + 
                    "\n\nPing statistics for " + Entrada + ": " + 
                    "\n\tPackets: Sent = 4, Recieved = 0, Lost = 4 (100% loss)");
        }else{
            if(comparar(partesBiHost, partesBi)){
                System.out.println("\nPinging to " + Entrada + " with 32 bytes of data: " + 
                    "\nReplay from " + Entrada + ": " + "bytes=32 time37ms" + "TTL=46" + 
                    "\nReplay from " + Entrada + ": " + "bytes=32 time37ms" + "TTL=46" + 
                    "\nReplay from " + Entrada + ": " + "bytes=32 time37ms" + "TTL=46" + 
                    "\nReplay from " + Entrada + ": " + "bytes=32 time37ms" + "TTL=46" + 
                    "\n\nPing statistics for " + Entrada + ": " + 
                    "\n\tPackets: Sent = 4, Recieved = 4, Lost = 0 (0% loss)");
            }else{
                System.out.println("\nPinging to " + Entrada + " with 32 bytes of data: " + 
                    "\nReplay from " + Entrada + ": " + "Destination Host unreachable" + 
                    "\nReplay from " + Entrada + ": " + "Destination Host unreachable" + 
                    "\nReplay from " + Entrada + ": " + "Destination Host unreachable" + 
                    "\nReplay from " + Entrada + ": " + "Destination Host unreachable" + 
                    "\n\nPing statistics for " + Entrada + ": " + 
                    "\n\tPackets: Sent = 4, Recieved = 4, Lost = 0 (0% loss)");
            }
        }
    }
    
    public void show(Pc pc){
        System.out.println("\n\nIP: " + pc.getDireccionIP() + 
                "\nMascara de Red: " + pc.getMascaraRed());
    }
    
    public boolean comparar(ArrayList<String> BiHost, ArrayList<String> Bi){
        String Binario = "";
        String BinarioHost = "";
        
        for (String string : Bi) {
            Binario = Binario+string;
        }
        
        for (String string : BiHost) {
            BinarioHost = BinarioHost + string; 
        }
        
        if(BinarioHost.equals(Binario)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean Validar(String Validando){
        int Contador = 0;
        ArrayList<String> partes = new ArrayList();
        ArrayList<Integer> partesInt = new ArrayList();
        
        Scanner Codigo = new Scanner(Validando);
        Codigo.useDelimiter("\\.");
        while(Codigo.hasNext()){
            String next = Codigo.next();
            partes.add(next);
            Contador = Contador + 1;
        }
        
        if(Contador == 4){
            
            for (int i = 0; i < 4; i++) {
                partesInt.add(Integer.parseInt(partes.get(i))); 
            }

            for (Integer integer : partesInt) {
                if(integer < 0 || integer > 255){
                    return false;
                }
                
                return true;
            }   
        }else{
            return false;
        }
        
        return false;
    }
}
