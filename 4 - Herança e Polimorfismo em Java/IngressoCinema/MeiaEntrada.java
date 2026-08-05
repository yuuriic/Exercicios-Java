package IngressoCinema;

public class MeiaEntrada extends Ingresso {
    public MeiaEntrada(double valor, String nomeFilme, boolean dublado) {
        super(valor, nomeFilme, dublado);
    }

    @Override
    public double valorReal() {
        return getValor() / 2.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Meia Entrada | Valor real: R$ %.2f", valorReal());
    }
}
