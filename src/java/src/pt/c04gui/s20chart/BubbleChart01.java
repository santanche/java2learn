package pt.c04gui.s20chart;

import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.BubbleChartBuilder;
import org.knowm.xchart.SwingWrapper;

/**
 * Basic Bubble Chart
 * 
 * Demonstrates the following:
 * <ul>
 * <li>Bubble Chart
 */
public class BubbleChart01 {
 
  public static void main(String[] args) {
 
    BubbleChart01 exampleChart = new BubbleChart01();
    BubbleChart chart = exampleChart.getChart();
    new SwingWrapper<BubbleChart>(chart).displayChart();
  }
 
  public BubbleChart getChart() {
 
    // Create Chart
    BubbleChart chart = new BubbleChartBuilder().width(800).height(600).title("BubbleChart01").xAxisTitle("X").yAxisTitle("Y").build();
 
    // Customize Chart
 
    // Series
    double[] xData = new double[] { 1.5, 2.6, 3.3, 4.9, 5.5, 6.3, 1, 2.0, 3.0, 4.0, 5, 6 };
    double[] yData = new double[] { 10, 4, 7, 7.7, 7, 5.5, 10, 4, 7, 1, 7, 9 };
    double[] bubbleData = new double[] { 17, 40, 50, 51, 26, 20, 66, 35, 80, 27, 29, 44 };
 
    double[] xData2 = new double[] { 1, 2.0, 3.0, 4.0, 5, 6, 1.5, 2.6, 3.3, 4.9, 5.5, 6.3 };
    double[] yData2 = new double[] { 1, 2, 3, 4, 5, 6, 10, 8.5, 4, 1, 4.7, 9 };
    double[] bubbleData2 = new double[] { 37, 35, 80, 27, 29, 44, 57, 40, 50, 33, 26, 20 };
 
    chart.addSeries("A", xData, yData, bubbleData);
    chart.addSeries("B", xData2, yData2, bubbleData2);
 
    return chart;
  }
 
}