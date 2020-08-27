package pt.c07bd.s10oorelacional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MARCADOR")
@Access(AccessType.PROPERTY)
public class Marcador {
   private String titulo;
   private String endereco;
   private int acessos;
   private Taxonomia categoria;
   
   public Marcador() {
      super();
   }
   
   public Marcador(String titulo, String endereco, int acessos, Taxonomia categoria) {
      super();
      this.titulo = titulo;
      this.endereco = endereco;
      this.acessos = acessos;
      this.categoria = categoria;
   }

   @Id
   @Column(name = "TITULO", nullable = false, length=50)
   public String getTitulo() {
       return titulo;
   }
   
   public void setTitulo(String titulo) {
       this.titulo = titulo;
   }
   
   @Column(name = "ENDERECO", nullable = false, length=80)
   public String getEndereco() {
       return endereco;
   }
   
   public void setEndereco(String endereco) {
       this.endereco = endereco;
   }
   
   @Column(name = "ACESSOS")
   public int getAcessos() {
       return acessos;
   }
   
   public void setAcessos(int acessos) {
       this.acessos = acessos;
   }

   @ManyToOne(optional = false)
   @JoinColumn(name = "CATEGORIA", referencedColumnName="CATEGORIA")
   public Taxonomia getCategoria() {
      return categoria;
   }

   public void setCategoria(Taxonomia categoria) {
      this.categoria = categoria;
   }
}
