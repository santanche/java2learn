package pt.c06patterns.builder.livro;

public class AppCriaLivro
{

    public static void main(String[] args)
    {
        AbstractBuilderLivro build = new ConcreteBuilderBibTeX();
        DirectorLivro dir = new DirectorLivro();
        dir.construct(build);
    }

}
