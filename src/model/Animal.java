package model;

/**
 * Classe Animal — Superclasse para Cachorro e Gato.
 * Armazena informações básicas de qualquer animal do PetShop.
 */
public class Animal {

  // Nome do animal
  protected String nome;

  // Ano em que o animal nasceu
  protected int anoNascimento;

  // Sexo do animal ("Macho" ou "Fêmea")
  protected String sexo;

  // Cliente que é o dono deste animal
  protected Cliente dono;

  /**
   * Construtor que cria um animal com todas as informações essenciais.
   */
  public Animal(String nome, int anoNascimento, String sexo, Cliente dono) {
    this.nome = nome;
    this.anoNascimento = anoNascimento;
    this.sexo = sexo;
    this.dono = dono;
  }

  /**
   * Retorna o dono do animal.
   */
  public Cliente getDono() {
    return dono;
  }

  /**
   * Retorna o nome do animal.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Representação do animal em formato de texto.
   * Útil para exibição nas listagens.
   */
  @Override
  public String toString() {
    return "Animal: " + nome +
        " | Ano: " + anoNascimento +
        " | Sexo: " + sexo +
        " | Dono: " + dono.getNome();
  }
}
