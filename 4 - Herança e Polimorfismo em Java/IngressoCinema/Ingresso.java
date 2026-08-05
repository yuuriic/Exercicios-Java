package IngressoCinema;

public abstract class Ingresso {
    private double valor;
    private String nomeFilme;
    private boolean dublado;

    public Ingresso(double valor, String nomeFilme, boolean dublado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    public double getValor() {
        return valor;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public boolean isDublado() {
        return dublado;
    }

    public String getTipoAudio() {
        return dublado ? "Dublado" : "Legendado";
    }

    public abstract double valorReal();

    @Override
    public String toString() {
        return String.format("Filme: %s | Valor base: R$ %.2f | %s", nomeFilme, valor, getTipoAudio());
    }
}
