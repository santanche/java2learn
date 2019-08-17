package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s20console.ConsoleComponent;
import pt.c08componentes.s25catalogbus.s20console.IConsole;

public class App20aDataSetConsole {
  public static void main(String args[])
  {
      try {
         IBusConsumer ds = new BusConsumerComponent();
         ds.setBusURI("tcp://localhost:1883");
         ds.setTopic("sensor/+/+");
        
        IConsole console = new ConsoleComponent();
        console.connect(ds);
        
        console.update();
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
