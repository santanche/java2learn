package pt.c05concorrente.s05volatile;

public class Ex02Transferencia
{
    private volatile float saldoA,
                           saldoB;
    
    public Ex02Transferencia(float saldoA, float saldoB)
    {
        this.saldoA = saldoA;
        this.saldoB = saldoB;
    }
    
    public void transfereAB(float valor)
    {
        saldoA -= valor;
        saldoB += valor;
    }
    
    public void mostraSaldos()
    {
        System.out.println("Saldo A: " + saldoA + "; Saldo B: " + saldoB);
    }
}
