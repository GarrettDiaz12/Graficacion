
package unidad2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class figuras extends JPanel{
    private JFrame ventana;
    private Container contenedor;
    public  figuras(){
            
// inicializar la ventana
        ventana = new JFrame("Dibujando icono");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);     
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
    }   
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.drawLine(100, 50, 200, 50);
        g.drawLine(200, 50, 200, 100);
        g.drawLine(100, 50, 100, 100);
        g.drawLine(100, 100, 200, 100);
        
        g.setColor(Color.gray);
        g.drawLine(100, 50, 150, 20);
        g.drawLine(200, 50, 150, 20);
        //rectangulos
        g.setColor(Color.blue);
        //contordno
        g.drawRect(280, 50, 100, 50);
        g.fillRect(280, 110, 100, 50);
        // Rectangulo redondeado
        g.setColor(Color.PINK);
        g.drawRoundRect(450, 50, 100, 50, 50, 50);
        g.fillRoundRect(450, 110, 100, 50, 20, 20);// GRADO MENOR DE REDONDEO
        // TRAZO DE CIRCULOS
        g.setColor(Color.RED);
        g.drawOval(100, 200, 80, 80);
        g.fillOval(100, 290, 50, 50);
        // Ovalos
        g.setColor(Color.GREEN);
        g.drawOval(280,200,80,40);// ancho y alto no se pone igual para notar la diferencia
        g.fillOval(280, 290, 40,80 );
        // triangulo
        g.setColor(Color.black);
        g.drawLine(450, 300, 550, 300);
        g.drawLine(450, 300, 500, 250);
        g.drawLine(550, 300, 500, 250);
        // DIBUJO DE CADENA DE TEXTO
        g.setColor(Color.RED);
        g.drawString("EJEMPLO DE TRAZO DE FIGURAS", 200, 400);
        // TAREA ARCO CONTORNO Y RELLENO
        g.setColor(Color.magenta);
        g.drawArc(70, 370, 100,100, 180, 180);
        g.fillArc(200, 370, 100, 100, 180, 180);
        
          
        
          
        
        
          
        
    }
    
}
    
