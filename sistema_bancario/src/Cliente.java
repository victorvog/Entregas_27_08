import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<ContaCorrente> contas = new ArrayList<>();

    // Construtor
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ContaCorrente> getContas() {
        return contas;
    }

    public void adicionarConta(ContaCorrente conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso!");
    }

    public void exibirContas() {
        for (ContaCorrente conta : contas) {
            System.out.println("Conta: " + conta.getNumeroConta() + " - Titular: " + conta.getTitular() + " - Saldo: " + conta.getSaldo());
        }
    }

    public void depositarEmConta(int numeroConta, double valor) {
        ContaCorrente conta = encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacarDeConta(int numeroConta, double valor) {
        ContaCorrente conta = encontrarContaPorNumero(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private ContaCorrente encontrarContaPorNumero(int numeroConta) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
