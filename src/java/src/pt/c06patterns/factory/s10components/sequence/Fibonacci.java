package pt.c06patterns.factory.s10components.sequence;

public class Fibonacci implements IMathSequence {
   private int initialCurrent, initialNext;
   private int current, next;
   
   public Fibonacci() {
      initialCurrent = 0;
      initialNext = 1;
      current = 0;
      next = 1;
   }
   
   public int getInitial() {
      return initialCurrent;
   }
   
   public void setInitial(int initial) {
      current = 0;
      next = 1;
      while (initial > current) {
         int sum = current + next;
         current = next;
         next = sum;
      }
      initialCurrent = current;
      initialNext = next;
   }
   
   public int first() {
      current = initialCurrent;
      next = initialNext;
      return current;
   }
   
   public int next() {
      int sum = current + next;
      current = next;
      next = sum;
      return current;
   }
}
