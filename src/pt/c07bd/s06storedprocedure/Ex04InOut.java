package pt.c07bd.s06storedprocedure;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class Ex04InOut
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
     * Chama a seguinte stored procedure:
     *     DELIMITER |
     *     CREATE PROCEDURE incrementaAcessos2(
     *                          tituloMarcador VARCHAR(255),
     *                          OUT numeroAcessos INTEGER)
     *     BEGIN
     *         UPDATE Marcadores
     *                SET Acessos = Acessos + 1
     *                WHERE Titulo = tituloMarcador;
     *         SELECT Acessos INTO numeroAcessos
     *                FROM Marcadores
     *                WHERE Titulo = tituloMarcador;
     *     END |
     * @param dbConexao
     * @throws SQLException
     */
    public static void executaStoredProcedure(Connection dbConexao) throws SQLException
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o Titulo do marcador: ");
        String titulo = teclado.nextLine();

        CallableStatement comando = dbConexao.prepareCall("{ call incrementaAcessos2(?, ?) }");
        comando.setString(1, titulo);
        comando.registerOutParameter(2, Types.INTEGER);
        comando.execute();
        
        System.out.println("O numero de acessos atualizado de " + titulo +
                           " eh: " + comando.getInt(2));
        
        comando.close();
    }
}
