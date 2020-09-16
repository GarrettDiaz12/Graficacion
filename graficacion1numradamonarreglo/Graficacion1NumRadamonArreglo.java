package graficacion1numradamonarreglo;
import javax.swing.*;
public class Graficacion1NumRadamonArreglo {
    public static void main(String[] args) {
      int inicial,f,tamaño=0;
      int suma=0;
      int promedio=0;
      String graficacion=" ";
      JOptionPane.showMessageDialog(null,"PROGRAMA DE IMPRECION DE 10 NUMERO RADMON EN UN ARREGLO DE 10 NUMERO"+"\n"+
                "                                        Diaz Cervera Brian Noe/ITL/Graficacion"+"\n"+"---------------------------------------------------------------------"
              + "--------------------------------------------------------"+"\n"+"                                "
              + "Ingrese el rango del de los numeros random a generar. ");
       inicial=Integer.parseInt(JOptionPane.showInputDialog("Limite iferior."));
       f=Integer.parseInt(JOptionPane.showInputDialog("Limte superior."));
       tamaño=Integer.parseInt(JOptionPane.showInputDialog("Ingrese tamaño del arreglo"));
             int Numeros []= new int[tamaño];
             String[] grafica = new String[f];
     
        System.out.print("\033[33m Num.R"+"\t\t\t\t\t"+"[GRAFICACION]"+"\t\t\t\t\t"+"Num.Arreglo"+"\n\n");
        for (int i = 0; i < tamaño; i++) { 
            Numeros[i]=(int)(Math.random()*f+inicial);
            suma += Numeros[i];
        }
         promedio=((suma)/(tamaño));
        for (int i = 0; i < Numeros.length; i++) {
            Numeros[i]=(int)(Math.random()*f+inicial);
            System.out.print("\033[36m ["+Numeros[i]+"] ");
            for (int j = 0; j <Numeros[i]; j++) {
                graficacion="-";
                grafica[j]=graficacion;
                System.out.print(grafica[j].toString());
                if(j==promedio-1){
                    System.out.print("||");
                    
                }
                
            }        
           System.out.println(": Arreglo "+i);   
        }
      System.out.println("\033[33m Resultados Numericos");
      System.out.println("\033[36m Suma:"+suma);
      System.out.println("\033[36m Promedio:"+promedio);
      
    
        
    
    }
}
