package pt.c08componentes.s05evento;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App01Contador
{
    private static JFrame janela;
    
    public static void main(String[] args)
    {
        montaJanela();

        // instanciacao do bean
        Bean01Contador b04 = new Bean01Contador();
        b04.setContagem(5);
        janela.add(b04, BorderLayout.CENTER);

        janela.setVisible(true);
    }

    private static void montaJanela()
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
