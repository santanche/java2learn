package pt.c05concorrente.s06liveness;

public class Ex02MultiplasTransferencias
{

    static class ContaCorrente
    {
        private String correntista;
        private float saldo,
                      valor = 0;
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

        public synchronized boolean atualiza(String nomeOperador, float valor)
        {
            if (travado) {
                System.out.print("Tentativa falha " + nomeOperador +
                                 " atualizar " + correntista + "; ");
                return false;
            } else {
                travado = true;
                this.valor = valor;
                return true;
            }
        }
        
        public synchronized void commit()
        {
            saldo += valor;
            travado = false;
        }
        
        public synchronized void abort()
        {
            valor = 0;
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
                        ContaCorrente origem, ContaCorrente destino, float valor)
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
                               destino.getCorrentista() + ")...");
            
            boolean sucesso = false;
            while (!sucesso)
            {
                if (origem.atualiza(nomeOperador, -valor))
                {
                    // simula alguma operacao que leva 1 segundo
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        /* nada */
                    }
                    
                    if (destino.atualiza(nomeOperador, valor)) {
                        origem.commit();
                        destino.commit();
                        sucesso = true;
                    } else
                        origem.abort();
                }
                
                if (!sucesso) {
                    long mili = (long)(Math.random() * 100);
                    System.out.println("esperando " + mili +
                                       " milisegundos...");
                    try {
                        Thread.sleep(mili);
                    } catch (InterruptedException e) {
                        /* nada */
                    }
                }
            }
            
            System.out.println(nomeOperador + " realizou transferencia: " +
                               "origem " + origem.getSaldo() + "; " +
                               "destino " + destino.getSaldo());
        }
    }
    
    public static void main(String args[])
    {
        ContaCorrente contaA = new ContaCorrente("Asdrubal", 2000),
                      contaB = new ContaCorrente("Quincas", 1500);
        
        Operador operadorA = new Operador("B1", contaA, contaB, 300),
                 operadorB = new Operador("B2", contaB, contaA, 200);
        
        operadorA.start();
        operadorB.start();
    }
}
