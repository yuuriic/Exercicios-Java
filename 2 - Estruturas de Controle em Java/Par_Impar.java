import java.util.Scanner;

public class Par_Impar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        var primeiro = scanner.nextInt();

        System.out.print("Digite o segundo número (maior que o primeiro): ");
        var segundo = scanner.nextInt();

        while (segundo <= primeiro) {
            System.out.println("O segundo número deve ser maior que o primeiro.");
            System.out.print("Digite o segundo número novamente: ");
            segundo = scanner.nextInt();
        }

        scanner.nextLine();
        System.out.print("Escolha par ou impar: ");
        var escolha = scanner.nextLine().trim().toLowerCase();

        while (!escolha.equals("par") && !escolha.equals("impar")) {
            System.out.println("Opção inválida. Digite apenas 'par' ou 'impar'.");
            System.out.print("Escolha par ou impar: ");
            escolha = scanner.nextLine().trim().toLowerCase();
        }

        var contador = 0;
        System.out.println("Números " + escolha + "s no intervalo " + segundo + " a " + primeiro + ":");

        for (var numero = segundo; numero >= primeiro; numero--) {
            boolean ehPar = numero % 2 == 0;
            boolean deveExibir = escolha.equals("par") ? ehPar : !ehPar;

            if (deveExibir) {
                System.out.println(numero);
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Nenhum número " + escolha + " encontrado no intervalo informado.");
        }

        scanner.close();
    }
}
