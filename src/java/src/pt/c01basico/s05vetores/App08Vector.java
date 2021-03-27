package pt.c01basico.s05vetores;

import java.util.Vector;

public class App08Vector {

	public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        
        v.add(6);
        v.add(new Integer(8));
        v.add(new Integer(55));
        
        Integer x = (Integer)v.get(0);
	}

}
