package pt.c07bd.s01basico.s02mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App02InsereTaxonomia
{
    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblioteca", "root", "thelab");

            Statement comando = conexao.createStatement();

            // aciona metodo que executa comando SQL (este metodo e especialmente usado para atualizacao)
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Geral', '')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Serviços', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Acadêmico', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Relacionamento', 'Geral')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Busca', 'Serviços')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Portal', 'Serviços')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Mail', 'Serviços')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Vendas', 'Serviços')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Universidade', 'Acadêmico')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('CG', 'Acadêmico')");
            comando.executeUpdate("INSERT INTO Taxonomia VALUES ('Sociedade', 'Acadêmico')");

            comando.close();

            conexao.close();

            System.out.println("Dados inseridos com sucesso!");

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}
