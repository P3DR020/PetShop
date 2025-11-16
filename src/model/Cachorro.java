package model;

public class Cachorro extends Animal {
  private String raca;

  public Cachorro(String nome, int ano, String sexo, String raca) {
    super(nome, ano, sexo);
    this.raca = raca;
  }

  @Override
  public String toString() {
    return "Cachorro - Nome: " + nome + " | Ano: " + anoNascimento +
        " | Sexo: " + sexo + " | Raça: " + raca;
  }
}
