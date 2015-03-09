package pt.c07bd.s04prepared;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class App06InsercaoComPrepare
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
            
            PreparedStatement comando = conexao.prepareStatement(
                    "INSERT INTO Marcadores VALUES (?, ?, ?, ?)");

            comando.setString(1, titulo);
            comando.setString(2, endereco);
            comando.setInt(3, acessos);
            comando.setString(4, categoria);
            
            comando.executeUpdate();
            comando.close();
            
            System.out.println("Insercao executada com sucesso!");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

}