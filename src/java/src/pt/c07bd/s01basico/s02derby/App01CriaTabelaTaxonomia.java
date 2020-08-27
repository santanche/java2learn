package pt.c07bd.s01basico.s02derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App01CriaTabelaTaxonomia
{
    public static void main(String args[])
    {
        try {
            // carrega classe com implementacao para o driver
            //   neste caso o driver MySQL
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // estabelece conexao com a base de dados
            Connection conexao = DriverManager.getConnection("jdbc:derby:db/derby/biblioteca;create=true", "", "");

            // cria um objeto de comandos SQL para a base
            Statement comando = conexao.createStatement();

            // aciona metodo que executa comando SQL (este metodo e especialmente usado para atualizacao)
            comando.executeUpdate(
                    "CREATE TABLE Taxonomia " +
                    "(Categoria VARCHAR(100) NOT NULL, Superior VARCHAR(100), " +
                    " PRIMARY KEY (Categoria))");

            // fecha comando
            comando.close();

            // fecha conexao
            conexao.close();

            System.out.println("Tabela criada com sucesso!");

        } catch (ClassNotFoundException erro) {
            System.out.println(erro.getMessage());
        } catch (SQLException erro) {
            System.out.println("Erro no SQL: " + erro.getMessage());
        }
    }

}