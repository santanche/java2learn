package pt.c07bd.s04prepared;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class App02ConsultaConcatenando
{

    public static void main(String args[])
    {
        try {
            Database bd = Database.getInstance();
        
            Connection dbConexao = bd.getConnection();

            executaConsulta(dbConexao);
            
            bd.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void executaConsulta(Connection conexao)
    {

        try {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Digite o titulo: ");
            String tituloSelecao = teclado.nextLine();
            
            Statement comando = conexao.createStatement();
            
            String stringComando =
                "SELECT * FROM Marcadores WHERE Titulo = '" +
                tituloSelecao + "'";
            
            System.out.println(stringComando);

            ResultSet resultado = comando.executeQuery(
                    stringComando);
            

            boolean temConteudo = resultado.next();
            while (temConteudo)
            {
                String titulo = resultado.getString("Titulo"),
                endereco = resultado.getString("Endereco");
                int acessos = resultado.getInt("Acessos");
                String categoria = resultado.getString("Categoria");
                System.out.println(titulo + "; " + endereco + "; " + acessos + "; " + categoria);
                temConteudo = resultado.next();
            }

            comando.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

}