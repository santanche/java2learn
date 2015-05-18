package pt.c06patterns.factory.s08zebatata.produto;

import javax.swing.JComponent;

public interface Olho
{
    public JComponent getVisual();
    public void abrir();
    public void fechar();
    public void piscar();
    public void paraEsquerda();
    public void paraDireita();
}
