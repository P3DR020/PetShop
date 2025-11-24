package model;

/**
 * Classe Pessoa — classe pai utilizada para herança.
 * Serve como base para outras classes que possuem nome e idade,
 * como a classe Cliente.
 */
public class Pessoa {

  // Nome da pessoa
  protected String nome;

  // Idade da pessoa
  protected int idade;

  /**
   * Construtor que inicializa nome e idade.
   */
  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  // Getters
  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  // Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }
}
