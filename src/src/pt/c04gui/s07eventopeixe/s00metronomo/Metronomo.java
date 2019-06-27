package pt.c04gui.s07eventopeixe.s00metronomo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Metronomo implements ActionListener
{
	EscutaMetronomo notificado;
    Timer metro;
    
    public Metronomo(EscutaMetronomo notificado, int intervalo)
    {
        this.notificado = notificado;
        metro = new Timer(intervalo, this);
        inicia();
    }
    
    public void inicia()
    {
        metro.start();
    }
    
    public void para()
    {
        metro.stop();
    }
    
    public void actionPerformed(ActionEvent evt)
    {
    	notificado.batida();
    }
}
