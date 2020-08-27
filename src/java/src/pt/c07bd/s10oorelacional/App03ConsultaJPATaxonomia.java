package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App03ConsultaJPATaxonomia {
   
   public static void main(String args[]) {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      Taxonomia fotos = manager.find(Taxonomia.class, "Fotos");
      
      System.out.println(
            "Fotos (" + fotos.getCategoria() + ", " + fotos.getCategoriaSuperior() + ")");
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
   }   
}
