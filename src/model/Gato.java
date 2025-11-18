package model;

public class Gato extends Animal {
  private final String cor;

  public Gato(String nome, int ano, String sexo, String cor) {
    super(nome, ano, sexo);
    this.cor = cor;
  }

  @Override
  public String toString() {
    return "Gato - Nome: " + nome + " | Ano: " + anoNascimento +
        " | Sexo: " + sexo + " | Cor: " + cor;
  }
}
