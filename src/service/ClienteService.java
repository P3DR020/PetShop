package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import model.Animal;
import model.Cliente;

public class ClienteService {

  // Lista onde todos os clientes cadastrados serão armazenados
  private final ArrayList<Cliente> lista = new ArrayList<>();

  /**
   * Método responsável por cadastrar um cliente novo no sistema.
   */
  public void cadastrar(Scanner sc) {

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Idade: ");
    int idade = sc.nextInt();
    sc.nextLine(); // consome ENTER

    System.out.print("CPF: ");
    String cpf = sc.nextLine();

    System.out.print("Telefone: ");
    String telefone = sc.nextLine();

    System.out.print("Endereço: ");
    String endereco = sc.nextLine();

    // Adicionando o novo cliente à lista
    lista.add(new Cliente(nome, idade, cpf, telefone, endereco));

    System.out.println("Cliente cadastrado com sucesso!");
  }

  /**
   * Busca um cliente usando o CPF (atributo exclusivo).
   * Retorna o cliente encontrado ou null.
   */
  public Cliente buscarPorCpf(String cpf) {
    return lista.stream()
        .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
        .findFirst()
        .orElse(null);
  }

  /**
   * Busca um cliente pelo nome.
   * Se houver nomes repetidos, retorna o primeiro da lista.
   */
  public Cliente buscarPorNome(String nome) {
    return lista.stream()
        .filter(c -> c.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
  }

  /**
   * Lista todos os clientes em ordem alfabética,
   * juntamente com os animais de cada cliente.
   */
  public void listarOrdenado(ArrayList<Animal> animais) {

    if (lista.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
      return;
    }

    // Ordenar lista por nome
    lista.sort(Comparator.comparing(Cliente::getNome));

    // Percorrer todos os clientes
    for (Cliente c : lista) {

      System.out.println("\n-------------------------------------------");
      System.out.println(c); // chama toString do cliente
      System.out.println("Animais deste cliente:");

      boolean temAnimais = false;

      // Percorre lista de animais e mostra os que pertencem a esse cliente
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

  /**
   * Remove um cliente do sistema (com confirmação).
   */
  public void remover(String cpf, Scanner sc) {

    // Busca cliente na lista
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

  /**
   * Lista todos os animais pertencentes a um cliente específico.
   */
  public void listarAnimaisDoCliente(Cliente cliente, ArrayList<Animal> animais) {

    System.out.println("\n=== ANIMAIS DO CLIENTE: " + cliente.getNome() + " ===");

    boolean achou = false;

    // Procura animais que tem o CPF do dono igual ao CPF do cliente
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

  /**
   * Retorna a lista completa de clientes.
   */
  public ArrayList<Cliente> getLista() {
    return lista;
  }
}
