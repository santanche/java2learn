package pt.c05concorrente.s08exercicios01.q03;

public class AppPilhaConcorrente
{
    public static final int QUANTIDADE = 1000;
    
    public static void main(String[] args)
    {
        PilhaConcorrente aPilha =new PilhaConcorrente(10);
        
        Thread oProdutor = new Produtor(aPilha, QUANTIDADE),
               oConsumidor = new Consumidor(aPilha, QUANTIDADE);
        
        oProdutor.start();
        oConsumidor.start();
    }

}
