package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s20console.ConsoleComponent;
import pt.c08componentes.s25catalogbus.s20console.IConsole;
import pt.c08componentes.s25catalogbus.s30projection.IProjection;
import pt.c08componentes.s25catalogbus.s30projection.ProjectionComponent;

public class App30aBusProjection {
  public static void main(String args[])
  {
      try {
        IBusConsumer bc = new BusConsumerComponent();
        bc.setBusURI("tcp://localhost:1883");
        bc.setTopic("sensor/+/+");
        bc.setBlockSize(10);
        bc.setVerbose(2);  // mostra todas as mensagens
        
        IProjection projection = new ProjectionComponent();
        String[] attributes = {"dimension", "value"};
        projection.setAttributes(attributes);
        projection.connect(bc);

        IConsole console = new ConsoleComponent();
        console.connect(projection);
        
        bc.connect(console);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
