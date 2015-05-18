package pt.c06patterns.builder.leitortexto.versao2;

public interface TextoAbstractBuilder
{
    public void insereLinha(String linha);
    public void notificaErro(String mensagemErro);
}
