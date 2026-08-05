package DirigirCarro;

public class Carro {
    private boolean ligado;
    private int marcha;
    private int velocidade;

    public Carro() {
        this.ligado = false;
        this.marcha = 0;
        this.velocidade = 0;
    }

    public boolean ligar() {
        if (ligado) {
            return false;
        }
        ligado = true;
        return true;
    }

    public boolean desligar() {
        if (!ligado) {
            return false;
        }
        if (velocidade != 0 || marcha != 0) {
            return false;
        }
        ligado = false;
        return true;
    }

    public boolean acelerar() {
        if (!ligado) {
            return false;
        }
        if (marcha == 0) {
            return false;
        }
        int maxParaMarcha = getMaxVelocidadeParaMarcha(marcha);
        if (velocidade >= maxParaMarcha || velocidade >= 120) {
            return false;
        }
        velocidade++;
        if (velocidade > maxParaMarcha) {
            velocidade--;
            return false;
        }
        return true;
    }

    public boolean diminuirVelocidade() {
        if (!ligado) {
            return false;
        }
        if (velocidade <= 0) {
            return false;
        }
        velocidade--;
        return true;
    }

    public boolean virarEsquerda() {
        return virar("esquerda");
    }

    public boolean virarDireita() {
        return virar("direita");
    }

    public boolean trocarMarcha(int novaMarcha) {
        if (!ligado) {
            return false;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            return false;
        }
        if (novaMarcha == marcha) {
            return true;
        }
        if (Math.abs(novaMarcha - marcha) != 1) {
            return false;
        }
        if (!isVelocidadeValidaParaMarcha(velocidade, novaMarcha)) {
            return false;
        }
        marcha = novaMarcha;
        return true;
    }

    public boolean estaLigado() {
        return ligado;
    }

    public int getMarcha() {
        return marcha;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public String getStatus() {
        return String.format("Ligado: %s | Marcha: %d | Velocidade: %dkm/h", ligado ? "Sim" : "Não", marcha, velocidade);
    }

    private boolean virar(String direcao) {
        if (!ligado) {
            return false;
        }
        if (velocidade < 1 || velocidade > 40) {
            return false;
        }
        return true;
    }

    private int getMaxVelocidadeParaMarcha(int marcha) {
        return switch (marcha) {
            case 0 -> 0;
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> 120;
            default -> 0;
        };
    }

    private boolean isVelocidadeValidaParaMarcha(int velocidade, int marcha) {
        if (marcha == 0) {
            return velocidade == 0;
        }
        int min = getMinVelocidadeParaMarcha(marcha);
        int max = getMaxVelocidadeParaMarcha(marcha);
        return velocidade >= min && velocidade <= max;
    }

    private int getMinVelocidadeParaMarcha(int marcha) {
        return switch (marcha) {
            case 0 -> 0;
            case 1 -> 0;
            case 2 -> 21;
            case 3 -> 41;
            case 4 -> 61;
            case 5 -> 81;
            case 6 -> 101;
            default -> 0;
        };
    }
}
