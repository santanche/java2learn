package pt.c08componentes.s04sub;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App01SubComponente
{
    private static JFrame janela;
    
    public static void main(String[] args)
    {
        montaJanela();
        
        // instanciacao do bean
        Bean01SubComponente bs = new Bean01SubComponente();
        janela.getContentPane().add(bs, BorderLayout.CENTER);
        
        janela.setVisible(true);
    }

    private static void montaJanela()
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
