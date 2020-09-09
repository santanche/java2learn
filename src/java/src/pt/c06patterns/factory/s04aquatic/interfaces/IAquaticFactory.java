package pt.c06patterns.factory.s04aquatic.interfaces;

public interface IAquaticFactory {
   public ISeaAnimal createSeaAnimal(String type);
   public IFishTank createFishTank(String type);
}
