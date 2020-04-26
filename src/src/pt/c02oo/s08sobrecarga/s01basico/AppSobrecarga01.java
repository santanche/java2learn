package pt.c02oo.s08sobrecarga.s01basico;

public class AppSobrecarga01 {
   AppSobrecarga01() {}
   AppSobrecarga01(int a, int b) {}
   AppSobrecarga01(int a, int b, String c) {}
   AppSobrecarga01(int a, String c, int b) {}
   
   String metodo() {return null;}
   int metodo(int a, int b) {return 0;}
   int metodo(int a, int b, String c) {return 0;}
   int metodo(int a, String c, int b) {return 0;}
   
   void teste() {
      AppSobrecarga01 app = new AppSobrecarga01();
      
      String r1 = app.metodo();
      int r2 = app.metodo(10, 15);
      int r3 = app.metodo(10, 15, "texto");
      int r4 = app.metodo(10, "texto", 15);
   }
}
