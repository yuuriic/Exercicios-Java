package UserSystem;

public class Gerente extends Usuario {
    public Gerente(String nome, String email, String senha) {
        super(nome, email, senha, true);
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Relatório financeiro gerado pelo gerente " + getNome() + ".");
    }

    public void consultarVendas() {
        System.out.println("Gerente " + getNome() + " consultou as vendas.");
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
