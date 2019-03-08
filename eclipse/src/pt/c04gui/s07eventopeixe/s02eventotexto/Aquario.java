package pt.c04gui.s07eventopeixe.s02eventotexto;

import java.util.Scanner;

import pt.c04gui.s07eventopeixe.s00metronomo.EscutaMetronomo;
import pt.c04gui.s07eventopeixe.s00metronomo.Metronomo;

public class Aquario implements EscutaMetronomo
{
    public static void main(String args[])
    {
    	new Aquario();
    }
	
    private Peixe peixin;
    private PeixeListener peixinTexto;
    
    public Aquario()
    {
    	peixin = new Peixe(0);
    	peixinTexto = new PeixeVisualTexto();
    	peixin.addPeixeListener(peixinTexto);
    	peixin.setTamanho(1);
    	
    	new Metronomo(this, 1000);
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
    }
    
	public void batida()
	{
		System.out.println("alimentei...");
		peixin.alimenta();
	}
}
