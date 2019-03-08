package pt.c08componentes.s03responsivo;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Bean01Responsivo extends JComponent
{
    private static final long serialVersionUID = 8808427093677451608L;

    // proporcao inicial
    private int proporcao = 80;
    
    public Bean01Responsivo()
    {
        super();
        setSize(100, 100);
    }
    
    public int getProporcao()
    {
        return proporcao;
    }
    
    public void setProporcao(int proporcao)
    {
        if (proporcao >= 1 && proporcao <= 100)
            this.proporcao = proporcao;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        int deslHorizontal = ((getWidth() *(100-proporcao))/100),
            deslVertical   = ((getHeight()*(100-proporcao))/100);       
        
        g.drawOval(deslHorizontal/2, deslVertical/2,
                   getWidth() - deslHorizontal,
                   getHeight() - deslVertical);
    }
}
