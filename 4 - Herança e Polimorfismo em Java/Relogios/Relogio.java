package Relogios;

public abstract class Relogio {
    private int hora;
    private int minuto;
    private int segundo;

    public Relogio(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (horaValida(hora)) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora inválida.");
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto < 60) {
            this.minuto = minuto;
        } else {
            throw new IllegalArgumentException("Minuto inválido.");
        }
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo < 60) {
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Segundo inválido.");
        }
    }

    protected abstract boolean horaValida(int hora);

    public String retornarHoraFormatada() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public abstract void sincronizarCom(Relogio outroRelogio);
}
