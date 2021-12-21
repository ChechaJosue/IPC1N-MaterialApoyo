/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author chechajosue
 */
public class Potenciador extends Thread {

    public int tipo, velocidadY, puntos, tiempo, x, y;
    public JLabel imagen = new JLabel();
    public Rectangle hitbox = new Rectangle();
    Juego juego;

    public Potenciador(int tipo, Juego juego) {
        super();
        this.tipo = tipo;
        this.puntos = 5;
        this.tiempo = 15;
        this.juego = juego;
        this.velocidadY = 10;

        generarPosicionRandom();
        System.out.println("X: " + this.x + "  Y: " + this.y);

        switch (this.tipo) {
            case 0:// AUMENTO DE TIEMPO
                imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/AUMENTO_TIEMPO.png")));
                imagen.setBounds(this.x, this.y, 32, 32);
                hitbox.setBounds(this.x, this.y, 32, 32);
                break;

            case 1:// AUMENTO DE PUNTOS
                imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/AUMENTO_PUNTOS.png")));
                imagen.setBounds(this.x, this.y, 32, 32);
                hitbox.setBounds(this.x, this.y, 32, 32);
                break;
        }

        juego.add(imagen);
        juego.repaint();
        this.start();
    }

    public void run() {
        while (this.y >= 0) {
            try {
                sleep(150);
                avanzar();

                if (validarImpacto()) {
                    switch (this.tipo) {
                        case 0:// AUMENTO DE TIEMPO
                            System.out.println("** Aumento de tiempo.");
                            break;

                        case 1:// AUMENTO DE PUNTOS
                            System.out.println("** Aumento de puntos.");
                            this.juego.actualizarPuntos(this.puntos);
                            break;
                    }

                    this.y = -1;
                    break;
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        this.imagen.setVisible(false);
        this.juego.remove(this.imagen);
        this.juego.potenciadores.remove(this);
    }

    public void avanzar() {
        this.y += this.velocidadY;
        actualizar();
    }

    public void actualizar() {
        this.imagen.setLocation(this.x, this.y);
        this.hitbox.setLocation(this.x, this.y);
    }

    public boolean validarImpacto() {
        return juego.jugador.hitbox.intersects(this.hitbox);
    }

    public void generarPosicionRandom() {
        //X - 480 px es el maximo
        //Y - 5 px adelante de los aliens
        Random aleatorio = new Random();
        this.x = aleatorio.nextInt(480);
        this.y = juego.aliens.get(juego.aliens.size() - 1).y + 69;
    }

}
