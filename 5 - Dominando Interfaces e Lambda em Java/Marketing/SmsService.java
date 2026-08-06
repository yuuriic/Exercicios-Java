public class SmsService implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}
