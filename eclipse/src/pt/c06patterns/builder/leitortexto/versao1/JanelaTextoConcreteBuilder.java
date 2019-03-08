package pt.c06patterns.builder.leitortexto.versao1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JanelaTextoConcreteBuilder extends JFrame
                                implements TextoAbstractBuilder
{
    private static final long serialVersionUID = -3453381116112163763L;

    private JTextArea areaTexto;
    
    private int contador = 1;
    
    public JanelaTextoConcreteBuilder()
    {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        visual();
    }
    
    public void visual()
    {
        setSize(300, 200);
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        areaTexto = new JTextArea();
        contentPane.add(areaTexto, BorderLayout.CENTER);
    }
    
    public void insereLinha(String linha)
    {
        areaTexto.append(contador + ". " + linha + "\n");
        contador++;
    }
}
