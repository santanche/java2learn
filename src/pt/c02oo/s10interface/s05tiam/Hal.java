package pt.c02oo.s10interface.s05tiam;

public class Hal implements Tiai {
   private String structure[] = {
     "Bonerges", "Robesberto", "Melissa"    
   };
   private int cursor = 0;
   
   public String first() {
      cursor = 0;
      
      return structure[cursor];
   }
   
   public String next() {
      cursor++;
      
      return (cursor < structure.length)?structure[cursor]:null;
   }
}
