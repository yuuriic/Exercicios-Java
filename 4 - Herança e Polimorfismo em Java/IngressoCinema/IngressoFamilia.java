package IngressoCinema;

public class IngressoFamilia extends Ingresso {
    private int numeroPessoas;

    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int numeroPessoas) {
        super(valor, nomeFilme, dublado);
        this.numeroPessoas = numeroPessoas;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    @Override
    public double valorReal() {
        double valorTotal = getValor() * numeroPessoas;
        if (numeroPessoas > 3) {
            valorTotal *= 0.95;
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Família | Pessoas: %d | Valor real: R$ %.2f", numeroPessoas, valorReal());
    }
}
