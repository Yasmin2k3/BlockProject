import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;

public class PieChart_AWT extends ApplicationFrame {
   private Color[] colorScheme;
   private String title;

   // Class initialization
   public PieChart_AWT( String title ) {
      super( title );
      this.title = title;
      this.colorScheme = getDefaultColorScheme();
   }

   //sets default colour scheme
   private static Color[] getDefaultColorScheme(){
      Color[] scheme = {(new Color(244, 233, 205)), //yellow/ off-white
              (new Color(157, 190, 187)), //light blue
              (new Color(119, 172, 162)), //light turquoise
              (new Color(70, 129, 137)),  //darker turquoise
              (new Color(3, 25, 38))}; //dark blue

      return scheme;
   }

   //you can set the colour scheme with this!!!
   public void setColorScheme(Color[] scheme){
      this.colorScheme = scheme;
   }

   //dataset for pie chart, making the inputs two arrays so to keep things simple, but some kind of mapping would be better
   private static PieDataset createDataset(String[] keys, double[] values) {
      DefaultPieDataset dataset = new DefaultPieDataset( );

      if (keys.length != values.length){
         System.out.println("dataset keys and values not the right length!");
         return null;
      }
      for (int i=0; i< keys.length; i++){
         dataset.setValue(keys[i], values[i]);
      }
      return dataset;         
   }
   
   private static JFreeChart createChart(String title, PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         title,   // chart title
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }

   //Following 2 methods are of my own doing, with this, you can make a colour scheme for the pie chart
   //and with this I'm sure we can figure out how to implement this for the other graphs as well

   private void createColorScheme(JFreeChart chart){
      PiePlot plot = (PiePlot) chart.getPlot();
      PieDataset ds = plot.getDataset();

      for(int i = 0; i < ds.getItemCount(); i++){
         plot.setSectionPaint(ds.getKey(i), colorScheme[i]);
      }
   }
   
   public JPanel createPanel() {
         String[] phones = {"idle", "user", "sys", "soft", "guest"};
         double[] nums = {70.5, 1.19, 10.49, 7.80, 10.02};

         JFreeChart chart = createChart(title, createDataset(phones, nums) );
         createColorScheme(chart);
         return new ChartPanel( chart );
      }
}