package pt.c05concorrente.s04sincronizacao;

/**
 * Exemplo com threads paralelas que funcionam incorretamente;
 * tentativa falha de transferir synchronized para clientes
 * (MultiplasContagens) -- problema: synchronized aponta para
 * dois objetos distintos.
 * 
 * @author Andre Santanche
 *
 */
public class Ex04ContaCerta extends Thread
{
    public class Contador
    {
        private int valor = 0;
        
        public int getValor()
        {
            return valor;
        }
        
        public void atualiza(int quantidade)
        {
            int x = valor;

            try {
                Thread.sleep((long)(Math.random() * 2));
            } catch (InterruptedException e) {
                /* nada */
            }
            
            valor = x + quantidade;

            try {
                Thread.sleep((long)(Math.random() * 2));
            } catch (InterruptedException e) {
                // nada
            }
        }
    }
    
    public class MultiplasContagens extends Thread
    {
        private Contador umContador;
        private int quantidade;
        
        public MultiplasContagens(Contador umContador, int quantidade)
        {
            this.umContador = umContador;
            this.quantidade = quantidade;
        }
        
        public void run()
        {
            for (int i = 0; i < 10; i++)
                synchronized (this) {
                    umContador.atualiza(quantidade);
                }
        }
    }
    
    public void executaContagem()
    {
        Contador umContador = new Contador();
        
        System.out.print("antes: " + umContador.getValor() + "; ");
        
        MultiplasContagens mult1 = new MultiplasContagens(umContador, 1),
                           mult2 = new MultiplasContagens(umContador, -1);
        
        mult1.start();
        mult2.start();
        
        try {
            mult1.join();
            mult2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("depois: " + umContador.getValor());
    }
    
    public static void main(String args[])
    {
        Ex04ContaCerta contaCerta = new Ex04ContaCerta();
        
        for (int j = 0; j < 10; j++)
            contaCerta.executaContagem();
    }
}
