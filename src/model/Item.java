package model;

public class Item {
  private final String nome;
  private final double preco;

  public Item(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  @Override
  public String toString() {
    return nome + " - R$ " + preco;
  }
}
