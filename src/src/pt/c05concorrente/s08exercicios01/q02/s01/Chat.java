package pt.c05concorrente.s08exercicios01.q02.s01;

public class Chat extends Thread
{
    private String nome;  // nome de quem estah no chat
    private Chat outro;  // endereco do outro objeto chat
    
    public Chat(String nome)
    {
        this.nome = nome;
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
            outro.recebeMensagem("bla bla bla...", this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
