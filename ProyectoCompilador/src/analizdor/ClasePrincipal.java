/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizdor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Brayan Merlos
 */
public class ClasePrincipal {
    
    public static void main(String[] args) {            
       
        Lexico lexi =new Lexico();
        
        System.out.println("mostrando palabras reservadas del analizador lexico");
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
                System.out.println("variables: " + tokenTipo2);

            }

            String tokenTipo3 = matcher.group(3);
            if (tokenTipo3 != null) {
                System.out.println("operador: " + tokenTipo3);

            }

            String tokenTipo4 = matcher.group(4);
            if (tokenTipo4 != null) {
                System.out.println("numero: " + tokenTipo4);

            }

            String tokenTipo5 = matcher.group(5);
            if (tokenTipo5 != null) {
                System.out.println("parentesis: " + tokenTipo5);

            }

            String tokenTipo6 = matcher.group(6);
            if (tokenTipo6 != null) {
                System.out.println("llaves: " + tokenTipo6);

            }

            String tokenTipo7 = matcher.group(7);
            if (tokenTipo7 != null) {
                System.out.println("numero: " + tokenTipo7);

            }
        }
    }
}
