package pt.c08componentes.s25catalogbus.s00shared;

import java.util.Date;

public class SensorReading {
   private Date timestamp;
   private String dimension;
   private double value;
   private String unity;
   
   public Date getTimestamp() {
      return timestamp;
   }
   
   public void setTimestamp(Date timestamp) {
      this.timestamp = timestamp;
   }
   
   public String getDimension() {
      return dimension;
   }
   
   public void setDimension(String dimension) {
      this.dimension = dimension;
   }
   
   public double getValue() {
      return value;
   }
   
   public void setValue(double value) {
      this.value = value;
   }
   
   public String getUnity() {
      return unity;
   }
   
   public void setUnity(String unity) {
      this.unity = unity;
   }
}
