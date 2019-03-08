package pt.c07bd.s01basico.s04central;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pt.c07bd.lib.Database;

public class App01ConsultaMarcadores
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
            Statement comando = conexao.createStatement();
            
            String stringComando = "SELECT * FROM Marcadores";
            
            System.out.println(stringComando);
            
            ResultSet resultado = comando.executeQuery(stringComando);

            while (resultado.next())
            {
                String titulo = resultado.getString("Titulo"),
                endereco = resultado.getString("Endereco");
                int acessos = resultado.getInt("Acessos");
                String categoria = resultado.getString("Categoria");
                System.out.println(titulo + "; " + endereco + "; " + acessos + "; " + categoria);
            }

            comando.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

}