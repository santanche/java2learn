package pt.c02oo.s03relacionamento.s04restaum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Toolkit {
   public static String DIRETORIO = System.getProperty("user.dir") +
		                            "/src/pt/c02oo/s03relacionamento/s04restaum/";
   
   private static Toolkit tk;
   
   private BufferedReader inputStr;
   private PrintWriter outputStr;
   
   public static Toolkit start(String inputPath, String outputPath) {
      tk = new Toolkit();
      String inputFile = (inputPath == null)
            ? DIRETORIO + "commands.csv" : inputPath;
      String outputFile = (outputPath == null)
            ? DIRETORIO + "results.csv" : outputPath;
      System.out.println("files - input: " + inputFile +
                         "; output: " + outputFile);
      try {
         tk.inputStr = new BufferedReader(
               new FileReader(inputFile));
         tk.outputStr = new PrintWriter(
               new FileWriter(outputFile));
      } catch(IOException erro){
         erro.printStackTrace();
      }
      return tk;
   }
   
   public String[] retrieveCommands() {
      Vector<String> v = new Vector<String>();
      try {
         String line = inputStr.readLine();
         while (line != null) {
            v.add(line);
            line = inputStr.readLine();
         }
         inputStr.close();
      } catch (Exception erro) {
         erro.printStackTrace();
      }
      return (String[])v.toArray(new String[v.size()]);
   }
   
   public void writeBoard(String title, char board[][]){
      try {
         System.out.println("# " + title);
         outputStr.println("# " + title);
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               System.out.print(board[i][j]);
               outputStr.print(board[i][j]);
            }
            System.out.println();
            outputStr.println();
         }
      } catch(Exception erro){
         erro.printStackTrace();
      }
   }
   
   public void stop() {
      try {
         inputStr.close();
         outputStr.close();
      } catch(Exception erro){
         erro.printStackTrace();
      }
   }
}
