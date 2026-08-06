import java.util.ArrayList;
import java.util.List;

public class MainMarketing {
    public static void main(String[] args) {
        List<ServicoMensagem> servicos = new ArrayList<>();
        servicos.add(new SmsService());
        servicos.add(new EmailService());
        servicos.add(new RedesSociaisService());
        servicos.add(new WhatsAppService());

        String mensagem = "Promoção especial para você!";

        for (ServicoMensagem servico : servicos) {
            servico.enviar(mensagem);
        }
    }
}
