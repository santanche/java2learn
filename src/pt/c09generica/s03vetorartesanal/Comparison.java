package pt.c09generica.s03vetorartesanal;

public class Comparison<T> {

   public T greater(T v1, T v2) {
      T result = null;
      
      if (v1 instanceof Comparable && v2 instanceof Comparable) {
         Comparable vc1 = (Comparable)v1;
         Comparable vc2 = (Comparable)v2;
         if (vc1.compareTo(vc2) > 0)
            result = v1;
         else
            result = v2;
      }
      
      return result;
   }
   
}
