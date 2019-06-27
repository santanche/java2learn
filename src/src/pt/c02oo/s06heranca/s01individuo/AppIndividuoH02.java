package pt.c02oo.s06heranca.s01individuo;

public class AppIndividuoH02 {

	public static void main(String[] args) {
        Alguem a = new Alguem(),
               b = new Alcebiades(),
               c = new Melissa();
        
        System.out.println("Nome a: " + a.getNome());
        System.out.println("Nome b: " + b.getNome());
        System.out.println("Nome c: " + c.getNome());
	}

}
