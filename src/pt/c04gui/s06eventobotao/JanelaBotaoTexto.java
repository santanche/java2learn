package pt.c04gui.s06eventobotao;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JanelaBotaoTexto extends JFrame
{
    private static final long serialVersionUID = -3554620347134816488L;

    private JTextArea texto;
    private JButton botao;
    
    public JanelaBotaoTexto()
    {
        super();
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        texto = new JTextArea();
        contentPane.add(texto, BorderLayout.CENTER);
        
        botao = new JButton("Inicia");
        contentPane.add(botao, BorderLayout.SOUTH);
        botao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                disparaBotao();
            }
        });
        
        
        setVisible(true);
    }
    
    public void insereLina(String linha)
    {
        texto.append(linha + "\n");
    }
    
    public void disparaBotao()
    {
        insereLina("Tum tum");
        insereLina("Quem eh?");
        insereLina("Sou eu");
    }
}
