package pt.c07bd.s10oorelacional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App12ListaRelacionalMarcador
{
      public static void main(String argumentos[])
      {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:hsqldb:file:db/hsqldb/biblioteca-oo;shutdown=true", "SA", "");

          Statement comando = conexao.createStatement();

          String stringComando = "SELECT * FROM Marcador";
            
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

          conexao.close();

        } catch (ClassNotFoundException erro) {
          System.out.println(erro.getMessage());
        } catch (SQLException erro) {
          System.out.println("Erro no SQL: " + erro.getMessage());
        }
      }

}
