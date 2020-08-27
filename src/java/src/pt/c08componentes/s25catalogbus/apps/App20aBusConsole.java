package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s20console.ConsoleComponent;
import pt.c08componentes.s25catalogbus.s20console.IConsole;

public class App20aBusConsole {
  public static void main(String args[])
  {
      try {
         IBusConsumer bc = new BusConsumerComponent();
         bc.setBusURI("tcp://localhost:1883");
         bc.setTopic("sensor/+/+");
         bc.setBlockSize(10);
         bc.setVerbose(2);  // mostra todas as mensagens
        
         IConsole console = new ConsoleComponent();
         console.connect(bc);
        
         bc.connect(console);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
