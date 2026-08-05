import java.util.Scanner;

public class AreaRetangulo {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("Informe a base do retangulo: ");
        var base = scanner.nextInt();
        System.out.println("Informe a altura do retangulo: ");
        var height = scanner.nextInt();
        var Area_retangulo = (base * height);
        System.out.printf("\nA area do retangulo é de %s. \n ", Area_retangulo);
        scanner.close();
    }
}
