package pt.c05concorrente.s06liveness;

public class Ex04TransfContaPoupanca
{

    static class ContaCliente
    {
        private float saldoCC,
                      saldoPoupanca;
        private float valorCC = 0,
                      valorPoupanca = 0;
        private boolean travadoCC = false,
                        travadoPoupanca = false;
        
        public ContaCliente(float saldoCC, float saldoPoupanca)
        {
            this.saldoCC = saldoCC;
            this.saldoPoupanca = saldoPoupanca;
        }
        
        public synchronized float getSaldoCC()
        {
            return saldoCC;
        }

        public synchronized float getSaldoPoupanca()
        {
            return saldoPoupanca;
        }

        
        public synchronized void esperaTravas(String nomeOperador)
        {
            while (travadoCC || travadoPoupanca)
            {
                System.out.println(nomeOperador + " esperando...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
        }
        
        public synchronized boolean atualizaCC(String nomeOperador, float valor)
        {
            if (travadoCC) {
                System.out.println("Tentativa falha " + nomeOperador + " atualizar conta corrente");
                return false;
            } else {
                travadoCC = true;
                valorCC = valor;
                return true;
            }
        }
        
        public synchronized boolean atualizaPoupanca(String nomeOperador, float valor)
        {
            if (travadoPoupanca) {
                System.out.println("Tentativa falha " + nomeOperador + " atualizar poupanca");
                return false;
            } else {
                travadoPoupanca = true;
                valorPoupanca = valor;
                return true;
            }
        }
        
        public synchronized void commitCC()
        {
            saldoCC += valorCC;
            travadoCC = false;
            notifyAll();
        }
        
        public synchronized void commitPoupanca()
        {
            saldoPoupanca += valorPoupanca;
            travadoPoupanca = false;
            notifyAll();
        }

        public synchronized void abortCC()
        {
            valorCC = 0;
            travadoCC = false;
            notifyAll();
        }

        public synchronized void abortPoupanca()
        {
            valorPoupanca = 0;
            travadoPoupanca = false;
            notifyAll();
        }
    }
    
    static class Operador extends Thread
    {
        private String nomeOperador;
        
        private ContaCliente conta;
        
        private boolean contaParaPoupanca;
        
        private float valor;
        
        public Operador(String nomeOperador, ContaCliente conta, boolean contaParaPoupanca, float valor)
        {
            this.nomeOperador = nomeOperador;
            this.conta = conta;
            this.contaParaPoupanca = contaParaPoupanca;
            this.valor = valor;
        }
        
        public void run()
        {
            System.out.println(nomeOperador + " realizando transferencia " +
                               ((contaParaPoupanca) ? "conta para poupanca" : "poupanca para conta") +
                               "...");
            
            boolean sucesso = false;
            while (!sucesso)
            {
                boolean sucessoParcial;
                if (contaParaPoupanca)
                    sucessoParcial = conta.atualizaCC(nomeOperador, - valor);
                else
                    sucessoParcial = conta.atualizaPoupanca(nomeOperador, -valor);

                if (sucessoParcial)
                {
                    // simula alguma operacao que leva 1 segundo
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        /* nada */
                    }
                    
                    if (contaParaPoupanca)
                        sucesso = conta.atualizaPoupanca(nomeOperador, valor);
                    else
                        sucesso = conta.atualizaCC(nomeOperador, valor);

                    if (sucesso) {
                        conta.commitCC();
                        conta.commitPoupanca();
                    } else
                        if (contaParaPoupanca)
                            conta.abortCC();
                        else
                            conta.abortPoupanca();
                }
                
                if (!sucesso)
                    conta.esperaTravas(nomeOperador);
           }
            
           System.out.println(nomeOperador + " realizou transferencia: " +
                              "conta corrente " + conta.getSaldoCC() + "; " +
                              "poupanca " + conta.getSaldoPoupanca());
        }
    }
    
    public static void main(String args[])
    {
        ContaCliente conta = new ContaCliente(2000, 400);
        
        Operador operadorA = new Operador("B1", conta, true, 300),
                 operadorB = new Operador("B2", conta, false, 200);
        
        operadorA.start();
        operadorB.start();
    }
}
