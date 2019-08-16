package pt.c07bd.s04prepared;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pt.c07bd.lib.Database;

public class App04InsercaoFixo
{

    public static void main(String args[])
    {
        try {
            Database bd = Database.getInstance();
            Connection dbConexao = bd.getConnection();

            insereMarcador(dbConexao);
            
            bd.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insereMarcador(Connection conexao)
    {
        try {
            String stringComando =
                "INSERT INTO Marcadores VALUES('Blender','http://www.blender.org',833,'CG')";
            
            Statement comando = conexao.createStatement();
            comando.executeUpdate(stringComando);
            comando.close();
            
            System.out.println("Insercao executada com sucesso!");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

}