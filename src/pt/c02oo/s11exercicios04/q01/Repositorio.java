package pt.c02oo.s11exercicios04.q01;

//representa genericamente um repositorio
public interface Repositorio
{
    public void guarda(Pessoa nova); // guarda uma pessoa
    public Pessoa recupera(String cpf);  // recupera pessoa com o CPF informado
    public Pessoa primeiro(); // se desloca para a primeira pessoa e a retorna
    public Pessoa proximo(); // se desloca para a proxima pessoa e a retorna
}