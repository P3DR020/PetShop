package model;

public class Item {
  private String nome;
  private double preco;

  public Item(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  @Override
  public String toString() {
    return nome + " - R$ " + preco;
  }
}
