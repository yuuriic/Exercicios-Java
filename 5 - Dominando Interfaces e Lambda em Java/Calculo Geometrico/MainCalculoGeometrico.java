public class MainCalculoGeometrico {
    public static void main(String[] args) {
        Figura quadrado = new Quadrado(5);
        Figura retangulo = new Retangulo(4, 7);
        Figura circulo = new Circulo(3);

        System.out.println("Área do quadrado: " + quadrado.area());
        System.out.println("Área do retângulo: " + retangulo.area());
        System.out.println("Área do círculo: " + circulo.area());
    }
}
