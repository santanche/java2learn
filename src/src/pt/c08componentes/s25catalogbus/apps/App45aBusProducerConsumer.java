package pt.c08componentes.s25catalogbus.apps;

import pt.c08componentes.s25catalogbus.s15consumer.BusConsumerComponent;
import pt.c08componentes.s25catalogbus.s15consumer.IBusConsumer;
import pt.c08componentes.s25catalogbus.s45producer.BusProducerComponent;
import pt.c08componentes.s25catalogbus.s45producer.IBusProducer;

public class App45aBusProducerConsumer {
  public static void main(String args[])
  {
      try {
         IBusConsumer bc = new BusConsumerComponent();
         bc.setBusURI("tcp://localhost:1883");
         bc.setTopic("sensor/+/+");
         bc.setBlockSize(10);
         bc.setVerbose(2);  // mostra todas as mensagens
        
         IBusProducer bp = new BusProducerComponent();
         bp.setBusURI("tcp://localhost:1883");
         bp.setTopic("sensor/avg/temperature_avg");
         bp.connect(bc);
         
         bc.connect(bp);
      } catch (Exception e) {
        e.printStackTrace();
      }
  }
}
