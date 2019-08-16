package pt.c07bd.s06storedprocedure;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pt.c07bd.lib.Database;

public class Ex01Select
{
    public static void main(String argumentos[])
    {

        try {
            Database.setPropertiesFile("taxi-mysql.properties");
            Database banco = Database.getInstance();
            Connection conexao = banco.getConnection();
            
            executaStoredProcedure(conexao);

            banco.releaseConnection();
        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (IOException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }
    
    /**
     * Chama Stored Procedure:
     *     CREATE PROCEDURE listaClientes()
     *         SELECT * FROM CLIENTE;
     *         
     * @param dbConexao conexao para um banco de dados
     * @throws SQLException
     */
    public static void executaStoredProcedure(Connection dbConexao) throws SQLException
    {
        CallableStatement comando = dbConexao.prepareCall("{ call listaClientes() }");
        comando.execute();
        ResultSet resultado = comando.getResultSet();
        
        while (resultado.next())
        {
            String cliid = resultado.getString("CliId"),
                   nome = resultado.getString("Nome"),
                   cpf = resultado.getString("CPF");
            System.out.println(cliid + "; " + nome + "; " + cpf);
        }
        
        comando.close();
    }
}
