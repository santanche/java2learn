package pt.c03java.s06wrapping.s03vetor;

public class AppVetorNumeros {
   public static void main(String args[]) {
      Object vetor[] = new Object[3];
      
      vetor[0] = 15;
      vetor[1] = 5.6f;
      vetor[2] = "dinossauro";
      
      for (int v = 0; v < vetor.length; v++)
         System.out.println(vetor[v]);
   }
}