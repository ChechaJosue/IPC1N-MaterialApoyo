/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author chechajosue
 */
public class MovimientoAliens extends Thread {

    ArrayList<Alien> aliens;
    JFrame formPadre;
    Jugador jugador;

    public MovimientoAliens(ArrayList<Alien> aliens, JFrame form, Jugador jugador) {
        super();
        this.aliens = aliens;
        this.formPadre = form;
        this.jugador = jugador;
    }
    
    public boolean colisionJugador(Alien alien){
        return alien.hitbox.intersects(jugador.hitbox);
    }
    
    public void run() {
        while (aliens.size() > 0) {
            try {

                for (Alien alien : aliens) {
                    alien.moverAbajo();
                }
                
                for (Alien alien : aliens) {
                    
                    // Un alien tocó al jugador
                    if(colisionJugador(alien)){
                        JOptionPane.showMessageDialog(null, "El juego ha terminado.");
                        return;
                    }
                    
                    alien.actualizar();
                }
                
                //System.out.println("\n- Movimiento aliens.");
                
                sleep(1000);
                
            } catch (Exception e) {
                System.out.println("** Ocurrió un error al mover los aliens.");
                e.printStackTrace();
            } finally {
                formPadre.repaint();
            }
        }
    }
}
