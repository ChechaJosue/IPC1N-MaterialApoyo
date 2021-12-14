/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;
import java.io.Serializable;


public class Carro implements Serializable {
    
    private int year;
    private String VIN, fabricante, modelo;
    private double precio;

    public Carro() {
    }
    
    public Carro(int year, String VIN, String fabricante, String modelo, double precio) {
        this.year = year;
        this.VIN = VIN;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.precio = precio;
    }
    
    // Getters
    
    public int getYear() {
        return year;
    }

    public String getVIN() {
        return VIN;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters 
    
    public void setYear(int year) {
        this.year = year;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String [] toArregloString(){
        String retorno [] = {String.valueOf(this.VIN), String.valueOf(this.fabricante), String.valueOf(this.modelo), String.valueOf(this.year), String.valueOf(this.precio)};
        return retorno;
    }
    
    @Override
    public String toString(){
        return "VIN: " + this.VIN + "\nModelo: " + this.modelo + "\nFabricante: " + this.fabricante + "\nPrecio: " + this.precio;
    }
}
