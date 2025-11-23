package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import model.Animal;
import model.Cliente;

public class ClienteService {

  private final ArrayList<Cliente> lista = new ArrayList<>();

  // Cadastrar cliente
  public void cadastrar(Scanner sc) {

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Idade: ");
    int idade = sc.nextInt();
    sc.nextLine();

    System.out.print("CPF: ");
    String cpf = sc.nextLine();

    System.out.print("Telefone: ");
    String telefone = sc.nextLine();

    System.out.print("Endereço: ");
    String endereco = sc.nextLine();

    lista.add(new Cliente(nome, idade, cpf, telefone, endereco));
    System.out.println("Cliente cadastrado com sucesso!");
  }

  // Buscar cliente por CPF
  public Cliente buscarPorCpf(String cpf) {
    return lista.stream()
        .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
        .findFirst()
        .orElse(null);
  }

  // Buscar cliente por Nome
  public Cliente buscarPorNome(String nome) {
    return lista.stream()
        .filter(c -> c.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
  }

  // Listar clientes ordenados + seus animais
  public void listarOrdenado(ArrayList<Animal> animais) {

    if (lista.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
      return;
    }

    lista.sort(Comparator.comparing(Cliente::getNome));

    for (Cliente c : lista) {

      System.out.println("\n-------------------------------------------");
      System.out.println(c);
      System.out.println("Animais deste cliente:");

      boolean temAnimais = false;

      for (Animal a : animais) {
        if (a.getDono().getCpf().equals(c.getCpf())) {
          System.out.println(" - " + a.getNome() +
              " (" + a.getClass().getSimpleName() + ")");
          temAnimais = true;
        }
      }

      if (!temAnimais) {
        System.out.println(" - Nenhum animal cadastrado");
      }
    }

    System.out.println("-------------------------------------------");
  }

  // Remover cliente
  public void remover(String cpf, Scanner sc) {

    Cliente c = buscarPorCpf(cpf);

    if (c == null) {
      System.out.println("Cliente não encontrado.");
      return;
    }

    System.out.print("Deseja realmente remover? (s/n): ");
    String resp = sc.nextLine();

    if (resp.equalsIgnoreCase("s")) {
      lista.remove(c);
      System.out.println("Cliente removido com sucesso!");
    } else {
      System.out.println("Remoção cancelada.");
    }
  }

  // Listar todos os animais de um cliente
  public void listarAnimaisDoCliente(Cliente cliente, ArrayList<Animal> animais) {

    System.out.println("\n=== ANIMAIS DO CLIENTE: " + cliente.getNome() + " ===");

    boolean achou = false;

    for (Animal a : animais) {
      if (a.getDono().getCpf().equals(cliente.getCpf())) {
        System.out.println(a);
        achou = true;
      }
    }

    if (!achou) {
      System.out.println("Este cliente não possui animais cadastrados.");
    }
  }

  // Acessar lista
  public ArrayList<Cliente> getLista() {
    return lista;
  }
}
