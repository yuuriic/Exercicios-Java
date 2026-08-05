import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args){
       var scanner = new Scanner(System.in);
         System.out.println("Informe o número que deseja ver a tabuada: ");
          var numero = scanner.nextInt();
          System.out.printf("Tabuada do %s: \n", numero);
          for (int i = 1; i <= 10; i++){
                var resultado = (numero * i);
                System.out.printf("%s x %s = %s \n", numero, i, resultado);
          }
          scanner.close();
    }
}

