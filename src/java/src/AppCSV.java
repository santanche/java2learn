
public class AppCSV {
   public static void main(String args[]) {
      CSVHandling csv = new CSVHandling();
      /*
      String teste[] = {"ab1", "_b2", "xb3"};
      csv.setDataExport("/home/santanche/Documents/teste.txt");
      csv.exportState(teste);
      */
      
      String teste2[];
      csv.setDataSource("/home/santanche/Documents/teste.txt");
      teste2 = csv.requestCommands();
      for (int t = 0; t < teste2.length; t++)
         System.out.println(teste2[t]);
   }
}
