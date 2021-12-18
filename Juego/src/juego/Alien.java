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
public class Alien {
    
    public int salud, tipo, puntos;
    public int x, y, velocidadY;
    public JLabel imagen = new JLabel();
    public Rectangle hitbox = new Rectangle();
    public Juego juego;

    public Alien(int tipo, int x, int y, Juego juego) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.juego = juego;
        this.velocidadY = 15;
        
        switch(tipo) {
            case 1:
                this.salud = 1;
                this.puntos = 5;
                imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/ALIEN_1.png")));
                imagen.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                juego.add(imagen);
                break;
                
            case 2:
                this.salud = 2;
                this.puntos = 7;
                imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/ALIEN_2.png")));
                imagen.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                juego.add(imagen);
                break;
                
            case 3:
                this.salud = 3;
                this.puntos = 10;
                imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/ALIEN_1.png")));
                imagen.setBounds(this.x, this.y, 64, 64);
                hitbox.setBounds(this.x, this.y, 64, 64);
                juego.add(imagen);
                break;
        }
        
        juego.repaint();
    }
    
    public boolean validarImpacto(Rectangle hitBoxBala){
        if(this.hitbox.intersects(hitBoxBala)){
            if(this.salud == 1){
                // El alien muere
                this.imagen.setVisible(false);
                juego.remove(imagen);
                juego.aliens.remove(this);
                return true;
            }
            
            this.salud -= 1;
            return true;
        }
        
        return false;
    }
    
    public void moverAbajo(){
        this.y += velocidadY;
    }
    
    public void actualizar(){
        this.imagen.setLocation(this.x, this.y);
        this.hitbox.setLocation(this.x, this.y);
    }
}
