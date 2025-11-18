package model;

public class Cachorro extends Animal {

  private final String raca;

  public Cachorro(String nome, int ano, String sexo, String raca, Cliente dono) {
    super(nome, ano, sexo, dono);
    this.raca = raca;
  }

  @Override
  public String toString() {
    return "Cachorro: " + nome +
        " | Raça: " + raca +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
