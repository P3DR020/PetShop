package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;
import model.Cachorro;
import model.Cliente;
import model.Gato;

public class AnimalService {

  private final ArrayList<Animal> lista = new ArrayList<>();

  public void cadastrar(Scanner in, ArrayList<Cliente> clientes) {

    if (clientes.isEmpty()) {
      System.out.println("Erro: não há clientes cadastrados!");
      return;
    }

    System.out.println("\n=== CADASTRAR ANIMAL ===");

    // ESCOLHER DONO
    System.out.println("Escolha o dono do animal:");
    for (int i = 0; i < clientes.size(); i++) {
      System.out.println((i + 1) + " - " + clientes.get(i).getNome());
    }

    System.out.print("Dono (número): ");
    int indice = in.nextInt() - 1;
    in.nextLine();

    if (indice < 0 || indice >= clientes.size()) {
      System.out.println("Cliente inválido.");
      return;
    }

    Cliente dono = clientes.get(indice);

    System.out.println("1 - Cachorro");
    System.out.println("2 - Gato");
    System.out.print("Escolha: ");
    int tipo = in.nextInt();
    in.nextLine();

    System.out.print("Nome: ");
    String nome = in.nextLine();

    System.out.print("Ano de nascimento: ");
    int ano = in.nextInt();
    in.nextLine();

    System.out.print("Sexo: ");
    String sexo = in.nextLine();

    if (tipo == 1) {
      System.out.print("Raça: ");
      String raca = in.nextLine();
      lista.add(new Cachorro(nome, ano, sexo, raca, dono));
    } else {
      System.out.print("Cor: ");
      String cor = in.nextLine();
      lista.add(new Gato(nome, ano, sexo, cor, dono));
    }

    System.out.println("Animal cadastrado com sucesso! Dono: " + dono.getNome());
  }

  public void listar() {
    lista.forEach(System.out::println);
  }

  public Animal buscar(String nome) {
    return lista.stream()
        .filter(a -> a.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
  }

  public ArrayList<Animal> getLista() {
    return lista;
  }
}
