package Relogios;

import java.time.LocalTime;
import java.time.ZoneId;

public class RelogioBrasileiro extends Relogio {
    public RelogioBrasileiro() {
        this(LocalTime.now(ZoneId.of("America/Sao_Paulo")).getHour(),
             LocalTime.now(ZoneId.of("America/Sao_Paulo")).getMinute(),
             LocalTime.now(ZoneId.of("America/Sao_Paulo")).getSecond());
    }

    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    @Override
    protected boolean horaValida(int hora) {
        return hora >= 0 && hora <= 23;
    }

    @Override
    public void sincronizarCom(Relogio outroRelogio) {
        int horaConvertida;

        if (outroRelogio instanceof RelogioBrasileiro) {
            horaConvertida = outroRelogio.getHora();
        } else {
            int horaOrigem = outroRelogio.getHora();
            if (horaOrigem == 12) {
                horaConvertida = 0;
            } else {
                horaConvertida = horaOrigem;
            }
        }

        setHora(horaConvertida);
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }
}
