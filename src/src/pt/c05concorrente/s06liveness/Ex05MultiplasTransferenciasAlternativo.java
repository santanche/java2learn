package pt.c05concorrente.s06liveness;

public class Ex05MultiplasTransferenciasAlternativo
{

    static class ContaCorrente
    {
        private float saldo;
        
        public ContaCorrente(float saldo)
        {
            this.saldo = saldo;
        }
        
        public synchronized float getSaldo()
        {
            return saldo;
        }
        
        public synchronized void transfereValor(ContaCorrente destino, float valor)
        {
            saldo -= valor;

            // simula alguma operacao que leva 1 segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /* nada */
            }

            destino.recebeTransferencia(valor);
        }
        
        public synchronized void recebeTransferencia(float valor)
        {
            saldo += valor;
        }
    }
    
    static class Operador extends Thread
    {
        private String nomeOperador;
        
        private ContaCorrente origem,
                              destino;
        private float valor;
        
        public Operador(String nomeOperador,
                        ContaCorrente origem, ContaCorrente destino, float valor)
        {
            this.nomeOperador = nomeOperador;
            this.origem = origem;
            this.destino = destino;
            this.valor = valor;
        }
        
        public void run()
        {
            System.out.println(nomeOperador + " realizando da transferencia...");
            
            origem.transfereValor(destino, valor);

            System.out.println(nomeOperador + " realizou transferencia: " +
                               "origem " + origem.getSaldo() + "; " +
                               "destino " + destino.getSaldo());
        }
    }
    
    public static void main(String args[])
    {
        ContaCorrente contaA = new ContaCorrente(2000),
                      contaB = new ContaCorrente(1500);
        
        Operador operadorA = new Operador("Asdrubal", contaA, contaB, 300),
                 operadorB = new Operador("Quincas", contaB, contaA, 200);
        
        operadorA.start();
        operadorB.start();
    }
}
