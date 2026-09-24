public class PedidoLocal extends Pedido implements Pagamento {

    public PedidoLocal(
            int numero,
            String nomeCliente,
            double valorPedido) {

        super(numero, nomeCliente, valorPedido);
    }

    @Override
    public void pagar(double valor) {
        System.out.printf(
                "Pagamento em dinheiro: R$ %.2f%n",
                valor
        );
    }

    @Override
    public void pagar(double valor, String chavePix) {
        System.out.printf(
                "Pagamento via PIX: R$ %.2f%n",
                valor
        );
        System.out.println("Chave PIX: " + chavePix);
    }

    @Override
    public void pagar(double valor, int parcelas) {
        double valorParcela = valor / parcelas;

        System.out.printf(
                "Pagamento no cartão: R$ %.2f%n",
                valor
        );

        System.out.println("Parcelas: " + parcelas);

        System.out.printf(
                "Valor de cada parcela: R$ %.2f%n",
                valorParcela
        );
    }
}
