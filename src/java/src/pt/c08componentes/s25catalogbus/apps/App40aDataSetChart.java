package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s30projection.IProjection;
import pt.c08componentes.s25catalogbus.s30projection.ProjectionComponent;
import pt.c08componentes.s25catalogbus.s50chart.ChartBubbleComponent;
import pt.c08componentes.s25catalogbus.s50chart.IChart;

public class App40aDataSetChart {
  public static void main(String args[])
  {
      try {
         IBusConsumer bc = new BusConsumerComponent();
         bc.setBusURI("tcp://localhost:1883");
         bc.setTopic("sensor/+/+");
         bc.setBlockSize(10);
         bc.setVerbose(1);
        
        IProjection projection = new ProjectionComponent();
        projection.connect(bc);
        String attributes[] = {"message", "value"};
        projection.setAttributes(attributes);
        
        IChart chart = new ChartBubbleComponent();
        chart.setTitle("Temperature Reading");
        chart.setXTitle("Reading");
        chart.setYTitle("Temperature");
        chart.connect(projection);
        
        bc.connect(chart);
        
        boolean status = chart.start();
        if (!status)
          System.out.println("*** nao foi possivel criar o grafico ***");
      } catch (Exception e) {
        e.printStackTrace();
      }
  }

}
