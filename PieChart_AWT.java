import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class PieChart_AWT extends ApplicationFrame {

   // Class initialization
   public PieChart_AWT( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }

   private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , 20 );
      dataset.setValue( "SamSung Grand" , 20 );
      dataset.setValue( "MotoG" , 40 );
      dataset.setValue( "Nokia Lumia" , 10 );
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }

   //Following 2 methods are of my own doing, with this, you can make a colour scheme for the pie chart
   //and with this I'm sure we can figure out how to implement this for the other graphs as well

   private static void createColorScheme(JFreeChart chart, Color[] colorScheme){
      PiePlot plot = (PiePlot) chart.getPlot();
      PieDataset ds = plot.getDataset();

      for(int i = 0; i < ds.getItemCount(); i++){
         plot.setSectionPaint(ds.getKey(i), colorScheme[i]);
      }
   }

   private static Color[] getColorScheme(){
      Color[] scheme = {(new Color(244, 233, 205)), //yellow/ off-white
              (new Color(157, 190, 187)), //light blue
              (new Color(119, 172, 162)), //light turquoise
              (new Color(70, 129, 137)),  //darker turquoise
              (new Color(3, 25, 38))}; //dark blue

      return scheme;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );
      createColorScheme(chart, getColorScheme());
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}