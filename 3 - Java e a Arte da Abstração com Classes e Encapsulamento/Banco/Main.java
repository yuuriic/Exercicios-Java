package Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o valor do depósito inicial: R$ ");
        double depositoInicial = lerDouble(scanner);
        ContaBancaria conta = new ContaBancaria(depositoInicial);

        while (true) {
            System.out.println("\n===== Menu Conta Bancária =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar limite de cheque especial disponível");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar se está usando cheque especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
                case 2 -> System.out.printf("Cheque especial disponível: R$ %.2f%n", conta.consultarChequeEspecial());
                case 3 -> {
                    System.out.print("Valor para depositar: R$ ");
                    conta.depositar(lerDouble(scanner));
                }
                case 4 -> {
                    System.out.print("Valor para sacar: R$ ");
                    conta.sacar(lerDouble(scanner));
                }
                case 5 -> {
                    System.out.print("Valor do boleto: R$ ");
                    conta.pagarBoleto(lerDouble(scanner));
                }
                case 6 -> System.out.println(conta.usandoChequeEspecial() ? "A conta está usando cheque especial." : "A conta não está usando cheque especial.");
                case 0 -> {
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static int lerInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.nextLine();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um número válido.");
            scanner.nextLine();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}
