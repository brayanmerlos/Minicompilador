package analizdor;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Brayan Merlos
 */

public class Lexico {
       
    
        
  public ArrayList<String> errorl=new ArrayList<String>();
  public ArrayList<String> tokens=new ArrayList<String>();
  public ArrayList<String> identis=new ArrayList<String>();
  public boolean errorlex; 
  String a="Integer";
  String b="";
  String c="";
  String d="";
  
//  a="Integer";
//        b="Boolean";
//        c="Char";
//        d="Double";
    
public void analizar(String linea){
    
    StringTokenizer st=new StringTokenizer(linea, " =;()><[]{}+-/*,",true);
    String Vec[]=new String[st.countTokens()];
  
  
    while(st.hasMoreTokens()){
        for (int i = 0; i < Vec.length; i++) {
            Vec[i]=st.nextToken();
            if(palabraReservada(Vec[i])){
                System.out.println(Vec[i]+"    "+"Palabra Reservada");
                a=a+Vec[i];
            }else if(operadorAritmetico(Vec[i])){
                System.out.println(Vec[i]+"    "+"Operador Aritmetico");
            a=a+Vec[i];   
            }else if(isNumeric((Vec[i]))){
                System.out.println(Vec[i]+"    "+"Constante Entera Valida");        
            }else if(operadorRelacional(Vec[i])){
                System.out.println(Vec[i]+"    "+"Operador Relacional");
            a=a+Vec[i];
            }else if(Cadena(Vec[i])){
                System.out.println(Vec[i]+"    "+"Cadena de Caracteres");
            }else if(Identificador(Vec[i])=="1"){
                System.out.println(Vec[i]+"    "+"Identificador");
            }else if(Identificador(Vec[i])=="2"){
             errorl.add(Vec[i]);
             errorlex=true;
            }
        }
}
tokens.add(a);
}

public boolean palabraReservada(String cad){
Pattern pat=Pattern.compile("what|how|i|when|whai|that|is|not|are"
        + "we|you|i|she|he|they|it|its|are"
);
Matcher mat=pat.matcher(cad.toUpperCase());
if(mat.matches()){
    return true;
}else{
    return false;
}
}

public boolean operadorAritmetico(String cad){
Pattern pat=Pattern.compile("(-|/)");
Matcher mat=pat.matcher(cad.toLowerCase());
if(mat.matches() || cad.equalsIgnoreCase("*") || cad.equalsIgnoreCase("+")){
    return true;
}
else{
    return false;
}
}

public boolean operadorRelacional(String cad){
   Pattern pat=Pattern.compile("(>=|<=|>|<|=|}|]|;|,)");
   Matcher mat=pat.matcher(cad.toLowerCase());
   if(mat.matches() || cad.equalsIgnoreCase("{") || cad.equalsIgnoreCase("[") || cad.equalsIgnoreCase("(") || cad.equalsIgnoreCase(")"))
    return true;
   else{
       return false;
   }
}

public boolean Cadena(String cad){
    if(cad.startsWith("'") && cad.endsWith("'")){return true;}
    else{return false;}
}

private boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    public String Identificador(String cad) {
        try{
    if(cad.endsWith(" ")){return "3";}
    if(isNumeric(String.valueOf(cad.charAt(0)))){return "2";}
    if(operadorAritmetico(String.valueOf(cad.charAt(0))) && operadorAritmetico(String.valueOf(cad.charAt(1)))==false){return "2";}
    if(operadorAritmetico(String.valueOf(cad.charAt(0))) && operadorAritmetico(String.valueOf(cad.charAt(1)))){return "2";}
        }catch(IndexOutOfBoundsException nfe){
            return "3";
        }
    identis.add(cad);
        return "1";
    }  
    
}
