package pt.c04gui.s03campotexto1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JanelaTexto extends JFrame
{
    private static final long serialVersionUID = -3554620347134816488L;

    private JTextArea texto;
    
    public JanelaTexto()
    {
        super();
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        texto = new JTextArea();
        contentPane.add(texto, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void insereLina(String linha)
    {
        texto.append(linha + "\n");
    }
}
