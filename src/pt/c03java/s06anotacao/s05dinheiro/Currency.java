package pt.c03java.s06anotacao.s05dinheiro;

public enum Currency {
  DOLLAR("US$", "Dollar"),
  REAL("R$", "Real"),
  EURO("EU$", "Euro");
   
  private String sigla,
                 descricao;
  
  private Currency(String sigla, String descricao) {
     this.sigla = sigla;
     this.descricao = descricao;
  }
  
  public String getSigla() {
     return sigla;
  }
  
  public String getDescricao() {
     return descricao;
  }
}
