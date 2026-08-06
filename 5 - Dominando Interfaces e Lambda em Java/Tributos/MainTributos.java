public class MainTributos {
    public static void main(String[] args) {
        Produto[] produtos = {
            new Produto("Arroz", 50.0, Produto.TipoProduto.ALIMENTACAO),
            new Produto("Vitamina", 80.0, Produto.TipoProduto.SAUDE_BEM_ESTAR),
            new Produto("Camisa", 120.0, Produto.TipoProduto.VESTUARIO),
            new Produto("Ingresso de cinema", 40.0, Produto.TipoProduto.CULTURA)
        };

        System.out.println("Cálculo de tributos:\n");

        for (Produto produto : produtos) {
            double imposto = produto.calcularImposto();
            System.out.printf("%s - Valor: R$ %.2f - Imposto: R$ %.2f (%s)\n",
                    produto.getNome(),
                    produto.getValor(),
                    imposto,
                    produto.getTipo());
        }
    }
}
