package model;

/**
 * Classe Cachorro — herda de Animal.
 * Representa um cachorro com suas informações específicas.
 */
public class Cachorro extends Animal {

  // Raça do cachorro (ex: Poodle, Pastor Alemão)
  private final String raca;

  /**
   * Construtor do Cachorro.
   * Recebe todos os dados básicos e também a raça,
   * chamando o construtor da classe Animal com 'super'.
   */
  public Cachorro(String nome, int ano, String sexo, String raca, Cliente dono) {
    super(nome, ano, sexo, dono);
    this.raca = raca;
  }

  /**
   * Retorna uma representação em texto do cachorro.
   * Sobrescreve o toString da classe Animal.
   */
  @Override
  public String toString() {
    return "Cachorro: " + nome +
        " | Raça: " + raca +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
