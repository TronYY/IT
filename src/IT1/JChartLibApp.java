package IT1;
/**
 * JChartLib Demo App for a Linechart
 */
import com.bitagentur.chart.JChartLibLinechart;
import com.bitagentur.data.JChartLibDataSet;
import com.bitagentur.data.JChartLibSerie;
import com.bitagentur.renderer.JChartLibPanel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
/**
* A simple demonstration application showing how to create a line chart
*/
public class JChartLibApp extends JFrame implements WindowListener {
/**
 * Creates a new Application Frame
 */
public JChartLibApp() {
    super("JChartLib Demo Appllication");
    final JChartLibDataSet dataset = createDataset();
    final JChartLibBaseChart chart = createChart(dataset);
    final JChartLibPanel chartPanel = new JChartLibPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
    setContentPane(chartPanel);
}

/**
 * Creates a sample dataset.
 * 
 * @return a sample dataset.
 */
private JChartLibDataSet createDataset() {
    //Dataseries can be added with int arrays
    int[] values1 = new int[5];
    values1[0] = 1;
    values1[1] = 3;
    values1[2] = 4;
    values1[3] = 7;
    values1[4] = 2;

    //or by generating a Dataserie object
    JChartLibSerie values2 = new JChartLibSerie("Banana");
    values2.addValue(5);
    values2.addValue(4);
    values2.addValue(2);
    values2.addValue(6);
    values2.addValue(2);

    final JChartLibDataSet dataset = new JChartLibDataSet();
    dataset.addDataSerie("Apple", values1);   //adds the apples
    dataset.addDataSerie(values2);            //adds the bananas

    return dataset;
}

/**
 * Creates a chart
 * 
 * @param dataset the data for the chart.
 * @return a new chart
 */
private JChartLibBaseChart createChart(final JChartLibDataSet dataset) {

    // create the chart with title and axis names
    final JChartLibLinechart chart = new JChartLibLinechart(
            "Fruits are good", // chart title
            "Time goes by", // x axis text
            "Number of Fruits", // y axis text
            dataset, // data
            true // legend on
            );

    return chart;
}

/**
 * Main method - DEMO Application for JChartLib
 *
 * @param args the command line arguments
 */
public static void main(final String[] args) {
    System.out.println("JChartLibApp started");
    final JChartLibApp app = new JChartLibApp();
    app.addWindowListener(app);
    app.pack();
    app.setVisible(true);
}

@Override
public void windowOpened(WindowEvent e) {
    //Nothing to do
}

@Override
public void windowClosing(WindowEvent e) {
    //Exit and goodby
    if (e.getWindow() == this) {
        dispose();
        System.out.println("Thanks for using the JChartLibApp");
        System.exit(0);
    }
}

@Override
public void windowClosed(WindowEvent e) {
    //Nothing to do

}

@Override
public void windowIconified(WindowEvent e) {
    //Nothing to do
}

@Override
public void windowDeiconified(WindowEvent e) {
    //Nothing to do
}

@Override
public void windowActivated(WindowEvent e) {
    //Nothing to do
}

@Override
public void windowDeactivated(WindowEvent e) {
    //Nothing to do
}
}