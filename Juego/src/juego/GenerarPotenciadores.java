/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chechajosue
 */
public class GenerarPotenciadores extends Thread {

    Juego juego;
    
    public GenerarPotenciadores(Juego juego) {
        this.juego = juego;
        this.start();
    }
    
    public void run(){
        while (true) {            
            try {
                
                int tiemporandom = tiempoRandom();
                int tiporandom = tipoRandom();
                
                System.out.println("\nTiempo random: " + tiemporandom + " Tipo random: " + tiporandom);
                sleep(tiemporandom);
                juego.potenciadores.add(new Potenciador(tiporandom, juego));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public int tiempoRandom() {
        Random aleatorio = new Random();
        return 3000 + 1000*aleatorio.nextInt(2);
    }
    
    public int tipoRandom() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(2);
    }
}
