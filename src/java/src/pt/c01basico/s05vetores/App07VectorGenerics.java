package pt.c01basico.s05vetores;

import java.util.Vector;

public class App07VectorGenerics {

	public static void main(String[] args) {
        Vector<String> v = new Vector<String>();
        v.add("Asdrubal");
        v.add("Bonerges");
        v.add("Mirinda");
        
        for (int i = 0; i < v.size(); i++)
        	System.out.println(v.get(i));
	}

}
