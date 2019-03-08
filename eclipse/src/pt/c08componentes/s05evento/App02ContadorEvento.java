package pt.c08componentes.s05evento;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App02ContadorEvento extends JFrame
{
    private static final long serialVersionUID = -3622209394312683452L;

    private static JFrame janela;
    
    public static void main(String[] args)
    {
        montaJanela();

        // instancia beans
        JButton botao = new JButton("Incrementa");
        Bean02ContadorEvento b04 = new Bean02ContadorEvento();

        botao.addActionListener(b04);

        janela.getContentPane().add(b04, BorderLayout.CENTER);
        janela.getContentPane().add(botao, BorderLayout.SOUTH);
        
        janela.setVisible(true);
    }

    private static void montaJanela()
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
