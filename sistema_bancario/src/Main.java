import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Adicionar Conta a um Cliente");
            System.out.println("3. Depositar em Conta");
            System.out.println("4. Sacar de Conta");
            System.out.println("5. Exibir Contas de um Cliente");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o caractere de nova linha

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    adicionarConta();
                    break;
                case 3:
                    depositarEmConta();
                    break;
                case 4:
                    sacarDeConta();
                    break;
                case 5:
                    exibirContasCliente();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarCliente() {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
        System.out.println("Cliente criado com sucesso!");
    }

    private static void adicionarConta() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Digite o CPF do cliente para adicionar a conta:");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir o caractere de nova linha
        System.out.println("Digite o titular da conta:");
        String titular = scanner.nextLine();
        System.out.println("Digite o saldo inicial da conta:");
        double saldo = scanner.nextDouble();
        System.out.println("Digite o limite de saque da conta:");
        double limiteSaque = scanner.nextDouble();
        scanner.nextLine(); // Consumir o caractere de nova linha

        ContaCorrente conta = new ContaCorrente(numeroConta, titular, saldo, limiteSaque);
        cliente.adicionarConta(conta);
    }

    private static void depositarEmConta() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite o número da conta para depósito:");
        int numeroConta = scanner.nextInt();
        System.out.println("Digite o valor para depósito:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir o caractere de nova linha

        cliente.depositarEmConta(numeroConta, valor);
    }

    private static void sacarDeConta() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Digite o número da conta para saque:");
        int numeroConta = scanner.nextInt();
        System.out.println("Digite o valor para saque:");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir o caractere de nova linha

        cliente.sacarDeConta(numeroConta, valor);
    }

    private static void exibirContasCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        Cliente cliente = encontrarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        cliente.exibirContas();
    }

    private static Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
