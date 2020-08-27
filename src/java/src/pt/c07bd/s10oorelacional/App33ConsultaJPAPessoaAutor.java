package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App33ConsultaJPAPessoaAutor {
   
   public static void main(String args[]) {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      Pessoa p = manager.find(Pessoa.class, "Asdrubal");
      Autor a = manager.find(Autor.class, "Quincas");
      
      System.out.println(
    	 "Pessoa (" + p.getNome() + ", " + p.getEmail() + ")");
      System.out.println(
         "Autor (" + a.getNome() + ", " + a.getEmail() + ", " + a.getEstilo() + ")");
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
   }   
}
