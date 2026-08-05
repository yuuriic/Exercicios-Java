package PetShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetMachine machine = new PetMachine();

        while (true) {
            System.out.println("\n===== Petshop - Máquina de Banho =====");
            System.out.println("1. Colocar pet na máquina");
            System.out.println("2. Retirar pet da máquina");
            System.out.println("3. Dar banho no pet");
            System.out.println("4. Abastecer água");
            System.out.println("5. Abastecer shampoo");
            System.out.println("6. Verificar nível de água");
            System.out.println("7. Verificar nível de shampoo");
            System.out.println("8. Verificar se tem pet no banho");
            System.out.println("9. Limpar máquina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1" -> {
                    System.out.print("Informe o nome do pet: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Nome do pet não pode ficar em branco.");
                    } else {
                        machine.putPet(new Pet(name));
                    }
                }
                case "2" -> machine.removePet();
                case "3" -> machine.washPet();
                case "4" -> machine.fillWater();
                case "5" -> machine.fillShampoo();
                case "6" -> System.out.println("Nível de água: " + machine.getWaterLevel() + " litros.");
                case "7" -> System.out.println("Nível de shampoo: " + machine.getShampooLevel() + " litros.");
                case "8" -> System.out.println(machine.hasPet() ? "Há um pet na máquina." : "Não há pet na máquina.");
                case "9" -> machine.cleanMachine();
                case "0" -> {
                    System.out.println("Encerrando o sistema. Até mais!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
