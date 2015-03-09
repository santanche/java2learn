package pt.c07bd.lib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Gerencia a conexao com um banco de dados. Utiliza o pattern Singleton
 * para garantir que so sera feita uma instancia deste gerente e uma
 * conexao com o banco.
 */
public class Database
{
    /*
     * Secao Estatica
     * --------------
     * Gerencia a instanciacao de um unico banco usando o
     * padrao Singleton
     */

    /**
     * Nome do arquivo externo de propriedades 
     */
    public static final String DEFAULT_PROPERTIES = "Banco.properties";
    
    private static String propertiesFile = DEFAULT_PROPERTIES;
    
    public static String getPropertiesFile()
    {
        return propertiesFile;
    }
    
    /**
     * Altera o nome do arquivo de propriedades somente se nao houver instancia criada.
     * 
     * @param propertiesFile nome do arquivo de propriedades
     */
    public static void setPropertiesFile(String propertiesFile)
    {
        if (instance == null)
            Database.propertiesFile = propertiesFile;
    }
    
    // Mantem a instancia unica do banco 
    private static Database instance = null;
    
    /**
     * Metodo fabrica que retorna uma unica instancia do banco.
     * Este metodo cria uma unica vez a instancia se ainda nao foi
     * criada.
     * 
     * @return instancia (unica) do banco
     * @throws IOException erro ao tentar carregar o arquivo de propriedades
     * @throws ClassNotFoundException biblioteca do driver do bd nao encontrada
     */
    public static Database getInstance() throws IOException, ClassNotFoundException
    {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    /*
     * Secao do Objeto
     * ---------------
     */
    
    // Propriedades do bd carregadas de arquivo externo
    private Properties dbProperties = null;
    
    // Mantem a conexao unica com o banco 
    private Connection dbConnection = null;
    
    // Controla o numero de clientes que usam a conexao 
    private int clients = 0;

    // Construtor privado, conforme o pattern Singleton
    private Database() throws IOException, ClassNotFoundException
    {
        dbProperties = new Properties();

        // carrega as propriedades dependentes de um bd especifico
        dbProperties.load(Database.class.getResourceAsStream(propertiesFile));
        String dbDriver = dbProperties.getProperty("db.driver");

        Class.forName(dbDriver);
    }
    
    /**
     * Abre (quando necessaria) uma conexao com o banco e a retorna para o cliente.
     * Mantem uma unica conexao com o bd que eh entregue para todos os clientes, 
     * e controla o numero de clientes ativos para a mesma.
     * 
     * @return conexao com o bd
     * @throws SQLException problemas ao tentar estabelecer a conexao com o bd
     */
    public Connection getConnection() throws SQLException
    {
        if (dbConnection == null)
        {
            String dbUrl = dbProperties.getProperty("db.url"),
                   dbUser = dbProperties.getProperty("db.user"),
                   dbPassword = dbProperties.getProperty("db.password");
            
            if (dbUser.length() != 0) {
                // para acesso com usuario e senha
                dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            } else {
                // para acesso sem usuario e senha
                dbConnection = DriverManager.getConnection(dbUrl);
            }
        }

        clients++;
        return dbConnection;
    }

    /**
     * Cliente notifica atraves deste metodo que nao ira utilizar mais a conexao.
     * Quando todos os clientes liberarem a conexao ela eh automaticamente encerrada.
     * 
     * @throws SQLException problemas ao tentar encerrar a conexao com o bd
     */
    public void releaseConnection() throws SQLException
    {
        clients--;
        
        if (clients <= 0) {
            dbConnection.close();
            dbConnection = null;
        }
    }
}