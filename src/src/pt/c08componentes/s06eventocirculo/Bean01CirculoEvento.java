package pt.c08componentes.s06eventocirculo;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;

public class Bean01CirculoEvento extends JComponent
{
    private static final long serialVersionUID = 5208633894344046115L;

    protected int raio = 50;

    private EventListenerList listaEscutas = new EventListenerList();

    public Bean01CirculoEvento()
    {
        super();
        setSize(100, 100);
    }

    public int getRaio()
    {
        return raio;
    }

    public void setRaio(int novoRaio)
    {
        if (novoRaio != raio) {
            raio = novoRaio;
            repaint();
            fireActionEvent();
        }
    }

    public void aumenta()
    {
        if (raio + 5 < getWidth() / 2)
            setRaio(raio + 5);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawOval(0, 0, raio * 2, raio * 2);
    }

    public void addActionListener(ActionListener al)
    {
        listaEscutas.add(ActionListener.class, al);
    }

    public void removeActionListener(ActionListener al)
    {
        listaEscutas.remove(ActionListener.class, al);
    }

    protected synchronized void fireActionEvent()
    {
        EventListener le[] = listaEscutas.getListeners(ActionListener.class);

        if (le != null) {
            ActionEvent evento = new
            ActionEvent(this, ActionEvent.ACTION_PERFORMED, "");

            for (int i = 0; i < le.length; i++)
                ((ActionListener)le[i]).actionPerformed(evento);
        }
    }
}
