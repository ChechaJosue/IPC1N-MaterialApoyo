/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.operadores;

/**
 *
 * @author chechajosue
 */
public class Main {
    
    public static void main(String[] args) {
        // Operadores Relacionales
        System.out.println("Operadores Relacionales\n");
        System.out.println(5<3);
        System.out.println(5>3);
        System.out.println(5<=3);
        System.out.println(5>=3);
        System.out.println(5==3);
        System.out.println(5!=3);
        System.out.println("\nOperadores logicos\n");
        
        //Operadores logicos
        System.out.println(true && false);
        System.out.println(true || false);
        System.out.println(!false);
        
        //Operadores aritmeticos
        System.out.println("\nOperadores aritmeticos\n");
        int contador = 100;
        int contador1 = 100;
        
        System.out.println("Módulo :" + 13%2);
        System.out.println("Decremento :" + (--contador));
        System.out.println("Decremento :" + (++contador1));
        
        // IF
        
        System.out.println("\nIF\n");
        
        boolean val1 = 3==(2+2); // FALSE
        boolean val2 = 5>4; // TRUE
        
        if(val1 && val2){ // FALSE 
            System.out.println("Se cumple la condicion\n");
        } else {
            System.out.println("No se cumple la condicion\n");
        }
        
        // Switch (Segun)
        System.out.println("\nSwitch\n");
        int valor = 3;
        
        switch(valor) {
            case 1:
                System.out.println("El valor es 1");
                break;
            case 2:
                System.out.println("El valor es 2");
                break;
            case 3:
                System.out.println("El valor es 3");
                break;
            case 4:
                System.out.println("El valor es 4");
                break;
            default:
                System.out.println("No fue ningun caso");
        }
        
        // Iteracion
        
        // For
        System.out.println("\nFor\n");
        
        for(int i=10; i>0; i--){
            System.out.println(i);
        }
        
        System.out.println("\n");
        
        // While
        System.out.println("\nWhile\n");
        
        int contador_while = 10;
        
        while (contador_while < 10) {      
            System.out.println(contador_while);
            contador_while++;
        }
        
        System.out.println("\n");
        
        // Do While
        System.out.println("\nDo While\n");
        do {            
            System.out.println(contador_while);
            contador_while++;
        } while (contador_while < 10);
    
        // Funciones
        System.out.println("\nFunción\n");
        int varFuncion = sumarNumeros(4, 23);
        System.out.println(varFuncion);
        
        // Procedimiento
        System.out.println("\nProcedimiento\n");
        saludar("César");
    }

    // Funciones
    static int sumarNumeros(int A, int B){
        return A+B;
    }
    
    // Procedimiento
    static void saludar(String nombre){
        System.out.println("Saludos " + nombre);
    }
}
