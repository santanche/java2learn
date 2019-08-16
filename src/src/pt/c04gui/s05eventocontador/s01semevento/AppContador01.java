package pt.c04gui.s05eventocontador.s01semevento;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppContador01
{
    private static JFrame janela;
    
    public static void main(String[] args)
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instanciacao do bean
        Contador vcont = new Contador();
        vcont.setContagem(5);
        janela.add(vcont, BorderLayout.CENTER);

        janela.setVisible(true);
    }
}
