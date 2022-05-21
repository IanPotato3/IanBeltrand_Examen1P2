
package examen1_ianbeltrand;

public class SumaParesColumna {
    
    //Constructor
    public SumaParesColumna(){
        
    }
    
    //Funciones
        public static void SumaParesColumna(int Matriz[][], int f, int c, int Contador){
        if(f == Matriz.length - 1 && c == Matriz[0].length - 1){
            if(Matriz[f][c] % 2 == 0){
                Contador = Contador + Matriz[f][c];
            }
            System.out.print("\tColumna[" + c + "]: " + Contador);
        }else{
            if(f == Matriz.length - 1){
                if(Matriz[f][c] % 2 == 0){
                    Contador = Contador + Matriz[f][c];
                }
                System.out.print("\tColumna[" + c + "]: " + Contador);
                Contador = 0;
                SumaParesColumna(Matriz, 0, c + 1, Contador); 
            }else{
                if(Matriz[f][c] % 2 == 0){
                    Contador = Contador + Matriz[f][c];
                }
                SumaParesColumna(Matriz, f + 1, c, Contador);
            }
        }
    }
    
    public static void ImprimirMatrizC(int Matriz[][], int f, int c){
        if(f == Matriz.length - 1 && c == Matriz[0].length - 1){
            System.out.print( Matriz[f][c] + " \n\n");
        }else{
            if(c == Matriz[0].length - 1){
                System.out.println(Matriz[f][c]);
                ImprimirMatrizC(Matriz, f + 1, 0);
                
            }else{
                System.out.print( Matriz[f][c] + " ");
                ImprimirMatrizC(Matriz, f, c + 1);
            }
        }
    }
    
}
