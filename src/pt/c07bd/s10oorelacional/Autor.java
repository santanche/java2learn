package pt.c07bd.s10oorelacional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "AUTOR")
@Access(AccessType.PROPERTY)
@DiscriminatorValue("A")
@PrimaryKeyJoinColumn(name="NOME",referencedColumnName="NOME")
public class Autor extends Pessoa {

   private String estilo;

   public Autor() {
      super();
      setTipoPessoa('A');
   }
   
   public Autor(String nome, String email, String estilo) {
      super(nome, email);
      this.estilo = estilo;
      setTipoPessoa('A');
   }

   @Column(name = "ESTILO", length=50)
   public String getEstilo() {
	   return estilo;
   }
	
   public void setEstilo(String estilo) {
      this.estilo = estilo;
   }
}
