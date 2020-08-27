package pt.c04gui.s20chart;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * Exemplo copiado do tutorial do XChart e adaptado
 * https://knowm.org/open-source/xchart/xchart-example-code/
 * 
 * Error Bars
 * 
 * Demonstrates the following:
 * <ul>
 * <li>Error Bars
 * <li>Using ChartBuilder to Make a Chart
 * <li>List<Number> data sets
 * <li>Setting Series Marker and Marker Color
 * <li>Using a custom decimal pattern
 */
public class ScatterChart04 {
 
  public static void main(String[] args) {
    ScatterChart04 exampleChart = new ScatterChart04();
    XYChart chart = exampleChart.getChart();
    new SwingWrapper<XYChart>(chart).displayChart();
  }
 
  public XYChart getChart() {
 
    // Create Chart
    XYChart chart = new XYChartBuilder().width(800).height(600).title("ScatterChart04").xAxisTitle("X").yAxisTitle("Y").build();
 
    // Customize Chart
    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
    chart.getStyler().setChartTitleVisible(false);
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAxisTitlesVisible(false);
    chart.getStyler().setXAxisDecimalPattern("0.0000000");
 
    // Series
    int size = 10;
    List<Double> xData = new ArrayList<Double>();
    List<Double> yData = new ArrayList<Double>();
    List<Double> errorBars = new ArrayList<Double>();
    for (int i = 0; i <= size; i++) {
      xData.add(((double) i) / 1000000);
      yData.add(10 * Math.exp(-i));
      errorBars.add(Math.random() + .3);
    }
    XYSeries series = chart.addSeries("10^(-x)", xData, yData, errorBars);
    series.setMarkerColor(Color.RED);
    series.setMarker(SeriesMarkers.SQUARE);
 
    return chart;
  }
 
}