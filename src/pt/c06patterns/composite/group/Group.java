package pt.c06patterns.composite.group;

import java.util.Vector;

import pt.c06patterns.composite.Aquatic;

public class Group implements Aquatic
{
    Vector<Aquatic> list = new Vector<Aquatic>();
    
    public void addMember(Aquatic member)
    {
        list.add(member);
    }
    
    public String aquaticImage()
    {
        String groupString = "~~~~~~~~~~~~~~~~\n";
        for (Aquatic l : list)
            groupString += l.aquaticImage();
        groupString += "oooOooooOooo\n";
        return groupString;
    }

}
