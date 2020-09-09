package pt.c06patterns.factory.s02aquatic;

public class AppAquaticGUI1 {
   public static void main(String[] args) {
      ISeaAnimal aq1 = new FishGUI(),
                 aq2 = new CrabGUI();
      IFishTank ft = new FishTankGUI();
      ft.addSeaAnimal(aq1);
      ft.addSeaAnimal(aq2);
      ft.showFishTank();
    }
}
