package UserSystem;

public class Vendedor extends Usuario {
    private int quantidadeVendas;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public void realizarVenda() {
        quantidadeVendas++;
        System.out.println("Venda registrada para " + getNome() + ".");
    }

    public void consultarVendas() {
        System.out.println("O vendedor " + getNome() + " realizou " + quantidadeVendas + " vendas.");
    }

    @Override
    public void alterarDados(String novoNome, String novoEmail) {
        super.alterarDados(novoNome, novoEmail);
    }

    @Override
    public void alterarSenha(String novaSenha) {
        super.alterarSenha(novaSenha);
    }
}
