package pt.c06patterns.builder.sax;

public class SAXPrincipal
{
    public static void main(String[] args)
    {
        String nomeArquivo = SAXPrincipal.class.getResource("dados.xml").getPath();

        if (nomeArquivo != null) {
            SAXBasico sb = new SAXBasico();
            sb.inicia(nomeArquivo);
        }
    }
}
