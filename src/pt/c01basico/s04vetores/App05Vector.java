package pt.c01basico.s04vetores;

import java.util.Vector;

public class App05Vector {

	public static void main(String[] args) {
        Vector v = new Vector();
        
        v.add(6);
        v.add(new Integer(8));
        v.add(new Integer(55));
        
        Integer x = (Integer)v.get(0);
	}

}
