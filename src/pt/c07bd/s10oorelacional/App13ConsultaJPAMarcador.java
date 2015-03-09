package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App13ConsultaJPAMarcador {
   
   public static void main(String args[]) {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      Marcador marca = manager.find(Marcador.class, "Flikr");
      Taxonomia tax = marca.getCategoria();
      
      System.out.println(
            "Marcador (" + marca.getTitulo() + ", " + marca.getEndereco() + ", " +
            marca.getAcessos() +
            ", Taxonomia(" + tax.getCategoria() + ", " + tax.getCategoriaSuperior() + "))");
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
   }   
}
