package pt.c04gui.s03botoes1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaBotoes extends JFrame {
    private static final long serialVersionUID = -3554620347134816488L;

    public JanelaBotoes() {
        super();
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JButton botao1 = new JButton("Esquerda");
        contentPane.add(botao1, BorderLayout.WEST);
        
        JButton botao2 = new JButton("Centro");
        contentPane.add(botao2, BorderLayout.CENTER);
        
        JButton botao3 = new JButton("Direita");
        contentPane.add(botao3, BorderLayout.EAST);
        
        setVisible(true);
    }
}
