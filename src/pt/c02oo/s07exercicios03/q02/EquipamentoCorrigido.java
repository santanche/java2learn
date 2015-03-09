package pt.c02oo.s07exercicios03.q02;

public class EquipamentoCorrigido extends Equipamento
{
	private int mesCorrente;
    private int mesCompra[];
    
    public EquipamentoCorrigido(int numeroEquipamentos, int mesCorrente)
    {
    	super(numeroEquipamentos);
    	this.mesCorrente = mesCorrente;
    	mesCompra = new int[numeroEquipamentos];
    }
    
    public int getMesCompra(int numeroEquipamento)
    {
    	int mc = 0;
    	
    	if (numeroEquipamento >= 0 &&
    	    numeroEquipamento < getNumeroEquipamentos())
    		mc = mesCompra[numeroEquipamento];
    	
    	return mc;
    }
    
    public void setMesCompra(int numeroEquipamento, int mesCompra)
    {
    	if (numeroEquipamento >= 0 &&
    		numeroEquipamento < getNumeroEquipamentos() &&
    		mesCompra >= 1 && mesCompra <= 12)
    		this.mesCompra[numeroEquipamento] = mesCompra;
    }
    
    public void corrige(int percentual)
    {
    	for (int i = 0; i < getNumeroEquipamentos(); i++)
    		if (mesCompra[i] == mesCorrente)
    			setValor(i, getValor(i) * (percentual / 100 + 1));
    	mesCorrente = mesCorrente % 12 + 1;
    }
    
    public void substitui(EquipamentoCorrigido outro)
    {
    	if (outro.getNumeroEquipamentos() == getNumeroEquipamentos())
    		for (int i = 0; i < getNumeroEquipamentos(); i++) {
    			setValor(i, outro.getValor(i));
    			setMesCompra(i, outro.getMesCompra(i));
    		}
    }
}
