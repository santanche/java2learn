package pt.c08componentes.s01javabeans;

public class App02BeanCirculo {

   public static void main(String[] args) {
      Bean02Circulo b = new Bean02Circulo();
      System.out.println("Raio padrao: " + b.getRaio());
      System.out.println("Area padrao: " + b.getArea());
      
      b.setRaio(30);
      System.out.println("Novo raio: " + b.getRaio());
      System.out.println("Nova area: " + b.getArea());
  }

}
