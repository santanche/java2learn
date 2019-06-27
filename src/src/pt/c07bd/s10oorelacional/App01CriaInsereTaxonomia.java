package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App01CriaInsereTaxonomia {
   
   public static void main(String args[]) {
      // nome definido em persistence.xml <persistence-unit>
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      // cria um objeto em memoria e o persiste
      Taxonomia geral = new Taxonomia("Geral", "");
      manager.persist(geral);

      Taxonomia fotos = new Taxonomia("Fotos", "Geral");
      manager.persist(fotos);
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
      
      System.out.println("Tabela criada, dados inseridos!");
   }   
}
