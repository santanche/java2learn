package pt.c07bd.s10oorelacional;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "LIVRO")
@Access(AccessType.PROPERTY)
public class Livro {
  private String isbn;
  private String titulo;
  private List<Autor> autores;
  private int ano;
  private String categoria;

  public Livro() {
  }
  
  public Livro(String isbn, String titulo, List<Autor> autores, int ano, String categoria) {
    super();
    this.isbn = isbn;
    this.titulo = titulo;
    this.autores = autores;
    this.ano = ano;
    this.categoria = categoria;
  }
  
  @Id
  @Column(name = "ISBN", length=10)
  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Column(name = "TITULO", length=80)
  public String getTitulo() {
    return titulo;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  @ManyToMany(fetch=FetchType.EAGER)
	  @JoinTable(name="AUTOR_LIVRO",
	  joinColumns=
		  @JoinColumn(name="ISBN", referencedColumnName="ISBN"),
	  inverseJoinColumns=
          @JoinColumn(name="NOME", referencedColumnName="NOME")
  )
  public List<Autor> getAutores() {
    return autores;
  }

  public void setAutores(List<Autor> autores) {
    this.autores = autores;
  }

  public int getAno() {
    return ano;
  }

  @Column(name = "ANO")
  public void setAno(int ano) {
    this.ano = ano;
  }

  @Column(name = "CATEGORIA", length=50)
  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
