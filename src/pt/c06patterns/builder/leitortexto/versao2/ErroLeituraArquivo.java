package pt.c06patterns.builder.leitortexto.versao2;

public class ErroLeituraArquivo extends Exception
{
    private static final long serialVersionUID = 8877199522404193120L;
    
    public ErroLeituraArquivo()
    {
        super();
    }
    
    public ErroLeituraArquivo(String mensagem)
    {
        super(mensagem);
    }
}
