package Relogios;

import java.time.LocalTime;
import java.time.ZoneId;

public class RelogioAmericano extends Relogio {
    public RelogioAmericano() {
        this(obterHoraAmericanaReal());
    }

    private RelogioAmericano(int[] horaMinutoSegundo) {
        this(horaMinutoSegundo[0], horaMinutoSegundo[1], horaMinutoSegundo[2]);
    }

    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
    }

    private static int[] obterHoraAmericanaReal() {
        LocalTime agora = LocalTime.now(ZoneId.of("America/New_York"));
        int hora24 = agora.getHour();
        int hora12 = hora24 == 0 ? 12 : (hora24 > 12 ? hora24 - 12 : hora24);

        return new int[]{hora12, agora.getMinute(), agora.getSecond()};
    }

    @Override
    protected boolean horaValida(int hora) {
        return hora >= 1 && hora <= 12;
    }

    @Override
    public void sincronizarCom(Relogio outroRelogio) {
        int horaConvertida;

        if (outroRelogio instanceof RelogioAmericano) {
            horaConvertida = outroRelogio.getHora();
        } else {
            int horaOrigem = outroRelogio.getHora();
            horaConvertida = horaOrigem % 12;
            if (horaConvertida == 0) {
                horaConvertida = 12;
            }
        }

        setHora(horaConvertida);
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }
}
