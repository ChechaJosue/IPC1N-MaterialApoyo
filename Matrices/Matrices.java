
package com.mycompany.matrices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author chechajosue
 */
public class Matrices {
    
    static int arreglo [];
    
    static int matrizA [][];
    static int matrizB [][];
    
    public static void main(String[] args) throws IOException {
    
        arreglo = new int[10];
        arreglo[0] = 1;
        arreglo[1] = 2;
        arreglo[2] = 3;
        arreglo[3] = 4;
        arreglo[4] = 5;
        arreglo[5] = 6;
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
        
        matrizA = new int[3][4];
        
        // [FILA][COLUMNA]
        matrizA[0][0] = 1;
        matrizA[0][1] = 2;
        matrizA[0][2] = 3;
        
        matrizA[1][0] = 4;
        matrizA[1][1] = 5;
        matrizA[1][2] = 6;
        
        System.out.println("\n");
        
        System.out.println("Filas: " + matrizA.length);
        System.out.println("Columnas: " + matrizA[0].length + "\n");
        
        // Ciclo de filas
        for (int i = 0; i < matrizA.length; i++) {
            
            // Ciclo para las columnas
            for (int j = 0; j < matrizA[0].length; j++) {
                System.out.print("| " + matrizA[i][j] + " ");
            }
            
            System.out.println("|");
        }
        
        String texto = leerArchivo("/media/chechajosue/Duro/Universidad/IPC1/Diciembre/Ejemplos/Matrices/Matrices/src/main/java/com/mycompany/matrices/MatrizA.txt");
        System.out.println("\n\n" + texto);
        
        System.out.println("Llenar matriz");
        llenarMatriz(matrizB, texto);
    }

    static String leerArchivo(String ruta) throws IOException{
        
        String texto = "";
        BufferedReader lector = null;
        
        try {
            File archivo = new File(ruta);
            lector = new BufferedReader(new FileReader(archivo));
            
            String linea = lector.readLine();
            
            while (linea != null) {                
                texto += linea + "\n";
                linea = lector.readLine();
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        } finally {
            if(lector!=null){
                lector.close();
            }
        }
        
        return texto;
    }

    static void llenarMatriz(int [][] matriz, String texto){
        
        // Separando las filas con salto de linea
        String filas [] = texto.split("\n");
        int num_columnas = filas[0].split(",").length;
        
        matriz = new int [filas.length][num_columnas];
        
        for (int i = 0; i < filas.length; i++) {

            // Separando las columnas por medio de coma ,
            String columnas [] = filas[i].split(",");
            
            for (int j = 0; j < columnas.length; j++) {
                System.out.print("| " + columnas[j] + " ");
                matriz[i][j] = Integer.parseInt(columnas[j]);
            }
            System.out.println("\n");
        }
    }
}