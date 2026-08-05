package UserSystem;

public class Atendente extends Usuario {
    private double valorEmCaixa;

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha, false);
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
    }

    public void receberPagamentos(double valor) {
        valorEmCaixa += valor;
        System.out.println("Pagamento recebido: R$ " + valor + " .");
    }

    public double fecharCaixa() {
        System.out.println("Caixa fechado com saldo de R$ " + valorEmCaixa + ".");
        return valorEmCaixa;
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
