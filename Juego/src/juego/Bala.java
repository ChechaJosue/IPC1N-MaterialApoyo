/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author chechajosue
 */
public class Bala extends Thread {
    
    JLabel imagen = new JLabel();
    Rectangle hitbox = new Rectangle();
    Juego juego;
    
    public int x, y, velocidadY;

    public Bala(Juego juego) {
        super();
        this.juego = juego;
        this.x = juego.jugador.x + (juego.jugador.imagen.getWidth()/2) - 11;
        this.y = juego.jugador.y;
        this.velocidadY = 10;
        
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/BALA.png")));
        imagen.setBounds(this.x, this.y, 24, 24);
        hitbox.setBounds(this.x, this.y, 24, 24);
        
        juego.add(imagen);
        juego.repaint();
        
        this.start();
    }
    
    public void run(){
        while (this.y >= 0) {            
            try {
                this.y -= velocidadY;
                actualizar();
                
                for (Alien alien : this.juego.aliens) {
                    if(alien.validarImpacto(this.hitbox)){
                        System.out.println("\n-- Impacto bala +" + alien.puntos + " puntos y=" + this.y);
                        
                        this.y = -24;
                        break;
                    }
                }
                
                sleep(100);
            } catch (Exception e) {
                System.out.println("** Ocurrió un error moviendo la bala");
                e.printStackTrace();
            }
        }
        
        this.imagen.setVisible(false);
        this.juego.remove(this.imagen);
        this.juego.balas.remove(this);
    }
    
    public void actualizar(){
        this.imagen.setLocation(this.x, this.y);
        this.hitbox.setLocation(this.x, this.y);
    }
}
