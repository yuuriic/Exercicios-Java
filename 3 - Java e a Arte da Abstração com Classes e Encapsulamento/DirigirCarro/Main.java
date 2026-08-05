package DirigirCarro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        while (true) {
            System.out.println("\n=== Controle de Carro ===");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Diminuir velocidade");
            System.out.println("5. Virar à esquerda");
            System.out.println("6. Virar à direita");
            System.out.println("7. Verificar velocidade");
            System.out.println("8. Trocar marcha");
            System.out.println("9. Verificar status");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1" -> {
                    if (carro.ligar()) {
                        System.out.println("Carro ligado.");
                    } else {
                        System.out.println("O carro já está ligado.");
                    }
                }
                case "2" -> {
                    if (carro.desligar()) {
                        System.out.println("Carro desligado.");
                    } else {
                        System.out.println("Não é possível desligar. Deixe o carro em ponto morto e com velocidade 0.");
                    }
                }
                case "3" -> {
                    if (carro.acelerar()) {
                        System.out.println("Acelerando. Velocidade atual: " + carro.getVelocidade() + "km/h.");
                    } else {
                        System.out.println("Não é possível acelerar. Verifique se o carro está ligado, em marcha e dentro do limite de velocidade.");
                    }
                }
                case "4" -> {
                    if (carro.diminuirVelocidade()) {
                        System.out.println("Diminuindo velocidade. Velocidade atual: " + carro.getVelocidade() + "km/h.");
                    } else {
                        System.out.println("Não é possível diminuir a velocidade. O carro está parado ou desligado.");
                    }
                }
                case "5" -> {
                    if (carro.virarEsquerda()) {
                        System.out.println("O carro virou à esquerda.");
                    } else {
                        System.out.println("Não é possível virar à esquerda. A velocidade deve estar entre 1km/h e 40km/h e o carro deve estar ligado.");
                    }
                }
                case "6" -> {
                    if (carro.virarDireita()) {
                        System.out.println("O carro virou à direita.");
                    } else {
                        System.out.println("Não é possível virar à direita. A velocidade deve estar entre 1km/h e 40km/h e o carro deve estar ligado.");
                    }
                }
                case "7" -> System.out.println("Velocidade atual: " + carro.getVelocidade() + "km/h.");
                case "8" -> {
                    System.out.print("Informe a nova marcha (0 a 6): ");
                    int novaMarcha = lerInt(scanner);
                    if (carro.trocarMarcha(novaMarcha)) {
                        System.out.println("Marcha alterada para " + carro.getMarcha() + ".");
                    } else {
                        System.out.println("Não é possível trocar para essa marcha. Verifique se a troca é somente de uma marcha e se a velocidade está compatível.");
                    }
                }
                case "9" -> System.out.println(carro.getStatus());
                case "0" -> {
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
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
}
