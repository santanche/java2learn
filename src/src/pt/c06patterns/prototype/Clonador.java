package pt.c06patterns.prototype;

public class Clonador
{
    public static void main(String[] args)
    {
        StringClonable a = new StringClonable("Asdrubal");
        StringClonable b = a;
        b.append("X");
        System.out.println(a);
        
        StringClonable c = new StringClonable("Alcebiades");
        StringClonable d = c.clone();
        d.append("X");
        System.out.println(c);
        
    }
 
}
