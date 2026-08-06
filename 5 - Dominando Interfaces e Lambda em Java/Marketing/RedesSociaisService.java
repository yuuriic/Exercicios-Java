public class RedesSociaisService implements ServicoMensagem {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[Redes Sociais] " + mensagem);
    }
}
