package pt.c40task.l05wumpus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Toolkit {
   public static String DIRETORIO = System.getProperty("user.dir") +
		                            "/src/pt/c40task/l05wumpus/";
   
   private static Toolkit tk;
   
   private BufferedReader inputStr;
   private PrintWriter outputStr;
   
   public static Toolkit start(String inputPath, String outputPath) {
      tk = new Toolkit();
      String inputFile = (inputPath == null)
            ? DIRETORIO + "cave.csv" : inputPath;
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
   
   public String[][] retrieveCave() {
      Vector<String[]> v = new Vector<String[]>();
      try {
         String line = inputStr.readLine();
         while (line != null) {
            String ln[]  = line.split(",");
            v.add(ln);
            line = inputStr.readLine();
         }
         inputStr.close();
      } catch (Exception erro) {
         erro.printStackTrace();
      }
      return (String[][])v.toArray(new String[v.size()][]);
   }
   
   public void writeBoard(char board[][], int score, char status){
      try {
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               System.out.print(board[i][j]);
               outputStr.print(board[i][j]);
            }
            System.out.println();
            outputStr.println();
         }
         System.out.println("score: " + score);
         outputStr.println("score: " + score);
         System.out.println("status: " + status);
         outputStr.println("status: " + status);
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
