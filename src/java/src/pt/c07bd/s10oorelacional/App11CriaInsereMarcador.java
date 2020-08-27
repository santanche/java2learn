package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App11CriaInsereMarcador {
   
   public static void main(String args[]) {
      // nome definido em persistence.xml <persistence-unit>
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      // recupera categoria de fotos
      Taxonomia fotos = manager.find(Taxonomia.class, "Fotos");
      
      // cria um objeto em memoria e o persiste
      Marcador flikr = new Marcador("Flikr", "http://www.flickr.com", 150, fotos);
      manager.persist(flikr);

      Marcador picasa = new Marcador("Picasa", "http://picasa.google.com", 140, fotos);
      manager.persist(picasa);
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
      
      System.out.println("Marcadores inseridos!");
   }   
}
