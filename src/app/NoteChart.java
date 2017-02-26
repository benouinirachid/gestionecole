/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author vector
 */
public class NoteChart extends JFrame {

    XYSeries series1;
    String ChartName = "";
    String XName = "Annees";
    String YName = "note /20";
    XYSeriesCollection dataset;
    String title;
    ChartPanel chartPanel;
    int id;

    public NoteChart(int id){
        super();
        this.id=id;
        
    }
    
    public NoteChart() {
        super();
        //dataset = createDataset();
        series1 = new XYSeries("notes");
        dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        for (int i = 0; i < 8; i++) {
            series1.add(i, Math.random()*10*2);
        }
        JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 150));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     *
     * @param dataset the data for the chart.
     *
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                ChartName,//"Validation Selon nombre de question dans l'éxamen", // chart title
                XName,//"Nombre de question", // x axis label
                YName,//"Nombre d'étudiants validés", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
//        plot.setBackgroundPaint(Color.lightGray);
        plot.setBackgroundPaint(new Color(220, 220, 220));
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    public static void main(String args[]) {
        NoteChart demo = new NoteChart();
        //BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        int w = demo.chartPanel.getWidth();
        int h = demo.chartPanel.getHeight();
        
        System.out.println("w="+w+"h="+h);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
