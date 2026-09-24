import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pedido pedido = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Escolher pedido local ou delivery");
            System.out.println("3 - Mostrar dados do pedido");
            System.out.println("4 - Escolher forma de pagamento");
            System.out.println("5 - Pagar em dinheiro");
            System.out.println("6 - Pagar via PIX");
            System.out.println("7 - Pagar com cartão");
            System.out.println("8 - Encerrar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Número do pedido: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Valor do pedido: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Tipo do pedido:");
                    System.out.println("1 - Local");
                    System.out.println("2 - Delivery");
                    System.out.print("Escolha: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {

                        pedido = new PedidoLocal(
                                numero,
                                cliente,
                                valor
                        );

                    } else if (tipo == 2) {

                        System.out.print("Endereço de entrega: ");
                        String endereco = scanner.nextLine();

                        System.out.print("Taxa de entrega: ");
                        double taxa = scanner.nextDouble();

                        pedido = new PedidoDelivery(
                                numero,
                                cliente,
                                valor,
                                endereco,
                                taxa
                        );

                    } else {
                        System.out.println("Tipo inválido.");
                    }

                    System.out.println("Pedido cadastrado!");
                    break;

                case 2:

                    if (pedido != null) {
                        System.out.println(
                                "Tipo de pedido já definido."
                        );
                    } else {
                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 3:

                    if (pedido != null) {
                        pedido.mostrarDados();
                    } else {
                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 4:

                    System.out.println("\nFORMAS DE PAGAMENTO");
                    System.out.println("1 - Dinheiro");
                    System.out.println("2 - PIX");
                    System.out.println("3 - Cartão");

                    break;

                case 5:

                    if (pedido != null) {

                        double totalDinheiro =
                                pedido.getValorPedido();

                        if (pedido instanceof PedidoDelivery) {
                            PedidoDelivery delivery =
                                    (PedidoDelivery) pedido;

                            totalDinheiro +=
                                    delivery.getTaxaEntrega();
                        }

                        ((Pagamento) pedido)
                                .pagar(totalDinheiro);

                    } else {
                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 6:

                    if (pedido != null) {

                        System.out.print("Chave PIX: ");
                        String chave = scanner.nextLine();

                        double totalPix =
                                pedido.getValorPedido();

                        if (pedido instanceof PedidoDelivery) {
                            PedidoDelivery delivery =
                                    (PedidoDelivery) pedido;

                            totalPix +=
                                    delivery.getTaxaEntrega();
                        }

                        ((Pagamento) pedido)
                                .pagar(totalPix, chave);

                    } else {
                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 7:

                    if (pedido != null) {

                        System.out.print("Quantidade de parcelas: ");
                        int parcelas = scanner.nextInt();

                        if (parcelas <= 0) {
                            System.out.println(
                                    "Número de parcelas inválido."
                            );
                            break;
                        }

                        double totalCartao =
                                pedido.getValorPedido();

                        if (pedido instanceof PedidoDelivery) {
                            PedidoDelivery delivery =
                                    (PedidoDelivery) pedido;

                            totalCartao +=
                                    delivery.getTaxaEntrega();
                        }

                        ((Pagamento) pedido)
                                .pagar(totalCartao, parcelas);

                    } else {
                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 8:

                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
