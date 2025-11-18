package model;

public class Gato extends Animal {

  private final String cor;

  public Gato(String nome, int ano, String sexo, String cor, Cliente dono) {
    super(nome, ano, sexo, dono);
    this.cor = cor;
  }

  @Override
  public String toString() {
    return "Gato: " + nome +
        " | Cor: " + cor +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
