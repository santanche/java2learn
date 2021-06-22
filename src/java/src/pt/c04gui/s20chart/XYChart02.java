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

public class XYChart02 {
 
  public static void main(String[] args) {
    XYChart02 exampleChart = new XYChart02();
    XYChart chart = exampleChart.getChart();
    new SwingWrapper<XYChart>(chart).displayChart();
  }
 
  public XYChart getChart() {
 
    // Create Chart
    XYChart chart = new XYChartBuilder().width(800).height(600).title("Line Chart").xAxisTitle("X").yAxisTitle("Y").build();
 
    // Customize Chart
    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
    chart.getStyler().setChartTitleVisible(false);
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAxisTitlesVisible(false);
    chart.getStyler().setXAxisDecimalPattern("0.0000000");
 
    // Series
    int size = 10;
    List<Double> xData = new ArrayList<Double>();
    List<Double> yData = new ArrayList<Double>();
    for (int i = 0; i <= size; i++) {
      xData.add(((double) i) / 1000000);
      yData.add(10 * Math.exp(-i));
    }
    XYSeries series = chart.addSeries("10^(-x)", xData, yData);
    series.setMarkerColor(Color.RED);
    series.setMarker(SeriesMarkers.SQUARE);
 
    return chart;
  }
 
}