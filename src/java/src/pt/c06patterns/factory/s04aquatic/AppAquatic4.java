package pt.c06patterns.factory.s04aquatic;

import java.util.Scanner;

import pt.c06patterns.factory.s04aquatic.interfaces.IAquaticFactory;
import pt.c06patterns.factory.s04aquatic.interfaces.IFishTank;
import pt.c06patterns.factory.s04aquatic.interfaces.ISeaAnimal;

public class AppAquatic4 {
   public static void main(String[] args) {
      System.out.print("Digite o tipo de apresentação (console ou gui): ");
      Scanner teclado = new Scanner(System.in);
      String type = teclado.nextLine();
      teclado.close();

      IAquaticFactory factory = AquaticAbstractFactory.createFactory(type);
      ISeaAnimal aq1 = factory.createSeaAnimal("fish"),
                 aq2 = factory.createSeaAnimal("crab");
      IFishTank ft = factory.createFishTank("standard");
      ft.addSeaAnimal(aq1);
      ft.addSeaAnimal(aq2);
      ft.showFishTank();
    }
}
