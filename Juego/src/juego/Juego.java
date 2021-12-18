/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author chechajosue
 */
public class Juego extends javax.swing.JFrame {

    Jugador jugador;
    MovimientoAliens movimientoAliens;
    ArrayList<Alien> aliens = new ArrayList<>();
    ArrayList<Bala> balas = new ArrayList<>();
    
    public Juego() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        inicializarPartida();
        this.setVisible(true);
    }

    
    public void inicializarPartida(){
        jugador = new Jugador((this.getWidth()/2)-32, this.getHeight()-100, this);
        generarAliens();
        movimientoAliens = new MovimientoAliens(aliens, this, jugador);
        movimientoAliens.start();
    }
    
    public void generarAliens(){
        int posY = 0;
        
        // Aliens tipo 3
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                aliens.add(new Alien(3, j*64, posY, this));
            }
            posY += 64;
        }
        
        // Aliens tipo 2
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                aliens.add(new Alien(2, j*64, posY, this));
            }
            posY += 64;
        }
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        int tecla = evt.getKeyCode();
        
        switch(tecla){
            
            case KeyEvent.VK_LEFT:
                jugador.moverIzquierda();
                break;
                
            case KeyEvent.VK_RIGHT:
                jugador.moverDerecha();
                break;
                
            case KeyEvent.VK_SPACE:
                balas.add(new Bala(this));
                break;
        }
        
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}