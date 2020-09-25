package Icono;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class dibujo extends JPanel {
  int choques = 0;
  private JFrame ventana;
  private Container contenedor;
  // figura representada en hexadecimal
  private final int[] figura = { 
      0xc1c1c1c0,
0xe0e0e0e,
0x7070707,
0x3838383,
0x1c1c1c1,
0x0e0e0e0,
0x0707070,
0x0313131,
0x0707070,
0x0e0e0e0,
0x1c1c1c1,
0x3838383,
0x7070707,
0xe0e0e0e,
0xc1c1c1c
};
  // Mascara
  private final int Mascara = 0x8000000;
  // ancho en bits
  private final int Ancho_bits = 32;
  private int coordenada_X;
  private int coordenada_y;
  private int x1=10,x2=436;
  private int y1=15,y2=455;
  private int tiempo=50;
  private Thread Hilo;
  public dibujo() {
    // inicializar ventana
    UIManager UI=new UIManager(); 
    UI.put("OptionPane.background", Color.MAGENTA); 
    UI.put("Panel.background", Color.MAGENTA); 
    JOptionPane.showMessageDialog(null, "Movimento de figura"+"\n"+"Diaz Cervera Brian Noe/ISC/Graficacion/ITL", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
    this.coordenada_X = 500 / 2;
    this.coordenada_y = 500 / 2;//Funciona para que al inicar la imgaen este centrada
    ventana = new JFrame("Movimiento de la figura.");
    // definir tamaño a ventana
    ventana.setSize(500, 500); 
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);// posición al centro
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setResizable(false);
    contenedor = ventana.getContentPane();
    contenedor.setSize(500, 500);
    // agregar una ventana en el contenedor
    contenedor.add(this, BorderLayout.CENTER);
  }
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
      g.setColor(Color.MAGENTA);
      ventana.getColorModel();
    for (int i = 0; i < this.figura.length; i++) {
      // iterador para el ancho en bits
      for (int j = 0; j < this.Ancho_bits; j++) {
        int temp = this.figura[i] & (this.Mascara >> j);

        if (temp != 0) {
          g.drawLine(coordenada_y + j,
                     coordenada_X + i,
                     coordenada_y + j,
                     coordenada_X + i);
        }
      }
    }
  }
  public void dibujar() {
    while (choques < 10) {
      try {
        this.coordenada_X += (((int) Math.floor(Math.random() * 2)) == 1) ? 15 : -15;
        this.coordenada_y += (((int) Math.floor(Math.random() * 2)) == 1) ? 15 : -15;
        Thread.sleep(tiempo);
        paint(getGraphics());
        if (this.coordenada_X < x1 || this.coordenada_X > x2 || this.coordenada_y < y1 || this.coordenada_y > y2) {
          this.coordenada_X = (int) (Math.random() * 500);
          this.coordenada_y = (int) (Math.random() * 500);
          choques++;
          JOptionPane.showMessageDialog(null,"Colision. ["+choques+"]");
         
        }

      } catch (InterruptedException e) {
        System.out.println(e.getMessage());
      }
        if (choques==10) {
             JOptionPane.showMessageDialog(null, "Se acomularon las 10 colisiones", "------------------FIN----------------", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            
        }
    }

  }
}
