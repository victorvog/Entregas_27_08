import java.util.Scanner;
import sistema_vendas.Cliente;
import sistema_vendas.Produto;
import sistema_vendas.ItemPedido;
import sistema_vendas.Pedido;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um cliente
        Cliente cliente = new Cliente("João Silva", "12345678900");

        // Criar produtos
        Produto produto1 = new Produto("P001", "Produto A", 50.0, 100);
        Produto produto2 = new Produto("P002", "Produto B", 30.0, 200);

        // Criar itens de pedido
        ItemPedido item1 = new ItemPedido(produto1, 2);
        ItemPedido item2 = new ItemPedido(produto2, 5);

        // Criar um pedido
        Pedido pedido = new Pedido(1, cliente, "2024-08-27");
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        // Exibir total do pedido
        System.out.println("Total do Pedido: " + pedido.calcularTotal());

        // Exibir informações dos produtos
        produto1.consultarInformacoes();
        produto2.consultarInformacoes();
    }
}
