public class WhatsAppService implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[WhatsApp] " + mensagem);
    }
}
