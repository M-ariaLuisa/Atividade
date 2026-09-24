public class Pedido {

    private int numero;
    private String nomeCliente;
    private double valorPedido;

    public Pedido(int numero, String nomeCliente, double valorPedido) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.valorPedido = valorPedido;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void mostrarDados() {
        System.out.println("Número do pedido: " + numero);
        System.out.println("Cliente: " + nomeCliente);
        System.out.printf(
                "Valor do pedido: R$ %.2f%n",
                valorPedido
        );
    }
}
