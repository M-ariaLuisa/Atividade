public class PedidoDelivery extends Pedido implements Pagamento {

    private String endereco;
    private double taxaEntrega;

    public PedidoDelivery(
            int numero,
            String nomeCliente,
            double valorPedido,
            String endereco,
            double taxaEntrega) {

        super(numero, nomeCliente, valorPedido);
        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();

        System.out.println("Endereço: " + endereco);

        System.out.printf(
                "Taxa de entrega: R$ %.2f%n",
                taxaEntrega
        );

        System.out.printf(
                "Total com entrega: R$ %.2f%n",
                getValorPedido() + taxaEntrega
        );
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
