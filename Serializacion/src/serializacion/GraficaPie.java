
package serializacion;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


public class GraficaPie extends JFrame {
    
    
    String titulo = "";

    public GraficaPie(String titulo, Object [] arreglo){
        
        super(titulo);
        
        this.titulo = titulo;
        
        if(arreglo instanceof Carro[]){
            System.out.println("\nArreglo tipo carro");
        } else if(arreglo instanceof Vendedor[]){
            System.out.println("\nArreglo tipo vendedor");
            setContentPane(crearPanel());
            this.repaint();
        } else{
            System.out.println("\nNo es ningun tipo soportado.");
        }
    }
    
    JPanel crearPanel(){
        JFreeChart grafica = crearChart(crearDataSetGenero());
        return new ChartPanel(grafica);
    }
    
    JFreeChart crearChart(PieDataset dataset){
        return ChartFactory.createPieChart(titulo, dataset, true, true, true);
    }
    
    PieDataset crearDataSetGenero(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        int contador_M = 0, contador_F = 0;
    
        for (Vendedor vendedor : Serializacion.vendedores) {
            if(vendedor.getGenero() == 'M'){
                contador_M++;
            } else {
                contador_F++;
            }
        }
        
        dataset.setValue("Mujeres", contador_F);
        dataset.setValue("Hombres", contador_M);
        return dataset;
    }
}
