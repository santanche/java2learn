package pt.c01basico.s04vetores;
import java.util.Scanner;


public class App03MergeVetores
{

	/**
	 * Le um vetor de inteiros.
	 * 
	 * @return O vetor com os valores lidos.
	 */
	static public int[] leVetor()
	{
		System.out.println("Digite o tamanho: ");
        Scanner teclado = new Scanner(System.in);
        int tamanho = Integer.parseInt(teclado.nextLine());

	    int vetor[] = new int[tamanho];
	    for (int i = 0; i < tamanho; i++)
	    {
	    	System.out.println("Digite um numero: ");
	    	vetor[i] = Integer.parseInt(teclado.nextLine());
	    }
	    
	    return vetor;
	}
	
	static public int[] merge(int vetor1[], int vetor2[])
	{
		int resultado[] = new int[vetor1.length + vetor2.length];
		
		int p1 = 0, p2 = 0;
		for (int i = 0; i < resultado.length; i++)
		{
			if (p2 >= vetor2.length || (p1 < vetor1.length && vetor1[p1] < vetor2[p2])) {
				resultado[i] = vetor1[p1];
				p1++;
			} else {
				resultado[i] = vetor2[p2];
				p2++;
			}
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		int vetor1[] = leVetor(),
		    vetor2[] = leVetor();
		
		int vetor3[] = merge(vetor1, vetor2);

		System.out.println("Resultado:");
		for (int i = 0; i < vetor3.length; i++)
			System.out.println(vetor3[i]);
	}

}
