import org.jfree.ui.RefineryUtilities;

public class Main {
    public static void main( String[ ] args ) {
        //printPieChart();
        printBarChart();
    }

    private static void printPieChart(){
        PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );

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
