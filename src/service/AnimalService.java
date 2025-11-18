package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;
import model.Cachorro;
import model.Gato;

public class AnimalService {

  private final ArrayList<Animal> lista = new ArrayList<>();

  public void cadastrar(Scanner in) {
    System.out.println("1 - Cachorro | 2 - Gato");
    int tipo = in.nextInt();
    in.nextLine();

    System.out.print("Nome: ");
    String nome = in.nextLine();
    System.out.print("Ano nascimento: ");
    int ano = in.nextInt();
    in.nextLine();
    System.out.print("Sexo: ");
    String sexo = in.nextLine();

    if (tipo == 1) {
      System.out.print("Raça: ");
      String raca = in.nextLine();
      lista.add(new Cachorro(nome, ano, sexo, raca));
    } else {
      System.out.print("Cor: ");
      String cor = in.nextLine();
      lista.add(new Gato(nome, ano, sexo, cor));
    }

    System.out.println("Animal cadastrado!");
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

  public void remover(String nome) {
    Animal a = buscar(nome);
    if (a != null) {
      lista.remove(a);
      System.out.println("Removido!");
    } else {
      System.out.println("Não encontrado.");
    }
  }

  public ArrayList<Animal> getLista() {
    return lista;
  }
}
