package pt.c04gui.s02janela;

import javax.swing.JFrame;

public class JanelaBasica extends JFrame
{
    private static final long serialVersionUID = -2292999201904896674L;

    public JanelaBasica()
    {
        super();
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
