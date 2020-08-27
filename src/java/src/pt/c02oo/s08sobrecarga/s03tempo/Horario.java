package pt.c02oo.s08sobrecarga.s03tempo;

public class Horario {
   private int hora, minuto, segundo;
   
   public void define() {
      this.define(0, 0, 0);
   }
   
   public void define(int hora, int minuto, int segundo) {
      this.hora = hora;
      this.minuto = minuto;
      this.segundo = segundo;
   }
   
   public void define(String horario) {
      this.define(Integer.parseInt(horario.substring(0,2)),
                  Integer.parseInt(horario.substring(3,5)),
                  Integer.parseInt(horario.substring(6)));
   }
   
   public void tick() {
      segundo++;
      if (segundo == 60) {
         minuto++;
         segundo = 0;
      }
      if (minuto == 60) {
         hora++;
         minuto = 0;
      }
      if (hora == 24) {
         hora = 0;
         minuto = 0;
         segundo = 0;
      }
   }
   
   public String toString() {
      return hora + ":" + minuto + ":" + segundo;
   }
}
