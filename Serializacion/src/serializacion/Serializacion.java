/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author chechajosue
 */
public class Serializacion {

    public static Carro carros[];

    public static void main(String[] args) throws IOException {

        String textoJSON = leerArchivo("Carros100.json");
        System.out.println(textoJSON + "\n\n********************************");
        
        // Leer JSON y cargarlo al arreglo
        carros = (Carro []) leerJSON(textoJSON, new Carro());
//        vendedores = (Vendedor []) leerJSON(textoJSON, new Vendedor());
//        clientes = (Cliente []) leerJSON(textoJSON, new Cliente());
        
        for (Carro carro : carros) {
            System.out.println(carro + "\n");
        }
        
        System.out.println("");
        
        // Serializamos nuestro arreglo
        serializarArreglo(carros, "Carros.dat");
        
        // Borramos todos los carros
        carros = new Carro[100];
        
        System.out.println(carros[0]);
        
        // Recuperar los carros del archivo Carros.dat
        
        carros = (Carro []) leerArregloSerializado("Carros.dat");
        
        for (Carro carro : carros) {
            System.out.println(carro + "\n\n");
        }
    }
    
    static Object [] leerArregloSerializado(String ruta){
        try {
            
            ObjectInputStream leer_archivo = new ObjectInputStream(new FileInputStream(ruta));
            Object arreglo_recuperado [] = (Object []) leer_archivo.readObject();
            leer_archivo.close();
            System.out.println("\n** Se recuperó el arreglo " + ruta + " correctamente.\n\n");
            return arreglo_recuperado;
        } catch (Exception e) {
            System.out.println("\n**Ocurrió un error al recuperar el arreglo.");
            e.printStackTrace();
        }
        
        return null;
    }

    static void serializarArreglo(Object arreglo [], String ruta){
        try {
            ObjectOutputStream escribir_archivo = new ObjectOutputStream(new FileOutputStream(ruta));
            escribir_archivo.writeObject(arreglo);
            escribir_archivo.close();
            System.out.println("** Se serializó el arreglo correctamente");
        } catch (Exception e) {
            System.out.println("** Hubo un error al serializar el arreglo");
            e.printStackTrace();
        }
    }
    
    static String leerArchivo(String ruta) throws IOException {
        String texto = "";
        BufferedReader lector = null;

        try {
            File archivo = new File(ruta);
            lector = new BufferedReader(new FileReader(archivo));

            String linea = lector.readLine();

            while (linea != null) {
                texto += linea;
                linea = lector.readLine();
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        } finally {
            if (lector != null) {
                lector.close();
            }
        }

        return texto;
    }
    
    static Object [] leerJSON(String textoJSON, Object obj){
        Gson gson = new Gson();
        
        // Si el objeto es instancia de carro
        if(obj instanceof Carro){
            return gson.fromJson(textoJSON, Carro[].class);
        // Si el objeto es instancia de Vendedor
        } else if (obj instanceof Vendedor){
            return gson.fromJson(textoJSON, Vendedor[].class);
        }
        
        // Si el objeto es instancia de cliente
        return gson.fromJson(textoJSON, Cliente[].class);
    }
}
