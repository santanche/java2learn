package pt.c06patterns.builder.leitortexto.versao2;

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
    
    public void carregaArquivo() throws ErroLeituraArquivo
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
                throw new ErroLeituraArquivo("*** Erro na leitura do arquivo");
            }
            
            formatado.close();
        } catch (FileNotFoundException erro) {
            throw new ErroLeituraArquivo("*** Erro: Arquivo nao encontrado");
        } catch (IOException erro) {
            throw new ErroLeituraArquivo("*** Erro: Nao foi possivel fechar o arquivo");
        }
    }
}
