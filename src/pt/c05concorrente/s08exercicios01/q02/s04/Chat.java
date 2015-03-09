package pt.c05concorrente.s08exercicios01.q02.s04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chat extends Thread
{
    private String nome;  // nome de quem estah no chat
    private Chat outro;  // endereco do outro objeto chat
    
    private Servidor oServidor;  // servidor de mensagens
    
    private BufferedReader arquivo;
    
    public Chat(String nome, Servidor oServidor, String nomeArquivo)
    {
        this.nome = nome;
        this.oServidor = oServidor;
        
        arquivo = new BufferedReader(new InputStreamReader(
                          Chat.class.getResourceAsStream(nomeArquivo)));
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
        String linha = null;
        try {
            linha = arquivo.readLine();
        } catch (IOException e1) {
            /* nada */
        }
        while (linha != null)
        {
            oServidor.enviaMensagem(linha, this, outro);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                linha = arquivo.readLine();
            } catch (IOException e1) {
                /* nada */
            }
        }
    }
}
