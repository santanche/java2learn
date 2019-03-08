package pt.c07bd.s10oorelacional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "PESSOA")
@Access(AccessType.PROPERTY)
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TIPO_PESSOA", discriminatorType=DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Pessoa {
   private String nome;
   private String email;
   private char tipoPessoa;
   
   public Pessoa() {
	  super();
      this.tipoPessoa = 'P';
   }

   public Pessoa(String nome, String email) {
      super();
      this.nome = nome;
      this.email = email;
      this.tipoPessoa = 'P';
   }

   @Id
   @Column(name = "NOME", nullable = false, length=80)
   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   @Column(name = "EMAIL", length=50)
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Column(name = "TIPO_PESSOA")
   public char getTipoPessoa() {
      return tipoPessoa;
   }

   public void setTipoPessoa(char tipoPessoa) {
      this.tipoPessoa = tipoPessoa;
   }
}
