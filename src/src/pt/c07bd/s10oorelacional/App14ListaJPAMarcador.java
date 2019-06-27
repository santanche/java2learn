package pt.c07bd.s10oorelacional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App14ListaJPAMarcador {
   
   public static void main(String args[]) {
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      List<Marcador> result =
            manager.createQuery("from MARCADOR", Marcador.class).getResultList();
      for (Marcador marca : result) {
         Taxonomia tax = marca.getCategoria();
         System.out.println(
               "Marcador (" + marca.getTitulo() + ", " + marca.getEndereco() + ", " +
               marca.getAcessos() +
               ", Taxonomia(" + tax.getCategoria() + ", " + tax.getCategoriaSuperior() + "))");
      }
      
      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
   }   
}
