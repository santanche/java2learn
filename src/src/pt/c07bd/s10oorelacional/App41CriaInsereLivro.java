package pt.c07bd.s10oorelacional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App41CriaInsereLivro {
   
   public static void main(String args[]) {
      // nome definido em persistence.xml <persistence-unit>
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      List<Autor> autores = new ArrayList<Autor>();

      Autor r = new Autor("Reco-reco", "recoreco@asdrubolandia.com", "Comedia");
      manager.persist(r);
      autores.add(r);
      
      Autor b = new Autor("Bolao", "bolao@asdrubolandia.com", "Comedia");
      manager.persist(b);
      autores.add(b);
      
      Autor a = new Autor("Azeitona", "azeitona@asdrubolandia.com", "Comedia");
      manager.persist(a);
      autores.add(a);
      
      Livro l = new Livro("0123456789", "A vida secreta dos dinossauros", autores, 1970, "Piadas");
      manager.persist(l);
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
      
      System.out.println("Tabela criada, dados inseridos!");
   }   
}
