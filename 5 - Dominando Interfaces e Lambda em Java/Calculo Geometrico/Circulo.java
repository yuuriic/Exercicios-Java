public class Circulo implements Figura {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }
}
