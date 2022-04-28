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
   
   private BufferedReader moveStr, caveStr;
   private PrintWriter outputStr;
   
   private boolean firstBoard = true;
   
   public static Toolkit start(String cavePath, String outputPath,
                               String movePath) {
      tk = new Toolkit();
      String caveFile = (cavePath == null)
            ? DIRETORIO + "cave.csv" : cavePath;
      String outputFile = (outputPath == null)
            ? DIRETORIO + "results.csv" : outputPath;
      String moveFile = (movePath == null)
            ? DIRETORIO + "movements.csv" : movePath;
      System.out.println("files - cave: " + caveFile +
                         "; output: " + outputFile +
                         "; movements: " + moveFile);
      try {
         tk.caveStr = new BufferedReader(
               new FileReader(caveFile));
         tk.outputStr = new PrintWriter(
               new FileWriter(outputFile));
         tk.moveStr = new BufferedReader(
               new FileReader(moveFile));
      } catch(IOException erro){
         erro.printStackTrace();
      }
      return tk;
   }
   
   public String[][] retrieveCave() {
      Vector<String[]> v = new Vector<String[]>();
      try {
         String line = caveStr.readLine();
         while (line != null) {
            String ln[]  = line.split(",");
            v.add(ln);
            line = caveStr.readLine();
         }
         caveStr.close();
      } catch (Exception erro) {
         erro.printStackTrace();
      }
      return (String[][])v.toArray(new String[v.size()][]);
   }
   
   public String retrieveMovements() {
      String v = "";
      try {
         String line = moveStr.readLine();
         while (line != null) {
            v += line;
            line = moveStr.readLine();
         }
         moveStr.close();
      } catch (Exception erro) {
         erro.printStackTrace();
      }
      return v;
   }
   
   public void writeBoard(char board[][], int score, char status){
      try {
         if (!firstBoard)
            outputStr.println("=====");
         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
               outputStr.print(board[i][j]);
            outputStr.println();
         }
         outputStr.println("score: " + score);
         outputStr.println("status: " + status);
         firstBoard = false;
      } catch(Exception erro){
         erro.printStackTrace();
      }
   }
   
   public void stop() {
      try {
         caveStr.close();
         outputStr.close();
         moveStr.close();
      } catch(Exception erro){
         erro.printStackTrace();
      }
   }
}
