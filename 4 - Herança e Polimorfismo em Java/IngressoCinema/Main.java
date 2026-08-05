package IngressoCinema;

public class Main {
    public static void main(String[] args) {
        MeiaEntrada meia = new MeiaEntrada(40.0, "Aventura no Espaço", true);
        IngressoFamilia familiaPequena = new IngressoFamilia(30.0, "Comédia Familiar", false, 3);
        IngressoFamilia familiaGrande = new IngressoFamilia(30.0, "Comédia Familiar", false, 4);

        System.out.println(meia);
        System.out.println(familiaPequena);
        System.out.println(familiaGrande);
    }
}
