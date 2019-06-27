package pt.c07bd.s04prepared;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class App03ConsultaComPrepare
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
            
            PreparedStatement comando = conexao.prepareStatement(
                "SELECT * FROM Marcadores WHERE Titulo = ?");
            
            comando.setString(1, tituloSelecao);

            ResultSet resultado = comando.executeQuery();

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