package pt.c08componentes.s25catalogbus.s45producer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

import pt.c08componentes.s25catalogbus.s00shared.ITableProducer;
import pt.c08componentes.s25catalogbus.s00shared.Message;
import pt.c08componentes.s25catalogbus.s00shared.SensorReading;

public class BusProducerComponent implements IBusProducer, MqttCallback {
  private String busURI = null;
  private String topic = null;
  private int verbose = 2;
  
  private int count = 0;
  
  private ITableProducer iProducer;
  
  private Genson genson;

  private MqttClient client;
  private MqttConnectOptions connectionOptions;
  private String clientID;
  private final int qos = 1; 
  
  public BusProducerComponent() {
     genson = new GensonBuilder()
           .useDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
           .useIndentation(true)
           .useConstructorWithArguments(false)
           .create();
  }

  public String getBusURI() {
    return busURI;
  }

  public void setBusURI(String busURI) {
    this.busURI = busURI;
    clientID = UUID.randomUUID().toString();      
    connectionOptions = new MqttConnectOptions();
    connectionOptions.setAutomaticReconnect(true);
    connectionOptions.setCleanSession(true);
    connectionOptions.setConnectionTimeout(20);
     
    try {
      client = new MqttClient(busURI, clientID);
      client.connect(connectionOptions);            
      client.setCallback(this);
      System.out.println("[MQTTProducer] connected");            
    } catch (MqttException e) {
      e.printStackTrace();
    }
  }
  
  public String getTopic() {
     return topic;
  }
  
  public void setTopic(String topic) {
     this.topic = topic;
  }
  
  public int getVerbose() {
     return verbose;
  }
  
  public void setVerbose(int verbose) {
     this.verbose = verbose;
  }
  
  public void connect(ITableProducer producer) {
     iProducer = producer;
  }
   
  public void update() {
     if (iProducer != null) {
        String instances[][] = iProducer.requestInstances();
        double av = 0;
        for (int i = 0; i < instances.length; i++)
           av += Double.parseDouble(instances[i][3]);
        av = (av == 0) ? 0 : av / instances.length;
        
        Message mess = new Message("statistics", "average", "calculus",
              new SensorReading(Calendar.getInstance().getTime(), "temperature", av, instances[0][4])
        );
        String json = genson.serialize(mess);
        MqttMessage message = new MqttMessage(json.getBytes());
        message.setQos(qos);
        
         try {
            client.publish(topic, message);
          } catch (MqttException e) {
            e.printStackTrace();
          }
        count++;
        switch (verbose) {
        case 1: System.out.println("message: " + count); break;
        case 2: System.out.println("message: " + count);
                System.out.println(json);
                break;
        }        
     }
   }
  
  @Override
  public void connectionLost(Throwable cause) {
    System.out.println("[BusProducerComponent] Connection lost.  Reason: " + cause);
    System.exit(1);
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws MqttException {
  }

  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }
}
