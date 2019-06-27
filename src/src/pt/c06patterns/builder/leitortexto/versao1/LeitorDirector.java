package pt.c06patterns.builder.leitortexto.versao1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDirector
{
    private String nomeArquivo;
    private TextoAbstractBuilder montador;
    
    public LeitorDirector(String nomeArquivo, TextoAbstractBuilder montador)
    {
        this.nomeArquivo = nomeArquivo;
        this.montador = montador;
    }
    
    public void carregaArquivo()
    {
        try {
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader formatado =
                new BufferedReader(arquivo);

            try {
                String linha = formatado.readLine();
                
                while (linha != null) {
                    montador.insereLinha(linha);
                    linha = formatado.readLine();
                }
            } catch (IOException erro) {
                montador.insereLinha("*** Erro na leitura do arquivo");
            }
            
            formatado.close();
        } catch (FileNotFoundException erro) {
            montador.insereLinha("*** Erro: Arquivo nao encontrado");
        } catch (IOException erro) {
            montador.insereLinha("*** Erro: Nao foi possivel fechar o arquivo");
        }
    }
}
