package pt.c07bd.s02taxi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

public class AppConsoleSQL
{
    private static Connection conexao;
    
    public static void main(String args[])
    {
        Statement comando = conectaBanco();
        
        System.out.println("Digite 1 modificacao, 2 consulta: ");
        Scanner teclado = new Scanner(System.in);
        String opcao = teclado.nextLine();
        
        System.out.println("Comando (c) ou arquivo (a)");
        String ca = teclado.nextLine();
        
        System.out.println("Digite o SQL ou arquivo: ");
        String sql = teclado.nextLine();
        
        Vector<String> cjSql = null;
        if (ca.equalsIgnoreCase("a"))
            cjSql = arquivoString(sql);
        else {
            cjSql = new Vector<String>();
            cjSql.add(sql);
        }
        
        for (String umSql: cjSql) {
            try {
                if (opcao.equalsIgnoreCase("1")) {
                    comando.executeUpdate(umSql);
                    
                    System.out.println("Comando executado!");
                } else {
                    ResultSet resultado = comando.executeQuery(umSql);
                    
                    while (resultado.next()) {
                        int i = 1;
                        String coluna = resultado.getString(i);
                        while (coluna != null) {
                            System.out.print(coluna + "; ");
                            i++;
                            try {
                                coluna = resultado.getString(i);
                            } catch (Exception e) {
                                coluna = null;
                            }
                        }
                        System.out.println();    
                    }
                }
            } catch (SQLException erro) {
                System.out.println("Erro no SQL: " + erro.getMessage());
            }
        }
            
        try {
            comando.close();
            
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
        
    }
    
    public static Statement conectaBanco()
    {
        Statement comando = null;
        
        try {
            // carrega classe com implementacao para o driver
            //   neste caso o driver MySQL
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // estabelece conexao com a base de dados
            conexao = DriverManager.getConnection("jdbc:derby:db/derby/taxi;create=true", "", "");

            // cria um objeto de comandos SQL para a base
            comando = conexao.createStatement();
            
            System.out.println("Banco conectado.");
        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    
        return comando;
    }

    public static Vector<String> arquivoString(String nomeArquivo)
    {
        Vector<String> cjres = new Vector<String>();
        
        String resultado = "";
        
        // truque para pegar a referencia do arquivo no mesmo diretoria da classe
        String nomeTexto =
            AppConsoleSQL.class.getResource(nomeArquivo).getPath();
        
        try {
            FileReader arquivo = new FileReader(nomeTexto);
            BufferedReader entradaTexto = new BufferedReader(arquivo);
            
            String linha = entradaTexto.readLine();
            while (linha != null)
            {
                if (linha.endsWith(";")) {
                    resultado += linha.substring(0, linha.length() - 1);
                    cjres.add(resultado);
                } else
                    resultado += linha + " ";
                System.out.println(linha);
                linha = entradaTexto.readLine();
            }
            
            entradaTexto.close();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
        
        return cjres;
    }
    
}