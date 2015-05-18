package pt.c06patterns.builder.leitortexto.versao2;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JanelaTextoConcreteBuilder extends JFrame
                                implements TextoAbstractBuilder
{
    private static final long serialVersionUID = -3453381116112163763L;

    private JTextArea areaTexto;
    private JTextField status;
    
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
        
        status = new JTextField();
        contentPane.add(status, BorderLayout.SOUTH);
    }
    
    public void insereLinha(String linha)
    {
        areaTexto.append(contador + ". " + linha + "\n");
        contador++;
    }
    
    public void notificaErro(String mensagemErro)
    {
        status.setText(mensagemErro);
    }
}
