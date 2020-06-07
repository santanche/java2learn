package pt.c04gui.s04botoes2;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JanelaBotoes extends JFrame {
   private static final long serialVersionUID = 1568786912786472224L;

   public JanelaBotoes() {
        super();
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        JButton botao1 = new JButton("Primeiro");
        contentPane.add(botao1);
        
        JButton botao2 = new JButton("Segundo");
        contentPane.add(botao2);
        
        JButton botao3 = new JButton("Terceiro");
        contentPane.add(botao3);
        
        setVisible(true);
    }
}
