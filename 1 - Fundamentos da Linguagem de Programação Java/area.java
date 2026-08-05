import java.util.Scanner;

public class area {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe o tamanho do lado do seu quadrado: ");
        var tamanho = scanner.nextInt();
        var area = (tamanho * tamanho);
        System.out.printf("Olá, a area do seu quadrado é %s", area);
        scanner.close();
    }
}

