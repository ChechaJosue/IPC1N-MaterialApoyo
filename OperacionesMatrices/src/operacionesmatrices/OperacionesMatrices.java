/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacionesmatrices;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ChechaJosue
 */
public class OperacionesMatrices {

    /**
     * @param args the command line arguments
     */
    
    static String [][] matrizReporte;
    
    public static void main(String[] args) throws IOException {
        int [][] matriz1 = {{2,3,5},{1,2,5},{-2,-4,-6}};
        int [][] matriz2 = {{6,5,3},{10,-3,55},{-20,-23,-16}};
        
        
        int suma [][] = sumarMatrices(matriz1, matriz2);
        imprimirMatriz(matriz1);
//        imprimirMatriz(matriz2);
//        imprimirMatriz(suma);

//        int multi [][] = multiplicarMatrices(matriz1, matriz2);
//        imprimirMatriz(multi);
            
//        int traspuesta [][] = traspuestaMatriz(matriz1);
//        imprimirMatriz(traspuesta);
          reporteSuma(suma, matrizReporte);

    }
    
    public static int [][] sumarMatrices(int [][] matrizA, int [][] matrizB){
        
        int [][] resultado = new int [matrizA.length][matrizA[0].length];
        matrizReporte = new String [matrizA.length][matrizA[0].length];
        
        // Validando que tengan las mismas dimensiones
        if((matrizA.length != matrizB.length) || (matrizA[0].length != matrizB[0].length)){
            System.out.println("Error: Las matrices a sumar deben tener las mismas dimensiones.");
            return resultado;
        }
        
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
                matrizReporte[i][j] = "Se sumó el número " + matrizA[i][j] + " con el número " + matrizB[i][j];
            }
        }
        
        System.out.println("La suma se realizó con éxito.");
        return resultado;
    }
    
    public static int [][] multiplicarMatrices(int [][] matrizA, int [][] matrizB){
        
        // Mismo numero de filas de A y columnas de B
        int [][] resultado = new int [matrizA.length][matrizB[0].length];
        
        if(matrizA.length != matrizB[0].length){
            System.out.println("Error: Las matrices a multiplicar deben cumplir con la regla.");
            System.out.println("# Filas de A debe ser igual al # de columnas de B");
            return resultado;
        }
        
        // Multiplicar matrices
        
        // Recorriendo las filas de A
        for (int i = 0; i < matrizA.length; i++) {
            
            // Recorriendo las columnas de A
            for (int j = 0; j < matrizA[0].length; j++) {
                // Recorrer las columnas de B
                for (int k = 0; k < matrizB.length; k++) {
//                    System.out.println("i = " + i + " j = " + j + " k = " + k );
                    resultado[i][j] += matrizA[i][k]*matrizB[k][j]; 
                    System.out.print(matrizA[i][k] + " * " + matrizB[k][j] + " + ");
                }
                
                System.out.println("= " + resultado[i][j]);
            }
        }
        
        return resultado;
    }
    
    public static void imprimirMatriz(int [][] matriz){
        System.out.println("\n");
        // Recorriendo las filas
        for (int i = 0; i < matriz.length; i++) {
        
            // Recorriendo las columnas
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("| " + matriz[i][j] + " ");
            }
            
            System.out.println("|");
        }
    }

    public static int [][] traspuestaMatriz(int [][] matriz){
        
        int traspuesta [][] = new int [matriz.length][matriz[0].length];
        
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }
        
        return traspuesta;
    }

    public static void reporteSuma(int [][] matriz, String [][] desc) throws IOException{
        
        File archivoHTML;
        FileWriter escritor = null;
        
        // Fecha y la hora del reporte
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        
        try {
            
            archivoHTML = new File("reporteSuma.html");
            escritor = new FileWriter(archivoHTML);
            
            String contenidoHTML = "<h1 style=\"color: black; text-align: center;\"><span style=\"color: black;\"><strong>IPC1 Sección E</strong></span></h1>"
            +"<h2 style=\"color: #2e6c80; text-align: center;\">" + fecha + " - " + hora + "</h2>"
            +"<h2 style=\"color: #2e6c80;\">&nbsp;</h2>"
            +"<table class=\"editorDemoTable\" style=\"border-style: solid; border-color: black; margin-left: auto; margin-right: auto; border=\"1\"\">"
            +"<thead>"
            +"<tr>"
            +"<td style=\"width: 188.734px;background-color: black; color: white;\"><strong>No. paso</strong></td>"
            +"<td style=\"width: 355.609px;background-color: black; color: white;\"><strong>Descripci&oacute;n</strong></td>"
            +"<td style=\"width: 120.656px;background-color: black; color: white;\"><strong>Valores calculados</strong></td>"
            +"</tr>"
            +"</thead>"
            +"<tbody>";
            
//            +"<tr>"
//            +"<td style=\"width: 188.734px;\">1</td>"
//            +"<td style=\"width: 355.609px;\">Suma</td>"
//            +"<td style=\"width: 120.656px;\">10</td>"
//            +"</tr>";

            int contador = 1;

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    contenidoHTML += "<tr style=\"outline: solid thin;\">";
                    contenidoHTML += "<td style=\"width: 188.734px; outline: solid thin;\">" + contador + "</td>";
                    contenidoHTML += "<td style=\"width: 355.609px; outline: solid thin;\">" + desc[i][j] + "</td>";
                    contenidoHTML += "<td style=\"width: 355.609px; outline: solid thin;\">" + matriz[i][j] + "</td>";
                    contenidoHTML += "</tr>";
                    contador++;
                }
            }
            
            contenidoHTML += "</tbody>"
            +"</table>";
            
            escritor.write(contenidoHTML);
            System.out.println("Se generó el reporte correctamente");
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error al generar el reporte");
        } finally {
            escritor.close();
        }
    }
}
