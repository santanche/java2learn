package pt.c04gui.s04campotexto2;

public class AppGui04
{
    public static void main(String[] args)
    {
        JanelaTexto janela = new JanelaTexto();
        janela.setVisible(true);
        
        janela.insereLinha("Asdrubal");
        janela.insereLinha("Quincas");
        janela.insereLinha("Doriana");
    }

}
