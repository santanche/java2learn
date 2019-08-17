package pt.c08componentes.s25catalogbus.s50chart;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.knowm.xchart.BubbleChart;
import org.knowm.xchart.BubbleChartBuilder;
import org.knowm.xchart.SwingWrapper;

import pt.c08componentes.s25catalogbus.s00shared.ITableProducer;

public class ChartBubbleComponent implements IChart {
  private BubbleChart chart = null;

  private String title = "Chart";
  private String xTitle = "X",
                 yTitle = "Y";

  private ITableProducer producer = null;

  private SwingWrapper<BubbleChart> window = null;
  
  public void connect(ITableProducer producer) {
    this.producer = producer;
  }
  
  public ChartBubbleComponent() {
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }

  public String getXTitle() {
    return xTitle;
  }
  
  public void setXTitle(String title) {
    xTitle = title;
  }

  public String getYTitle() {
    return title;
  }
  
  public void setYTitle(String title) {
    yTitle = title;
  }

  public boolean start() {
    boolean status = true;
    
    if (window == null) {
      chart = new BubbleChartBuilder().width(800).height(600).title(title).xAxisTitle(xTitle).yAxisTitle(yTitle).build();;
      window = new SwingWrapper<BubbleChart>(chart);
      if (window != null)
        window.displayChart();
      else
        status = false;
    }
    
    return status;
  }
  
  public boolean stop() {
    return true;
  }
  
  public void update() {
     buildChart();
  }
  
  public double[] toDouble(String[][] instances, int column ) {
    double[] numbers = new double[instances.length];
    for (int i = 0; i < instances.length; i++)
      numbers[i] = Double.parseDouble(instances[i][column]);
    return numbers;
  }

  private void buildChart() {
    if (chart != null && producer != null) {
      String[][] instances = producer.requestInstances();

      if (instances != null) {
        System.out.println("Plotando...");
        double[] xData = toDouble(instances, 0),
                 yData = toDouble(instances, 1);
        
        String[] categoryData = null;
        if (instances[0].length > 2) {
          categoryData = new String[instances.length];
          for (int c = 0; c < instances.length; c++)
            categoryData[c] = instances[c][2];
        }
        
        double[] bubbleData = null;
        if (instances[0].length > 3)
          bubbleData = toDouble(producer.requestInstances(), 3);
        else {
          bubbleData = new double[instances.length];
          for (int i = 0; i < xData.length; i++)
            bubbleData[i] = 10;
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
  
}
