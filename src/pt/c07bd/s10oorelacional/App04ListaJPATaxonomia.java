package pt.c07bd.s10oorelacional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App04ListaJPATaxonomia {
   
   public static void main(String args[]) {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      List<Taxonomia> result =
            manager.createQuery("from TAXONOMIA", Taxonomia.class).getResultList();
      for (Taxonomia tax : result)
         System.out.println(
               "Fotos (" + tax.getCategoria() + ", " + tax.getCategoriaSuperior() + ")");
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
   }   
}
