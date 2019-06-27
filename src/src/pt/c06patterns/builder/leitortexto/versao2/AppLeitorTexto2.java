package pt.c06patterns.builder.leitortexto.versao2;

public class AppLeitorTexto2
{
    public static void main(String[] args)
    {
        JanelaTextoConcreteBuilder janela = new JanelaTextoConcreteBuilder();
        janela.setVisible(true);
        
        if (args.length >= 1) {
            LeitorDirector leitor =
                new LeitorDirector(args[0], janela);
            try {
                leitor.carregaArquivo();
            } catch (ErroLeituraArquivo erro) {
                janela.notificaErro(erro.getMessage());
            }
        } else
            janela.notificaErro(
                    "--- Informe o nome do arquivo na chamada do programa");
    }

}
