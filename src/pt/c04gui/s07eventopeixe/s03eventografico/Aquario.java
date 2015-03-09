package pt.c04gui.s07eventopeixe.s03eventografico;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pt.c04gui.s07eventopeixe.s00metronomo.EscutaMetronomo;
import pt.c04gui.s07eventopeixe.s00metronomo.Metronomo;

public class Aquario extends JFrame implements EscutaMetronomo
{
    public static void main(String args[])
    {
    	new Aquario();
    }
	
    private Peixe peixin;
    private PeixeVisualTexto peixinTexto;
    private PeixeVisualImagem peixinImagem;
    
    public Aquario()
    {
    	super();
    	setSize(300, 300);
    	setVisible(true);
    	
    	peixin = new Peixe(0);
    	
    	peixinTexto = new PeixeVisualTexto();
    	peixin.addPeixeListener(peixinTexto);
    	
    	peixinImagem = new PeixeVisualImagem();
    	add(peixinImagem, BorderLayout.CENTER);
    	peixin.addPeixeListener(peixinImagem);
    	
    	peixin.setTamanho(1);
    	
    	new Metronomo(this, 1000);
    }
    
	public void batida()
	{
		System.out.println("alimentei...");
		peixin.alimenta();
	}
}
