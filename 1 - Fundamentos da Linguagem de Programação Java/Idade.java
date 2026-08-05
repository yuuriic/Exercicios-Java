import java.util.Scanner;

public class Idade {
    
        public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o seu nome: ");
        var name = scanner.next();
        System.out.println("Informe o seu ano de nascimento: ");
        var year = scanner.nextInt();

        System.out.printf("Olá %s, você tem %s anos.", name, 2026 - year);

        scanner.close();
    }
}


