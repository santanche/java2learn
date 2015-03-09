package pt.c05concorrente.s08exercicios01.q02.s03;

public class Chat extends Thread
{
    private String nome;  // nome de quem estah no chat
    private Chat outro;  // endereco do outro objeto chat
    
    private Servidor oServidor;  // servidor de mensagenss
    
    public Chat(String nome, Servidor oServidor)
    {
        this.nome = nome;
        this.oServidor = oServidor;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public Chat getOutro()
    {
        return outro;
    }
    
    public void setOutro(Chat outro)
    {
        this.outro = outro;
    }
    
    public void recebeMensagem(String mensagem, Chat origem)
    {
        System.out.println("[" + origem.getNome() + "]: " + mensagem);
    }
    
    public void run()
    {
        while (true)
        {
            oServidor.enviaMensagem("bla bla bla...", this, outro);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /* nada */
            }
        }
    }
}
