package pt.c07bd.s10oorelacional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TAXONOMIA")
@Access(AccessType.PROPERTY)
public class Taxonomia {
   private String categoria;
   
   private String categoriaSuperior;

   public Taxonomia() {
      super();
   }

   public Taxonomia(String categoria, String categoriaSuperior) {
      super();
      this.categoria = categoria;
      this.categoriaSuperior = categoriaSuperior;
   }

   @Id
   @Column(name = "CATEGORIA", nullable = false, length=50)
   public String getCategoria() {
      return categoria;
   }

   public void setCategoria(String categoria) {
      this.categoria = categoria;
   }

   @Column(name = "SUPERIOR", length=50)
   public String getCategoriaSuperior() {
      return categoriaSuperior;
   }

   public void setCategoriaSuperior(String categoriaSuperior) {
      this.categoriaSuperior = categoriaSuperior;
   }
}
