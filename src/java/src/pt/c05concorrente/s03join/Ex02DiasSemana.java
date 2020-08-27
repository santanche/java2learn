package pt.c05concorrente.s03join;


public class Ex02DiasSemana
{
    class DiasTrabalho extends Thread
    {
        private String dia[] =
            {"segunda", "terca", "quarta", "quinta", "sexta" };
        
        public void run()
        {
            for (int d = 0; d <= 4; d++)
            {
                System.out.println(dia[d]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            
        }

    }
    
    class FimSemana extends Thread
    {
        private String dia[] = {"sabado", "domingo"};
        
        private DiasTrabalho trabalho;
        
        public FimSemana(DiasTrabalho trabalho)
        {
            this.trabalho = trabalho;
        }
        
        public void run()
        {
            try {
                trabalho.join(10000);
            } catch (InterruptedException e1) {
                /* nada */
            }
            
            for (int d = 0; d <= 1; d++)
            {
                System.out.println(dia[d]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    /* nada */
                }
            }
            
        }

    }
    
    public Ex02DiasSemana()
    {
        DiasTrabalho trabalho = new DiasTrabalho();
        FimSemana fimsemana = new FimSemana(trabalho);
        
        trabalho.start();
        fimsemana.start();
    }
    
    public static void main(String args[])
    {
        new Ex02DiasSemana();
    }
}
