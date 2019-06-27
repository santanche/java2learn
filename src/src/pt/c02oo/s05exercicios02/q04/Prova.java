package pt.c02oo.s05exercicios02.q04;

public class Prova
{
    private Gabarito oGabarito;
    private char respostas[];
    private int corrente;
    
    public Prova(Gabarito oGabarito)
    {
        this.oGabarito = oGabarito;
        respostas = new char[15];
        corrente = 0;
    }
    
    public void respostaAluno(char umaResposta)
    {
        if (corrente < 15) {
            respostas[corrente] = umaResposta;
            corrente++;
        }
    }
    
    public int acertos()
    {
        int na = 0;
        for (int q = 0; q < corrente; q++)
            if (respostas[q] == oGabarito.respostaQuestao(q))
                na++;
        return na;
    }
    
    public float nota()
    {
        float nt = 0;
        for (int q = 0; q < corrente; q++)
            if (respostas[q] == oGabarito.respostaQuestao(q)) {
                if (q < 10)
                    nt += 0.5;
                else
                    nt += 1;
            }
        return nt;
    }
    
    public float maior(Prova outro)
    {
        int aMeu = acertos(),
            aOutro = outro.acertos();
        float nMinha = nota(),
              nOutro = outro.nota();
        
        float m = nMinha;
        
        if (aMeu < aOutro)
            m = nOutro;
        else if (aMeu == aOutro) {
            if (nMinha < nOutro)
                m = nOutro;
        }
        
        return m;
    }
}
