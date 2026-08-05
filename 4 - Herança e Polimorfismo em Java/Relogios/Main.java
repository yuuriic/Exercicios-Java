package Relogios;

public class Main {
    public static void main(String[] args) {
        RelogioBrasileiro brasileiro = new RelogioBrasileiro();
        RelogioAmericano americano = new RelogioAmericano();

        System.out.println("Brasileiro: " + brasileiro.retornarHoraFormatada());
        System.out.println("Americano: " + americano.retornarHoraFormatada());

        americano.sincronizarCom(brasileiro);
        System.out.println("Americano sincronizado: " + americano.retornarHoraFormatada());

        brasileiro.sincronizarCom(americano);
        System.out.println("Brasileiro sincronizado: " + brasileiro.retornarHoraFormatada());
    }
}
