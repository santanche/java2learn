package pt.c04gui.s07eventopeixe.s03eventografico;

import java.util.EventListener;

import javax.swing.event.EventListenerList;

public class Peixe implements PeixeInterface, PeixeSubject
{
    private int tamanho;
    private int comida = 0;
    
    private EventListenerList listaEscutas = new EventListenerList();

    public Peixe(int tamanho)
    {
    	this.tamanho = tamanho;
    }
	
	public int getTamanho()
	{
		return tamanho;
	}

	public void setTamanho(int tamanho)
	{
		this.tamanho = tamanho;
		firePeixeEvent();
	}

	public void alimenta()
	{
		comida++;
		if (comida >= 3)
		{
			comida = 0;
			setTamanho((tamanho < 4) ? tamanho+1 : 4);
		}
	}

	public void addPeixeListener(PeixeListener listener)
	{
		listaEscutas.add(PeixeListener.class, listener);
	}

	public void removePeixeListener(PeixeListener listener)
	{
		listaEscutas.remove(PeixeListener.class, listener);
	}
	
    protected synchronized void firePeixeEvent()
	{
	    EventListener le[] = listaEscutas.getListeners(PeixeListener.class);

	    if (le != null) {
	        for (int i = 0; i < le.length; i++)
	        	((PeixeListener)le[i]).novoTamanho(tamanho);
	    }
	}
}
