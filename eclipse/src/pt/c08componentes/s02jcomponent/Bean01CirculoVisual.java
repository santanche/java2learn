package pt.c08componentes.s02jcomponent;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Bean01CirculoVisual extends JComponent {
    private static final long serialVersionUID = 8097750276575456647L;

    private int raio = 50;

    public Bean01CirculoVisual() {
        super();
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(10, 10, raio*2, raio*2);
    }
}
