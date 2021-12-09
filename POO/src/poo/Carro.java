/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author chechajosue
 */
// Definir clase
public class Carro {

    // Atributos
    private String fabricante, modelo, color;
    private int puertas;
    private double kilometraje, precio;
    private String pass = "123";
    
    static int contador = 0;
    
    
    // Constructor
    public Carro() {
        contador ++;
    }

    public Carro(String fabricante, String modelo, String color, int puertas, double kilometraje, double precio) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.puertas = puertas;
        this.kilometraje = kilometraje;
        this.precio = precio;
        contador ++;
    }
    
    // Metodos
    
    public void conducirCarro(double km){
        if(km <= 0){
            System.out.println("La cantidad de kilometros debe ser mayor a 0");
            return;
        }
        
        this.kilometraje += km;
    }
    
    @Override
    public String toString(){
        return "Fabricante: " + this.fabricante 
            + "\nModelo: " + this.modelo
            + "\nColor: " + this.color
            + "\nPuertas: " + this.puertas
            + "\nKilometraje: " + this.kilometraje
            + "\nPrecio: " + this.precio;
    }
    
    
    // Getters

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getPuertas() {
        return puertas;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public double getPrecio(String pass) {
        if(this.pass.equals(pass)){
            return this.precio;
        } 
        System.out.println("\n ** La contraseña es incorrecta");
        return 0;
    }

    public static int getContador() {
        return contador;
    }

    // Setters
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPuertas(int puertas) {
        
        if(puertas <= 0 || puertas > 10){
            System.out.println("\n** El número de puertas debe estar entre 1 y 10");
            return;
        }
        
        this.puertas = puertas;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static void setContador(int contador) {
        Carro.contador = contador;
    }
    
    

}
