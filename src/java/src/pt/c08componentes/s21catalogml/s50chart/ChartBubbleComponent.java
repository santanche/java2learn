package pt.c08componentes.s21catalogml.s50chart;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.BubbleChartBuilder;
import org.knowm.xchart.SwingWrapper;

import pt.c08componentes.s21catalogml.s00shared.IColumnProducer;

public class ChartBubbleComponent implements IChart {
  private BubbleChart chart = null;

  private String title = "Chart";
  private String xTitle = "X",
                 yTitle = "Y";

  private IColumnProducer xProducer = null,
                          yProducer = null,
                          bubbleProducer = null,
                          categoryProducer = null;

  private SwingWrapper<BubbleChart> window = null;
  
  public void connect(IColumnProducer producer) {
    connect(producer, ChartParameter.X_AXIS);
  }
  
  public void connect(IColumnProducer producer, ChartParameter role) {
    switch (role) {
      case X_AXIS:   xProducer = producer; break;
      case Y_AXIS:   yProducer = producer; break;
      case BUBBLE:   bubbleProducer = producer; break;
      case CATEGORY: categoryProducer = producer; break;
    }
  }
  
  public ChartBubbleComponent() {
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public boolean start() {
    boolean status = true;
    
    if (window == null) {
      xTitle = (xProducer != null) ? xProducer.getTitle() : xTitle;
      yTitle = (yProducer != null) ? yProducer.getTitle() : yTitle;
      chart = new BubbleChartBuilder().width(800).height(600).title(title).xAxisTitle(xTitle).yAxisTitle(yTitle).build();;
      window = new SwingWrapper<BubbleChart>(chart);
      if (window != null) {
        window.displayChart();
        buildChart();
      } else
        status = false;
    }
    
    return status;
  }
  
  public boolean stop() {
    return true;
  }

  private void buildChart() {
    if (chart != null && xProducer != null && yProducer != null) {
      double[] xData = xProducer.requestValues(),
               yData = yProducer.requestValues();
      double[] bubbleData = null;
      String[] categoryData = (categoryProducer == null)?null:categoryProducer.requestNominals();
      
      if (bubbleProducer == null) {
        bubbleData = new double[xData.length];
        for (int i = 0; i < xData.length; i++)
          bubbleData[i] = 10;
      } else {
        bubbleData = bubbleProducer.requestValues();
      }
      
      if (categoryData == null ||
          xData.length != yData.length || yData.length != bubbleData.length ||
          bubbleData.length != categoryData.length) {
        chart.addSeries(" ", xData, yData, bubbleData);
      } else {
        Hashtable<String,String> hash = new Hashtable<String,String>();
        int outer = 0;
        int size = categoryData.length;
        while (outer < size) {
          if (hash.containsKey(categoryData[outer]))
            outer++;
          else {
            hash.put(categoryData[outer],categoryData[outer]);
            List<Double> xSub = new ArrayList<Double>(),
                         ySub = new ArrayList<Double>(),
                         bubbleSub = new ArrayList<Double>();
            for (int inner = outer; inner < size; inner++)
              if (categoryData[inner].equalsIgnoreCase(categoryData[outer])) {
                xSub.add(xData[inner]);
                ySub.add(yData[inner]);
                bubbleSub.add(bubbleData[inner]);
              }
            chart.addSeries(categoryData[outer], xSub, ySub, bubbleSub);
            outer++;
          }
        }
      }
    }
  }
  
}
