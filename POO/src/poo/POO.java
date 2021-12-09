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
public class POO {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Carro carro1 = new Carro();
        carro1.setColor("Azul");
        carro1.setFabricante("Mazda");
        carro1.setKilometraje(0);
        carro1.setModelo("3");
        carro1.setPrecio(60500);
        carro1.setPuertas(4);
        
//        System.out.println(carro1);
        
        Carro carro2 = new Carro("Toyota", "Corolla", "Negro", 4, 100000, 110000);
        
//        System.out.println("\n" + carro2);
//        carro2.conducirCarro(1000);
//        System.out.println("\n" + carro2);
        
        System.out.println(carro1);
        System.out.println("");
        carro1.setPuertas(1);
        System.out.println(carro1 + "\n\n");
        
        System.out.println(carro1.getPrecio("123"));
    }
}
