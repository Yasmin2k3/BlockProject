import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class Main {
    public static void main( String[ ] args ) {
        printPieChart();
        //printBarChart();
    }

    private static void printPieChart(){
        PieChart_AWT demo = new PieChart_AWT( "CPU Usage" );

        //make a custom colour scheme like this:
        //this is an array of colours for the scheme
        Color[] colorScheme = {new Color(177, 207, 95),
                                new Color(27, 81, 45),
                                new Color(222, 244, 198),
                                new Color(115, 226, 167),
                                new Color(28, 124, 84)};
        demo.setColorScheme(colorScheme); //this is how you actually set the scheme

        //showing the pie chart:
        demo.setContentPane(demo.createPanel());
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
    }

    private static void printBarChart(){
        BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics", "Which car do you like?");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
