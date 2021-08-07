package pt.c06patterns.factory.s10components.sequence;

public class SequenceFactory {
   @SuppressWarnings("unchecked")
   public static <IType extends ISequence> IType createSequence(String type) {
      IType sequence = null;
      
      try {
         if (type.equalsIgnoreCase("fibonacci"))
            sequence = (IType)new Fibonacci();
         else if (type.equalsIgnoreCase("arithmetic"))
            sequence = (IType)new ArithmeticProgression();
         else if (type.equalsIgnoreCase("geometric"))
            sequence = (IType)new GeometricProgression();
      } catch (ClassCastException e) {
         e.printStackTrace();
      }
         
      return sequence;
   }
}
