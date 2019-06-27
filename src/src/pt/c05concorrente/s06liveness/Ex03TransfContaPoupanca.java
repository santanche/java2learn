package pt.c05concorrente.s06liveness;

public class Ex03TransfContaPoupanca
{

    static class ContaCliente
    {
        private float saldoCC,
                      saldoPoupanca;
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

        public synchronized void atualizaCC(String nomeOperador, float valor)
        {
            while (travadoCC) {
                System.out.println("Tentativa falha " + nomeOperador + " atualizar conta corrente; esperando...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            travadoCC = true;
            saldoCC += valor;
        }
        
        public synchronized void atualizaPoupanca(String nomeOperador, float valor)
        {
            while (travadoPoupanca) {
                System.out.println("Tentativa falha " + nomeOperador + " atualizar poupanca; esperando...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            travadoPoupanca = true;
            saldoPoupanca += valor;
        }
        
        public synchronized void commit()
        {
            travadoCC = false;
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
            
            if (contaParaPoupanca)
                conta.atualizaCC(nomeOperador, -valor);
            else
                conta.atualizaPoupanca(nomeOperador, -valor);
            
            // simula alguma operacao que leva 1 segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /* nada */
            }
            
            if (contaParaPoupanca)
                conta.atualizaPoupanca(nomeOperador, valor);
            else
                conta.atualizaCC(nomeOperador, valor);

            conta.commit();
            
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
