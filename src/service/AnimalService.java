package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;
import model.Cachorro;
import model.Cliente;
import model.Gato;

public class AnimalService {

  // Lista que armazena todos os animais cadastrados
  private final ArrayList<Animal> lista = new ArrayList<>();

  /**
   * Método responsável por cadastrar um novo animal no sistema.
   * O dono deve ser escolhido entre os clientes existentes.
   */
  public void cadastrar(Scanner sc, ArrayList<Cliente> clientes) {

    // Verifica se existe ao menos 1 cliente cadastrado
    if (clientes.isEmpty()) {
      System.out.println("Erro: não há clientes cadastrados!");
      return; // não permite cadastrar animal sem dono
    }

    System.out.println("\n=== CADASTRAR ANIMAL ===");

    // --- ESCOLHA DO DONO ---
    System.out.println("Escolha o dono do animal:");
    for (int i = 0; i < clientes.size(); i++) {
      System.out.println((i + 1) + " - " + clientes.get(i).getNome());
    }

    System.out.print("Dono (número): ");
    int indice = sc.nextInt() - 1; // -1 para converter opção para índice real
    sc.nextLine(); // consome ENTER

    // Validação do índice escolhido
    if (indice < 0 || indice >= clientes.size()) {
      System.out.println("Cliente inválido.");
      return;
    }

    // Dono selecionado
    Cliente dono = clientes.get(indice);

    // --- TIPO DO ANIMAL ---
    System.out.println("1 - Cachorro");
    System.out.println("2 - Gato");
    System.out.print("Escolha: ");
    int tipo = sc.nextInt();
    sc.nextLine();

    // --- DADOS COMUNS DO ANIMAL ---
    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Ano de nascimento: ");
    int ano = sc.nextInt();
    sc.nextLine();

    System.out.print("Sexo: ");
    String sexo = sc.nextLine();

    // --- CADASTRO ESPECÍFICO DEPENDENDO DO TIPO ---
    if (tipo == 1) {
      // Cachorro → pede raça
      System.out.print("Raça: ");
      String raca = sc.nextLine();
      lista.add(new Cachorro(nome, ano, sexo, raca, dono));

    } else {
      // Gato → pede cor
      System.out.print("Cor: ");
      String cor = sc.nextLine();
      lista.add(new Gato(nome, ano, sexo, cor, dono));
    }

    System.out.println("Animal cadastrado com sucesso! Dono: " + dono.getNome());
  }

  /**
   * Lista todos os animais cadastrados.
   */
  public void listar() {
    lista.forEach(System.out::println);
  }

  /**
   * Busca um animal pelo nome. Retorna o primeiro encontrado ou null.
   */
  public Animal buscar(String nome) {
    return lista.stream()
        .filter(a -> a.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
  }

  /**
   * Retorna a lista completa de animais.
   */
  public ArrayList<Animal> getLista() {
    return lista;
  }

  public void listarServicosDoAnimal(Scanner sc) {

    if (lista.isEmpty()) {
      System.out.println("Nenhum animal cadastrado!");
      return;
    }

    System.out.println("\n=== SERVIÇOS DO ANIMAL ===");

    for (int i = 0; i < lista.size(); i++) {
      System.out.println((i + 1) + " - " + lista.get(i).getNome());
    }

    System.out.print("Escolha o animal: ");
    int opc = sc.nextInt() - 1;
    sc.nextLine();

    if (opc < 0 || opc >= lista.size()) {
      System.out.println("Animal inválido.");
      return;
    }

    Animal animal = lista.get(opc);

    if (animal.getServicos().isEmpty()) {
      System.out.println("Nenhum serviço aplicado ainda.");
      return;
    }

    System.out.println("\nServiços realizados:");
    animal.getServicos().forEach(s -> System.out.println("- " + s.getTipo() + " | R$ " + s.getPreco()));

    System.out.println("TOTAL: R$ " + animal.calcularTotalServicos());
  }

}
