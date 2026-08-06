public class Produto {
    private String nome;
    private double valor;
    private TipoProduto tipo;

    public Produto(String nome, double valor, TipoProduto tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    public double calcularImposto() {
        return valor * tipo.getAliquota();
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public enum TipoProduto {
        ALIMENTACAO(0.01),
        SAUDE_BEM_ESTAR(0.015),
        VESTUARIO(0.025),
        CULTURA(0.04);

        private final double aliquota;

        TipoProduto(double aliquota) {
            this.aliquota = aliquota;
        }

        public double getAliquota() {
            return aliquota;
        }

        @Override
        public String toString() {
            switch (this) {
                case ALIMENTACAO:
                    return "Alimentação";
                case SAUDE_BEM_ESTAR:
                    return "Saúde e bem estar";
                case VESTUARIO:
                    return "Vestuário";
                case CULTURA:
                    return "Cultura";
                default:
                    return name();
            }
        }
    }
}
