package pt.c03java.s07anotacao.s02anotacaocustomizada;

@AnotacaoClasse("Esta eh uma classe anotada")
public class ExemploAnotado
{
    @AnotacaoAtributo("Este eh um atributo anotado")
    private String exemploAtributoAnotado;
    
    @AnotacaoMetodo("Este eh um metodo anotado")
    public void exemploMetodoAnotado()
    {
        System.out.println("qualquer coisa" + exemploAtributoAnotado);
    }
}
