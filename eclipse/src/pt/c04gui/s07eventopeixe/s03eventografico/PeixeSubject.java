package pt.c04gui.s07eventopeixe.s03eventografico;

public interface PeixeSubject
{
    public void addPeixeListener(PeixeListener listener);
    public void removePeixeListener(PeixeListener listener);
}