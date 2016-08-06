package pt.c08componentes.s02jcomponent;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App01CirculoVisual {
    private static JFrame janela;
    
    public static void main(String[] args)
    {
        janela = new JFrame("Teste do Bean");
        janela.setSize(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // instanciacao do bean
        Bean01CirculoVisual b01 = new Bean01CirculoVisual();
        b01.setRaio(70);
        janela.getContentPane().add(b01, BorderLayout.CENTER);

        janela.setVisible(true);
    }
}