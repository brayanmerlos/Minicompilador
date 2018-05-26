package analizdor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Brayan Merlos
 */
public class Sintactico {
    int parentesis=0;
    Lexico l=new Lexico();
    public ArrayList<String> errors=new ArrayList<String>();
    Stack pc = new Stack();
    Stack pa = new Stack();
    
    boolean error;
    
public void AnalizarSintac(ArrayList<String> t1){
    
    for (int i = 0; i < t1.size(); i++) {
        
        if(CrearTabla(t1.get(i))){
            System.out.println("Linea: "+i+" Creacion de Tabla");
            System.out.println("Linea: "+i+" Modificacion de Tabla");
//        }else if(Select(t1.get(i))){
            System.out.println("Linea: "+i+" Seleccion");
        }else if(Insert(t1.get(i))){
            System.out.println("Linea: "+i+" Insercion");
            pa.add("(");
            System.out.println("Linea: "+i+" Operador Relacional");
            parentesis++;
        }else if(t1.get(i).contains(")")){
            pc.add(")");
             System.out.println("Linea: "+i+" Operador Relacional");
             parentesis--;
        
        }else if(t1.get(i).equals("")){
             
         }else{
             errors.add("Linea: "+i+" Error Sintactico");
             error=true;
         }  
        }     
    }

public void Equilibrio(){
    if(pa.size()!=pc.size())
        {
            errors.add("Error Sintactico hacen falta parentesis");
            error=true;
        }
        else{
            System.out.println("Parentesis equilibrados");
        }
}

public boolean Insert(String linea){
    String linea2=linea.replace(",", "");

    int result1=linea2.compareToIgnoreCase("INSERTINTO");
    int result2=linea2.compareToIgnoreCase("VALUES()");
    int result3=linea2.compareToIgnoreCase("INSERTINTOVALUES()");
    if(result1==0||result2==0||result3==0){
        return true;
    }else{
        return false;
    }       
}

public boolean CrearTabla(String linea){
    int result1=linea.compareToIgnoreCase("CREATETABLE");
    if(result1==0){
        parentesis++;
        return true;
    }else{
        return false;
    }
}

public static void main(String[] args) {
        String patron = ("(while)|((a-zA-Z)+)|([>|<|=]+)|([0-9]+)|([(|)]+)|([(|)]+)|(;)");//definimos la expresion regular
        String texto = "while (x=0) < (y=0)";//texto que queremos analizar con la expresion regular

        Pattern p = Pattern.compile(patron);//compilar nuestra expresion regular
        Matcher matcher = p.matcher(texto);

        //nos permita encontrar las coincidencias "palabras que hacen parte de nuestra expresion regular"
        while (matcher.find()) {
            //variables para que coincidad
            String tokenTipo1 = matcher.group(1);
            if (tokenTipo1 != null) {
                System.out.println("palabra reservada: " + tokenTipo1);

            }

            String tokenTipo2 = matcher.group(2);
            if (tokenTipo2 != null) {
                System.out.println("variables: " + tokenTipo1);

            }

            String tokenTipo3 = matcher.group(3);
            if (tokenTipo3 != null) {
                System.out.println("palabra reservada: " + tokenTipo1);

            }

            String tokenTipo4 = matcher.group(4);
            if (tokenTipo4 != null) {
                System.out.println("digitos: " + tokenTipo1);

            }

            String tokenTipo5 = matcher.group(5);
            if (tokenTipo5 != null) {
                System.out.println("palabra reservada: " + tokenTipo1);

            }

            String tokenTipo6 = matcher.group(6);
            if (tokenTipo6 != null) {
                System.out.println("palabra reservada: " + tokenTipo1);

            }

            String tokenTipo7 = matcher.group(7);
            if (tokenTipo7 != null) {
                System.out.println("palabra reservada: " + tokenTipo1);

            }
        }
    }

}

   


   
   

    

