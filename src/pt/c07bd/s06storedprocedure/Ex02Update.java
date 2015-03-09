package pt.c07bd.s06storedprocedure;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class Ex02Update
{
    public static void main(String argumentos[])
    {

        try {
            Database.setPropertiesFile("sala-mysql.properties");
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
     *     CREATE PROCEDURE  incrementaAcessos(tituloMarcador VARCHAR(255))
     *         UPDATE Marcadores
     *                SET Acessos = Acessos + 1
     *                WHERE Titulo = tituloMarcador
     */
    public static void executaStoredProcedure(Connection dbConexao) throws SQLException
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o Titulo do marcador que sera incrementado: ");
        String titulo = teclado.nextLine();

        CallableStatement comando = dbConexao.prepareCall("{ call incrementaAcessos(?) }");
        comando.setString(1, titulo);
        comando.execute();
        
        System.out.println(titulo + " incrementado com sucesso.");
        
        comando.close();
    }
}
