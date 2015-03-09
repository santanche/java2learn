package pt.c02oo.s06heranca.s01individuo;

public class AppIndividuoH03 {

	public static void main(String[] args) {
        Alguem a = new Alguem(),
               b = new Alcebiades(),
               c = new Melissa();
        
        imprime(a);
        imprime(b);
        imprime(c);
	}
	
	static void imprime(Alguem x)
	{
		System.out.println("Nome: " + x.getNome());
	}

}
