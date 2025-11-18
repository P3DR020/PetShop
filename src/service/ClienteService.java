package service;

import java.util.ArrayList;  // ou os imports específicos
import java.util.Comparator; // ou os imports específicos
import java.util.Scanner;
import model.Cliente;

public class ClienteService {

  private final ArrayList<Cliente> lista = new ArrayList<>();

  public void cadastrar(Scanner in) {
    System.out.print("Nome: ");
    String nome = in.nextLine();
    System.out.print("Idade: ");
    int idade = in.nextInt();
    in.nextLine();
    System.out.print("CPF: ");
    String cpf = in.nextLine();
    System.out.print("Telefone: ");
    String tel = in.nextLine();
    System.out.print("Endereço: ");
    String end = in.nextLine();

    lista.add(new Cliente(nome, idade, cpf, tel, end));
    System.out.println("Cliente cadastrado!");
  }

  public void listarOrdenado() {
    lista.sort(Comparator.comparing(Cliente::getNome));
    lista.forEach(System.out::println);
  }

  public Cliente buscar(String cpf) {
    return lista.stream()
        .filter(c -> c.getCpf().equals(cpf))
        .findFirst()
        .orElse(null);
  }

  public Cliente buscarPorCpf(String cpf) {
    return lista.stream()
        .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
        .findFirst()
        .orElse(null);
  }

  public Cliente buscarPorNome(String nome) {
    return lista.stream()
        .filter(c -> c.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
  }

  public void remover(String cpf, Scanner in) {
    Cliente c = buscar(cpf);
    if (c == null) {
      System.out.println("Cliente não encontrado.");
      return;
    }

    System.out.print("Confirmar remoção? (s/n): ");
    String op = in.nextLine();

    if (op.equalsIgnoreCase("s")) {
      lista.remove(c);
      System.out.println("Cliente removido.");
    }
  }

  public ArrayList<Cliente> getLista() {
    return lista;
  }
}
