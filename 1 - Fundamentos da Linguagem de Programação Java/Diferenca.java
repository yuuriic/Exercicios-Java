import java.util.Scanner;

public class Diferenca {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        System.out.println("\nInforme um nome: ");
        var name1 = scanner.next();
        System.out.printf("\nInforme a idade do(a) %s: ", name1);
        var age1 = scanner.nextInt();
        System.out.println("\nInforme outro nome: ");
        var name2 = scanner.next();
        System.out.printf("\nInforme a idade do(a) %s: ", name2);
        var age2 = scanner.nextInt();
        var difference = (age1 - age2);
        
        if (difference >= 0) {
            System.out.printf("\nA diferença de idade do(a) %s para %s é de %s anos. \n ", name1, name2, difference);
        } else {
            var Difference1 = (age2 - age1);
            System.out.printf("\nA diferença de idade do(a) %s para %s é de %s anos. \n ", name1, name2, Difference1);
        }

        scanner.close();

    }
}
