import java.util.Scanner;

public class Divisão {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número inicial: ");
        int inicial = scanner.nextInt();

        while (inicial <= 0) {
            System.out.println("O número inicial deve ser maior que zero.");
            System.out.print("Digite o número inicial novamente: ");
            inicial = scanner.nextInt();
        }

        while (true) {
            System.out.print("Digite outro número: ");
            int numero = scanner.nextInt();

            if (numero < inicial) {
                System.out.println("Número menor que o inicial. Será ignorado.");
                continue;
            }

            int resto = numero % inicial;

            if (resto != 0) {
                System.out.println("Resto diferente de 0 encontrado: " + resto);
                System.out.println("Execução encerrada.");
                break;
            }

            System.out.println("Resto igual a 0. Continuando...");
        }

        scanner.close();
    }
}
