package pt.c04gui.s05eventocontador.s02comevento;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AppContador02 extends JFrame
{
    private static final long serialVersionUID = -3622209394312683452L;

    private static JFrame janela;
    
    public static void main(String[] args)
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instancia beans
        JButton botao = new JButton("Incrementa");
        ContadorEvento vcont = new ContadorEvento();

        botao.addActionListener(vcont);

        janela.getContentPane().add(vcont, BorderLayout.CENTER);
        janela.getContentPane().add(botao, BorderLayout.SOUTH);
        
        janela.setVisible(true);
    }

}
