package pt.c06patterns.factory.s10components.sequence;

public class MathSequenceFactory {
   public static IMathSequence createSequence(String type) {
      IMathSequence sequence = createSequenceRatio(type);
      
      if (sequence == null && type.equalsIgnoreCase("fibonacci"))
         sequence = new Fibonacci();
      
      return sequence;
   }

   public static IMathSequenceRatio createSequenceRatio(String type) {
      IMathSequenceRatio sequence = null;
      
      if (type.equalsIgnoreCase("arithmetic"))
         sequence = new ArithmeticProgression();
      else if (type.equalsIgnoreCase("geometric"))
         sequence = new GeometricProgression();
      
      return sequence;
   }
}
