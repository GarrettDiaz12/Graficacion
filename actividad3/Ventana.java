/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private final JFrame ventana;
    private final Container contenedor;
    private Punto[] figura;

    /**
     * Crear una ventn¿ana para representar la figura
     *
     * @param título
     * @param figura
     */
    public Ventana(String título, Punto[] figura) {
        //inicializar ventana
        ventana = new JFrame(título);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);

        this.figura = figura;
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        // Dibujar figura
        g.setColor(Color.black);
        this.dibujar(g);
        // Escalamiento
        g.setColor(Color.magenta);
        this.escalar(0.5, 0.5);
        this.dibujar(g);
        // traslacion
        g.setColor(Color.red);
        this.traslacion(200, 200);
        this.dibujar(g);
        // rotacion
        g.setColor(Color.blue);
        this.rotacion(40);
        this.dibujar(g);
        // rotacion2
        g.setColor(Color.pink);
        this.rotacion_EnContra(45);
        this.dibujar(g);
          // rreflejar
        g.setColor(Color.orange);
        this.reflejar_x();
        this.traslacion(200, 200);
        this.escalar(0.5, 0.5);
        this.dibujar(g);

    }

    private void escalar(double fx, double fy) {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int) ((punto.getX() - tx) * fx + tx));
            punto.setY((int) ((punto.getY() - ty) * fy + ty));
        }
    }

    private void traslacion(double xf, double yf) {
        for (Punto punto : figura) {
            punto.setX((int) ((punto.getX() + xf)));
            punto.setY((int) ((punto.getY() + yf)));

        }
    }

    private void rotacion(int angulo) {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int) ((punto.getX() - tx) * Math.cos(Math.toRadians(angulo)) - (punto.getY() - ty) * Math.sin(Math.toRadians(angulo)) + tx));
            //punto y
            punto.setY((int) ((punto.getX() - ty) * Math.sin(Math.toRadians(angulo)) + (punto.getY() - ty) * Math.cos(Math.toRadians(angulo)) + ty));

        }
    }

    private void rotacion_EnContra(int angulo) {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int) ((punto.getX() - tx) * Math.cos(Math.toRadians(angulo)) + (punto.getY() - ty) * Math.sin(Math.toRadians(angulo)) + tx));
            punto.setY((int) ((-1) * (punto.getX() - tx) * Math.sin(Math.toRadians(angulo)) + (punto.getY() - ty) * Math.cos(Math.toRadians(angulo)) + ty));

        }
    }
   private void reflejar_x(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX(-(punto.getX()-tx)+tx);
            punto.setX((punto.getY()-ty)+ty);
            
            
        }
       
    
}

    private void dibujar(Graphics g) {
        for (int i = 0; i < this.figura.length - 1; i++) {
            g.drawLine(
                    figura[i].getX(),
                    figura[i].getY(),
                    figura[i + 1].getX(),
                    figura[i + 1].getY()
            );

        }
    }

}
