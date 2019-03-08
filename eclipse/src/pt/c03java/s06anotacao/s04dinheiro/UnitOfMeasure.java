package pt.c03java.s06anotacao.s04dinheiro;

public @interface UnitOfMeasure {
    public Currency moeda();
    public String sigla();
    public String descricao();
}
