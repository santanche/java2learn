package pt.c08componentes.s10statistics.s03component.v01;

public class AppStatistics03a {
   public static void main(String args[])
   {
       try {
           IStatisticsServices stat = new StatisticsComponent();

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
