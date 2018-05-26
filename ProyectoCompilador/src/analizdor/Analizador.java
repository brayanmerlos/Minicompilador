package analizdor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Brayan Merlos
 */
public class Analizador {
  static Lexico m=new Lexico();
  static Sintactico s=new Sintactico();
  
  public static String linea;
  public static String Ubicacion = "C:\\Compiladores", Nombre="\\tokens.txt";
  
public String codigo() throws FileNotFoundException, IOException{
      
          FileReader fr = new FileReader(Ubicacion+Nombre);
          BufferedReader br = new BufferedReader(fr);
          
         String lineaI;
         String codigo = "";
         while((lineaI=br.readLine())!=null){
             codigo +=lineaI;
      } 
          return codigo;
  }
  
public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // TODO code application logic here    
      
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
    
      try {
         
         archivo = new File (Ubicacion,Nombre);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         
         // Lectura del fichero
         System.out.println("    TABLA DE SIMBOLOS   ");
         System.out.println("====================================");
         while((linea=br.readLine())!=null){
             m.analizar(linea); 
         }   
      }    
      catch(Exception e){
         e.printStackTrace();
      }finally{
         
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
    }
    if(m.errorlex){  
    System.out.println();
    System.out.println("    TABLA DE ERRORES LEXICOS    ");
    System.out.println("==========================================");
   for (int i = 0; i < m.errorl.size(); i++) {
        System.out.println(m.errorl.get(i)+"    "+"Cadena no reconocida");
    }
    }else{
    System.out.println();
    System.out.println("    ANALISIS SINTACTICO    ");
    System.out.println("==========================================");
   s.AnalizarSintac(m.tokens);
   s.Equilibrio();

    if(s.error){
    System.out.println();
    System.out.println("    TABLA DE ERRORES SINTACTICOS    ");
    System.out.println("==========================================");
    for(int i=0;i<s.errors.size();i++){
       System.out.println(s.errors.get(i));
    }
    s.Equilibrio();
    }else{
    System.out.println();
    System.out.println("    ANALISIS SEMANTICO");
    System.out.println("==========================================");
        
    }
    }
    } 
}