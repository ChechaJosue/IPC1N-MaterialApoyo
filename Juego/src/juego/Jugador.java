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
public class Jugador {
    
    public JLabel imagen = new JLabel();
    public Rectangle hitbox = new Rectangle();
    public JFrame formPadre;
    public int x, y, velocidadX;

    public Jugador(int posX, int posY, JFrame form) {
        
        super();
        this.formPadre = form;
        this.x = posX;
        this.y = posY;
        this.velocidadX = 5;
        
        imagen.setBounds(x, y, 64, 64);
        hitbox.setBounds(x, y, 64, 64);
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/NAVE.png")));
        formPadre.add(imagen);
        formPadre.repaint();
    }
    
    public void moverDerecha(){
        if(this.x <= (636-this.velocidadX)){
            this.x += this.velocidadX;
            actualizarLabel();
        }
    }
    
    public void moverIzquierda(){
        if(this.x >= this.velocidadX){
            this.x -= this.velocidadX;
            actualizarLabel();
        }
    }
    
    public void actualizarLabel(){
        imagen.setLocation(this.x, this.y);
        hitbox.setLocation(this.x, this.y);
        formPadre.repaint();
    }
  
}
