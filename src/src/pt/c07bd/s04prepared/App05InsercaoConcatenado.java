package pt.c07bd.s04prepared;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class App05InsercaoConcatenado
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
            Scanner teclado = new Scanner(System.in);
            System.out.print("Digite o Titulo: ");
            String titulo = teclado.nextLine();
            System.out.print("Digite o Endereco: ");
            String endereco = teclado.nextLine();
            System.out.print("Digite o Acessos: ");
            int acessos = Integer.parseInt(teclado.nextLine());
            System.out.print("Digite o Categoria: ");
            String categoria = teclado.nextLine();
            
            String stringComando =
                "INSERT INTO Marcadores VALUES('" + titulo + "','" +
                endereco + "'," + acessos + ",'" + categoria + "')";
            
            System.out.println("Comando SQL:");
            System.out.println(stringComando);

            Statement comando = conexao.createStatement();
            comando.executeUpdate(stringComando);
            comando.close();
            
            System.out.println("Insercao executada com sucesso!");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

}