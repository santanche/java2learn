package pt.c08componentes.s10statistics.s01class;

public class AppStatistics01 {
   public static void main(String args[])
   {
       try {
           Statistics stat = new Statistics();

           System.out.println("inserido valor: " + 50.0f);
           stat.insertValue(50.0f);
           System.out.println("inserido valor: " + 70.0f);
           stat.insertValue(70.0f);
           System.out.println("inserido valor: " + 30.0f);
           stat.insertValue(30.0f);
       
           System.out.println("-- somatorio: " + stat.sum());
           System.out.println("-- media: " + stat.average());
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

}
