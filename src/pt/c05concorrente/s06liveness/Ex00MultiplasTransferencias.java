package pt.c05concorrente.s06liveness;

/**
 * Exemplo introdutorio sem paralelismo.
 * 
 * @author Andre Santanche
 *
 */
public class Ex00MultiplasTransferencias
{

    static class ContaCorrente
    {
        private String correntista;
        private float saldo;
        private boolean travado = false;
        
        public ContaCorrente(String correntista, float saldo)
        {
            this.correntista = correntista;
            this.saldo = saldo;
        }
        
        public String getCorrentista()
        {
            return correntista;
        }
        
        public synchronized float getSaldo()
        {
            return saldo;
        }

        public synchronized void atualiza(String nomeOperador, float valor)
        {
            while (travado)
            {
                System.out.print("Tentativa falha " + nomeOperador +
                                 " atualizar " + correntista + "; ");
                long mili = (long)(Math.random() * 100);
                System.out.println("esperando " + mili + " milisegundos...");
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            travado = true;
            saldo += valor;
        }
        
        public synchronized void commit()
        {
            travado = false;
        }
    }
    
    static class Operador extends Thread
    {
        private String nomeOperador;
        
        private ContaCorrente origem,
                              destino;
        private float valor;
        
        public Operador(String nomeOperador,
                        ContaCorrente origem, ContaCorrente destino,
                        float valor)
        {
            this.nomeOperador = nomeOperador;
            this.origem = origem;
            this.destino = destino;
            this.valor = valor;
        }
        
        public void run()
        {
            System.out.println(nomeOperador + " realizando transferencia (" +
                               origem.getCorrentista() + " para " +
                               destino.getCorrentista() + ") de " +
                               valor + "...");
            
            origem.atualiza(nomeOperador, -valor);
            
            // simula alguma operacao que leva 1 segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /* nada */
            }
            
            destino.atualiza(nomeOperador, valor);
            origem.commit();
            destino.commit();
            
            System.out.println(nomeOperador + " realizou transferencia: " +
                               "origem " + origem.getSaldo() + "; " +
                               "destino " + destino.getSaldo());
        }
    }
    
    public static void main(String args[])
    {
        ContaCorrente contaA = new ContaCorrente("Asdrubal", 2000),
                      contaB = new ContaCorrente("Quincas", 1500);
        
        System.out.println("Correntista " + contaA.getCorrentista() +
                           "; saldo: " + contaA.getSaldo());
        System.out.println("Correntista " + contaB.getCorrentista() +
                           "; saldo: " + contaB.getSaldo());
        
        Operador operadorA = new Operador("B1", contaA, contaB, 300);
        operadorA.start();
    }
}
