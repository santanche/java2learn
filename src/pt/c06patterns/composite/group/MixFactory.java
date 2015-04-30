package pt.c06patterns.composite.group;

import pt.c06patterns.composite.AbstractFactory;
import pt.c06patterns.composite.Aquarium;
import pt.c06patterns.composite.Aquatic;
import pt.c06patterns.composite.crab.Crab;
import pt.c06patterns.composite.fish.Fish;
import pt.c06patterns.composite.fish.FishAquarium;

public class MixFactory extends AbstractFactory
{
    @Override
    public Aquarium createAquarium()
    {
        return new FishAquarium();
    }

    @Override
    public Aquatic createAquatic()
    {
        Group theGroup = new Group();
        theGroup.addMember(new Crab());
        theGroup.addMember(new Fish());
        
        Group theSubGroup = new Group();
        theSubGroup.addMember(new Fish());
        theSubGroup.addMember(new Fish());

        theGroup.addMember(theSubGroup);
        
        return theGroup;
    }

}
