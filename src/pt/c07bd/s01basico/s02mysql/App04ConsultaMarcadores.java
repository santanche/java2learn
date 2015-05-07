package pt.c07bd.s01basico.s02mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App04ConsultaMarcadores
{
      public static void main(String argumentos[])
      {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(
                  "jdbc:mysql://localhost:3306/engsoft2015", "root", "thelab");

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

          conexao.close();

        } catch (ClassNotFoundException erro) {
          System.out.println(erro.getMessage());
        } catch (SQLException erro) {
          System.out.println("Erro no SQL: " + erro.getMessage());
        }
      }

}
