package pt.c06patterns.factory.s01aquatic;

public class AppAquaticConsole1 {
   public static void main(String[] args) {
      ISeaAnimal aq1 = new FishConsole(),
                 aq2 = new CrabConsole();
      IFishTank ft = new FishTankConsole();
      ft.addSeaAnimal(aq1);
      ft.addSeaAnimal(aq2);
      ft.showFishTank();
    }
}
