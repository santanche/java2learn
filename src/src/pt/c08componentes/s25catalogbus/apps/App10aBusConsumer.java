package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;

public class App10aBusConsumer {
  public static void main(String args[])
  {
      try {
        IBusConsumer ds = new BusConsumerComponent();
        ds.setBusURI("tcp://localhost:1883");
        ds.setTopic("sensor/+/+");
        
        /*
        System.out.println("=== Attributes ===");
        String attributes[] = ds.requestAttributes();
        for (int a = 0; a < attributes.length-1; a++)
          System.out.print(attributes[a] + ", ");
        System.out.println(attributes[attributes.length-1]);
        
        System.out.println();
        System.out.println("=== Instances ===");
        String instances[][] = ds.requestInstances();
        for (int i = 0; i < instances.length; i++) {
          for (int a = 0; a < attributes.length-1; a ++)
            System.out.print(instances[i][a] + ", ");
          System.out.println(instances[i][attributes.length-1]);
        }
        */
        
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
