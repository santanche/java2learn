package pt.c09generica.s03vetorartesanal;

public class ComparisonConstrained<T extends Comparable> {

   public T greater(T v1, T v2) {
      T result = null;
      
      if (v1.compareTo(v2) > 0)
         result = v1;
      else
         result = v2;
      
      return result;
   }
   
}
