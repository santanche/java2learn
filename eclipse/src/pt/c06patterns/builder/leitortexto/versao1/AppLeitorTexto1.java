package pt.c06patterns.builder.leitortexto.versao1;

public class AppLeitorTexto1
{
    public static void main(String[] args)
    {
        JanelaTextoConcreteBuilder janela = new JanelaTextoConcreteBuilder();
        janela.setVisible(true);
        
        if (args.length >= 1) {
            LeitorDirector leitor =
                new LeitorDirector(args[0], janela);
            leitor.carregaArquivo();
        } else
            janela.insereLinha(
                    "--- Informe o nome do arquivo na chamada do programa");
    }

}
