package pt.c04gui.s07eventopeixe.s01basico;

public class Peixe implements PeixeInterface
{
    private int tamanho;
    private int comida = 0;
    
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
	}

	public void alimenta()
	{
		comida++;
		if (comida >= 3)
		{
			comida = 0;
			tamanho = (tamanho < 4) ? tamanho+1 : 4;
		}
	}

}
