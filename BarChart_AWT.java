import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class BarChart_AWT extends ApplicationFrame {
   
   public BarChart_AWT( String applicationTitle) {
      super( applicationTitle );
      setContentPane( createDemoPanel() );
   }

   public static JPanel createDemoPanel(){
      JFreeChart chart = createBarChart(createDataset( ));
      createColorScheme(chart, getColorScheme());
      ChartPanel chartPanel = new ChartPanel( chart );
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
      return new ChartPanel( chart );
   }

   private static JFreeChart createBarChart(CategoryDataset dataset){
      JFreeChart barChart = ChartFactory.createBarChart(
              "Which car do you like?",
              "Category",
              "Score",
              dataset,
              PlotOrientation.VERTICAL,
              true, true, false);

      return barChart;
   }
   
   private static CategoryDataset createDataset() {
      final String fiat = "FIAT";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 1.0 , fiat , speed );        
      dataset.addValue( 3.0 , fiat , userrating );        
      dataset.addValue( 5.0 , fiat , millage ); 
      dataset.addValue( 5.0 , fiat , safety );           

      dataset.addValue( 5.0 , audi , speed );        
      dataset.addValue( 6.0 , audi , userrating );       
      dataset.addValue( 10.0 , audi , millage );        
      dataset.addValue( 4.0 , audi , safety );

      dataset.addValue( 4.0 , ford , speed );        
      dataset.addValue( 2.0 , ford , userrating );        
      dataset.addValue( 3.0 , ford , millage );        
      dataset.addValue( 6.0 , ford , safety );               

      return dataset; 
   }

   private static void createColorScheme(JFreeChart chart, Color[] colorScheme){
      CategoryPlot plot = (CategoryPlot) chart.getPlot();
      BarRenderer renderer = (BarRenderer) plot.getRenderer();
      CategoryDataset ds = plot.getDataset();

      for(int i = 0; i < ds.getColumnCount(); i++){
         renderer.setSeriesPaint(i, colorScheme[i]);
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
}