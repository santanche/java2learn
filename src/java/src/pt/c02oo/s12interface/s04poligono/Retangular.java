package pt.c02oo.s12interface.s04poligono;

public interface Retangular extends Geometria {
   public int getAltura();
   public int getLargura();
   public boolean sameProportions(Retangular toCompare);
}
