package pt.c07bd.s06storedprocedure;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class Ex03Function
{
    public static void main(String argumentos[])
    {

        try {
            Database.setPropertiesFile("sala-mysql.properties");
            Database banco = Database.getInstance();
            Connection conexao = banco.getConnection();
            
            executaStoredFunction(conexao);

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
     * Chama a seguinte stored procedure:
     *     DELIMITER |
     *     CREATE FUNCTION numeroAcessos(
     *                         tituloMarcador VARCHAR(255)) RETURNS INT(11)
     *     BEGIN
     *         DECLARE numero INTEGER;
     *         SELECT Acessos INTO numero FROM Marcadores
     *                WHERE Titulo = tituloMarcador;
     *         RETURN numero;
     *     END |
     * 
     * @param dbConexao
     * @throws SQLException
     */
     public static void executaStoredFunction(Connection dbConexao) throws SQLException
     {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o Titulo do marcador: ");
        String titulo = teclado.nextLine();

        CallableStatement comando = dbConexao.prepareCall("{ ? = call numeroAcessos(?) }");
        comando.registerOutParameter(1, Types.INTEGER);
        comando.setString(2, titulo);
        comando.execute();
        
        System.out.println("O numero de acessos de " + titulo + " eh: " + comando.getInt(1));
        
        comando.close();
    }
}
