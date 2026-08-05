package UserSystem;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Ana", "ana@email.com", "1234");
        Vendedor vendedor = new Vendedor("Bruno", "bruno@email.com", "5678");
        Atendente atendente = new Atendente("Carla", "carla@email.com", "9012");

        gerente.realizarLogin();
        gerente.gerarRelatorioFinanceiro();
        gerente.consultarVendas();
        gerente.alterarDados("Ana Silva", "ana.silva@email.com");
        gerente.alterarSenha("novaSenha");

        vendedor.realizarLogin();
        vendedor.realizarVenda();
        vendedor.consultarVendas();

        atendente.realizarLogin();
        atendente.receberPagamentos(150.0);
        atendente.receberPagamentos(50.5);
        atendente.fecharCaixa();

        System.out.println("Gerente administrador? " + gerente.isAdministrador());
        System.out.println("Vendedor administrador? " + vendedor.isAdministrador());
        System.out.println("Atendente administrador? " + atendente.isAdministrador());
    }
}
