package model;

/**
 * Classe Gato — herda de Animal.
 * Representa um gato com informação específica de cor.
 */
public class Gato extends Animal {

  // Cor do gato (ex: Cinza, Branco, Laranja)
  private final String cor;

  /**
   * Construtor do Gato.
   * Recebe os atributos gerais do animal e também a cor,
   * chamando o construtor da superclasse Animal.
   */
  public Gato(String nome, int ano, String sexo, String cor, Cliente dono) {
    super(nome, ano, sexo, dono);
    this.cor = cor;
  }

  /**
   * Representação textual do gato.
   * Sobrescreve o toString original da classe Animal.
   */
  @Override
  public String toString() {
    return "Gato: " + nome +
        " | Cor: " + cor +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
