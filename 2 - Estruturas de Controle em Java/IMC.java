import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe seu peso: ");
        var peso = scanner.nextDouble();
        System.out.println("Informe sua altura: ");
        var altura = scanner.nextDouble();
        var imc = (peso / (altura * altura));
        System.out.printf("Seu IMC é: %.2f \n", imc);
        if (imc < 18.5) {
            System.out.println("Você está abaixo do peso.");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Você está com o peso normal.");
        } else if (imc >= 25 && imc <= 29.9) {
            System.out.println("Você está com sobrepeso.");
        } else if (imc >= 30 && imc <= 34.9) {
            System.out.println("Você está com obesidade grau I.");
        } else if (imc >= 35 && imc <= 39.9) {
            System.out.println("Você está com obesidade grau II.");
        } else {
            System.out.println("Você está com obesidade grau III.");
        }
        scanner.close();
    }
}
