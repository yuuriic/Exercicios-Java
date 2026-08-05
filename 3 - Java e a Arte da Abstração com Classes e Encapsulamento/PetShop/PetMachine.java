package PetShop;
public class PetMachine {
    private static final int MAX_WATER = 30;
    private static final int MAX_SHAMPOO = 10;
    private static final int WATER_PER_REFILL = 2;
    private static final int SHAMPOO_PER_REFILL = 2;
    private static final int WATER_PER_BATH = 10;
    private static final int SHAMPOO_PER_BATH = 2;
    private static final int WATER_PER_CLEAN = 3;
    private static final int SHAMPOO_PER_CLEAN = 1;

    private int waterLevel;
    private int shampooLevel;
    private Pet currentPet;
    private boolean needsCleaning;

    public PetMachine() {
        this.waterLevel = 0;
        this.shampooLevel = 0;
        this.currentPet = null;
        this.needsCleaning = false;
    }

    public void fillWater() {
        if (waterLevel >= MAX_WATER) {
            System.out.println("A água já está no máximo.");
            return;
        }
        waterLevel = Math.min(MAX_WATER, waterLevel + WATER_PER_REFILL);
        System.out.println("Água abastecida. Nível atual: " + waterLevel + " litros.");
    }

    public void fillShampoo() {
        if (shampooLevel >= MAX_SHAMPOO) {
            System.out.println("O shampoo já está no máximo.");
            return;
        }
        shampooLevel = Math.min(MAX_SHAMPOO, shampooLevel + SHAMPOO_PER_REFILL);
        System.out.println("Shampoo abastecido. Nível atual: " + shampooLevel + " litros.");
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getShampooLevel() {
        return shampooLevel;
    }

    public boolean hasPet() {
        return currentPet != null;
    }

    public void putPet(Pet pet) {
        if (pet == null) {
            System.out.println("Nenhum pet informado para colocar na máquina.");
            return;
        }
        if (currentPet != null) {
            System.out.println("Já existe um pet na máquina: " + currentPet.getName());
            return;
        }
        if (needsCleaning) {
            System.out.println("A máquina precisa ser limpa antes de colocar outro pet.");
            return;
        }
        currentPet = pet;
        currentPet.setClean(false);
        System.out.println("Pet " + pet.getName() + " colocado na máquina.");
    }

    public void removePet() {
        if (currentPet == null) {
            System.out.println("Não há pet na máquina para retirar.");
            return;
        }
        if (!currentPet.isClean()) {
            needsCleaning = true;
            System.out.println("O pet foi retirado sem estar limpo. A máquina agora precisa ser limpa.");
        } else {
            System.out.println("Pet " + currentPet.getName() + " retirado da máquina." );
        }
        currentPet = null;
    }

    public void washPet() {
        if (currentPet == null) {
            System.out.println("Não há pet na máquina para dar banho.");
            return;
        }
        if (waterLevel < WATER_PER_BATH) {
            System.out.println("Não há água suficiente para dar banho. Precisa de " + WATER_PER_BATH + " litros.");
            return;
        }
        if (shampooLevel < SHAMPOO_PER_BATH) {
            System.out.println("Não há shampoo suficiente para dar banho. Precisa de " + SHAMPOO_PER_BATH + " litros.");
            return;
        }
        waterLevel -= WATER_PER_BATH;
        shampooLevel -= SHAMPOO_PER_BATH;
        currentPet.setClean(true);
        System.out.println("Banho dado no pet " + currentPet.getName() + ". Ele está limpo.");
    }

    public void cleanMachine() {
        if (!needsCleaning) {
            System.out.println("A máquina não precisa de limpeza no momento.");
            return;
        }
        if (waterLevel < WATER_PER_CLEAN) {
            System.out.println("Não há água suficiente para limpar a máquina. Precisa de " + WATER_PER_CLEAN + " litros.");
            return;
        }
        if (shampooLevel < SHAMPOO_PER_CLEAN) {
            System.out.println("Não há shampoo suficiente para limpar a máquina. Precisa de " + SHAMPOO_PER_CLEAN + " litros.");
            return;
        }
        waterLevel -= WATER_PER_CLEAN;
        shampooLevel -= SHAMPOO_PER_CLEAN;
        needsCleaning = false;
        System.out.println("Máquina limpa. Pronta para receber outro pet.");
    }

    public void status() {
        System.out.println("--- Status da Máquina ---");
        System.out.println("Água: " + waterLevel + "/" + MAX_WATER + " litros");
        System.out.println("Shampoo: " + shampooLevel + "/" + MAX_SHAMPOO + " litros");
        System.out.println("Pet na máquina: " + (currentPet != null ? currentPet.getName() : "Nenhum"));
        System.out.println("Pet limpo: " + (currentPet != null ? currentPet.isClean() : "N/A"));
        System.out.println("Precision: " + (needsCleaning ? "Necessita limpeza" : "Sem necessidade de limpeza"));
    }
}
