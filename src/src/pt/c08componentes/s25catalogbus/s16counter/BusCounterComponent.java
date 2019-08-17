package pt.c08componentes.s25catalogbus.s16counter;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import pt.c08componentes.s25catalogbus.s20console.IConsole;

public class BusCounterComponent implements IBusCounter, MqttCallback {
  private String busURI = null;
  private String topic = null;
  private int trigger = 10;
  private IConsole notify = null;
  private int count = 0;
  
  private MqttClient client;
  private MqttConnectOptions connectionOptions;
  private String clientID;  
  
  public BusCounterComponent() {
    /* nothing */
  }

  public String getBusURI() {
    return busURI;
  }

  public void setBusURI(String busURI) {
    this.busURI = busURI;
  }
  
  public String getTopic() {
     return topic;
  }
  
  public void setTopic(String topic) {
     this.topic = topic;
     readDS();
  }
  
  public int getTrigger() {
     return trigger;
  }
  
  public void setTrigger(int trigger) {
     this.trigger = trigger;
  }
  
  public void connect(IConsole notify) {
     this.notify = notify;
  }
  
  private void readDS() {
    clientID = UUID.randomUUID().toString();      
    connectionOptions = new MqttConnectOptions();
    connectionOptions.setAutomaticReconnect(true);
    connectionOptions.setCleanSession(true);
    connectionOptions.setConnectionTimeout(20);
     
    try {
      client = new MqttClient(busURI, clientID);
      client.connect(connectionOptions);            
      client.setCallback(this);
      client.subscribe(topic);
      System.out.println("[BusCounterComponent] connected");            
    } catch (MqttException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void connectionLost(Throwable cause) {
    System.out.println("[BusCounterComponent] Connection lost.  Reason: " + cause);
    System.exit(1);
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws MqttException {
     count++;
     if (count == trigger)
        notify.update();
  }


  @Override
  public void deliveryComplete(IMqttDeliveryToken token) {
  }
}
