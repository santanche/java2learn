package pt.c08componentes.s10statistics.s03component.v02;

public class AppStatistics03b {
   public static void main(String args[])
   {
       try {
           IStatistics stat = new StatisticsComponent(3);

           System.out.println("inserido valor: " + 50.0f);
           stat.insertValue(50.0f);
           System.out.println("inserido valor: " + 70.0f);
           stat.insertValue(70.0f);
           System.out.println("inserido valor: " + 30.0f);
           stat.insertValue(30.0f);
       
           System.out.println("-- somatorio: " + stat.sum());
           System.out.println("-- media: " + stat.average());
           System.out.println("-- tamanho: " + stat.getSize());
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

}
