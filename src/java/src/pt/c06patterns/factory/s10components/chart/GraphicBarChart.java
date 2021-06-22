package pt.c06patterns.factory.s10components.chart;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class GraphicBarChart extends BarChart {
 
  public void plot() {
    // Create Chart
    CategoryChart chart =
          new CategoryChartBuilder().width(800).height(600).
          title("Chart").xAxisTitle("X").yAxisTitle("Y").build();
 
    // Customize Chart
    chart.getStyler().setChartTitleVisible(false);
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAxisTitlesVisible(false);
    chart.getStyler().setXAxisDecimalPattern("0");
 
    // Series
    List<Integer> xData = new ArrayList<Integer>();
    List<Integer> yData = new ArrayList<Integer>();
    if (sequence != null) {
       int value = sequence.first();
       for (int s = 1; s <= n; s++) {
          xData.add(s);
          yData.add(value);
          value = sequence.next();
       }
    }
    chart.addSeries("series", xData, yData);
 
    new SwingWrapper<CategoryChart>(chart).displayChart();
  }
 
}