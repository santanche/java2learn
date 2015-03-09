package pt.c07bd.s07transacao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import pt.c07bd.lib.Database;

public class App02ComTransacao
{
    public static void main(String args[])
    {
        try {
            App02ComTransacao aplicacao = new App02ComTransacao();
            
            aplicacao.listaCategorias();
            aplicacao.listaMarcadores();
            
            System.out.println(
               "Para produzir um erro e desfazer a transacao renomeie para outra categoria existente");
            Scanner teclado = new Scanner(System.in);
            System.out.print("Digite a categoria antiga: ");
            String antiga = teclado.nextLine();
            System.out.print("Digite a nova categoria: ");
            String nova = teclado.nextLine();
            System.out.println();
            System.out.println();
            
            aplicacao.renomeiaCategoria(antiga, nova);

            aplicacao.listaCategorias();
            aplicacao.listaMarcadores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    Database bd = null;
    Connection conexao = null;
    
    public App02ComTransacao() throws IOException, ClassNotFoundException, SQLException
    {
        bd = Database.getInstance();
        conexao = bd.getConnection();
    }
    
    public void finalize() throws Throwable
    {
        bd.releaseConnection();
    }
    
    public void listaCategorias() throws SQLException
    {
        System.out.println("Taxonomia");
        System.out.println("---------");
        
        Statement comando = conexao.createStatement();

        ResultSet resultado = comando.executeQuery("SELECT Categoria, Superior FROM Taxonomia");

        while (resultado.next())
        {
            String categoria = resultado.getString("Categoria"),
                   superior = resultado.getString("Superior");
            System.out.println(categoria + "; " + superior);
        }

        comando.close();
        System.out.println();
    }

    
    public void listaMarcadores() throws SQLException
    {
        System.out.println("Marcadores");
        System.out.println("----------");

        Statement comando = conexao.createStatement();

        ResultSet resultado = comando.executeQuery("SELECT Titulo, Endereco, Acessos, Categoria FROM Marcadores");

        while (resultado.next())
        {
            String titulo = resultado.getString("Titulo"),
            endereco = resultado.getString("Endereco");
            int acessos = resultado.getInt("Acessos");
            String categoria = resultado.getString("Categoria");
            System.out.println(titulo + "; " + endereco + "; " + acessos + "; " + categoria);
        }

        comando.close();
        System.out.println();
    }

    public void renomeiaCategoria(String antiga, String nova) throws SQLException
    {

        System.out.println("Renomeando categoria...");
        
        conexao.setAutoCommit(false);
        
        PreparedStatement comando1 = conexao.prepareStatement(
                "UPDATE Marcadores SET Categoria = ? WHERE Categoria = ?"); 
        PreparedStatement comando2 = conexao.prepareStatement(
                "UPDATE Taxonomia SET Categoria = ? WHERE Categoria = ?");
        PreparedStatement comando3 = conexao.prepareStatement(
                "UPDATE Taxonomia SET Superior = ? WHERE Superior = ?");

        comando1.setString(1, nova);
        comando2.setString(1, nova);
        comando3.setString(1, nova);
        comando1.setString(2, antiga);
        comando2.setString(2, antiga);
        comando3.setString(2, antiga);
        
        System.out.println("Atualizando Categoria na tabela Marcadores...");
        comando1.executeUpdate();
        System.out.println("Atualizando Categoria na tabela Taxonomia...");
        comando2.executeUpdate();
        System.out.println("Atualizando Superior na tabela Taxonomia...");
        comando3.executeUpdate();
        
        comando1.close();
        comando2.close();
        comando3.close();
        
        conexao.commit();
        
        conexao.setAutoCommit(true);
        
        System.out.println();
        System.out.println();
    }
}